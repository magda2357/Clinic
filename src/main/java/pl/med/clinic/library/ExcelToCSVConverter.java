package pl.med.clinic.library;

import org.apache.poi.ss.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static pl.med.clinic.library.ConvertExcelToSql.DEFAULT_SEPARATOR;

public class ExcelToCSVConverter {

    private static final String CSV_FILE_EXTENSION = ".csv";
    private List<ArrayList<String>> csvData;
    private static final Logger logger = LoggerFactory.getLogger(ExcelToCSVConverter.class);

    public static void runExcelToCSVConversion(String strSource, String strDestination,
                                               int maxRowWidth, int sheetNum, int firstRow) {
        long startTime = System.currentTimeMillis();
        boolean converted = true;

        try {
            ExcelToCSVConverter converter = new ExcelToCSVConverter();
            converter.convertExcelToCSV(strSource, strDestination,
                    maxRowWidth, sheetNum, firstRow);
        } catch (Exception e) {
            logger.error("Unexpected exception!", e);
            converted = false;
        }

        if (converted) {
            System.out.println("Conversion took " + ((System.currentTimeMillis() - startTime) / 1000) + " seconds");
        }
    }

    private void convertExcelToCSV(String strSource, String strDestination,
                                   int maxRowWidth, int sheetNum, int firstRow)
            throws IOException, IllegalArgumentException {

        File sourceFile = new File(strSource);
        if (!sourceFile.exists()) {
            throw new IllegalArgumentException("The source Excel file cannot be found at " + sourceFile);
        }

        File destination = new File(strDestination);
        if (!destination.exists()) {
            throw new IllegalArgumentException(
                    "The destination directory " + destination + " for the " + "converted CSV file(s) does not exist.");
        }

        if (!destination.isDirectory()) {
            throw new IllegalArgumentException(
                    "The destination " + destination + " for the CSV file is not a directory/folder.");
        }

        FileInputStream fis = null;
        Workbook workbook = null;

        try {
            fis = new FileInputStream(sourceFile);
            logger.info("Opening workbook [{}]", sourceFile.getName());
            workbook = WorkbookFactory.create(fis);

            convertToCSV(workbook, sheetNum, maxRowWidth, firstRow);

            String destinationFilename = sourceFile.getName();
            destinationFilename = destinationFilename.substring(0, destinationFilename.lastIndexOf('.'))
                    + CSV_FILE_EXTENSION;

            saveCSVFile(new File(destination, destinationFilename), maxRowWidth);

        } catch (Exception e) {
            System.out.println("Unexpected exception");
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
            }
            if (workbook != null) {
                workbook.close();
            }
        }
    }

    private String escapeEmbeddedCharacters(String field) {

        StringBuilder buffer;
        if (field.contains("\n")) {
            field = field.replace("\n", "");
        }
        if (field.contains("'")) {
            field = field.replace("'", "''");
        }
        if (field.contains("\"")) {
            buffer = new StringBuilder(field.replace("\"", "\\\"\\\""));
            buffer.insert(0, "\"");
            buffer.append("\"");
        } else {
            buffer = new StringBuilder(field);
            if (buffer.indexOf(DEFAULT_SEPARATOR) > -1) {
                buffer.insert(0, "\"");
                buffer.append("\"");
            }
        }
        return buffer.toString().trim();
    }

    private void convertToCSV(Workbook workbook, int sheetNum, int maxRowWidth, int firstRow) {

        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
        DataFormatter formatter = new DataFormatter(true);

        this.csvData = new ArrayList<>();

        System.out.println("Converting files contents to CSV format.");

        Sheet sheet = workbook.getSheetAt(sheetNum);
        if (sheet.getPhysicalNumberOfRows() > 0) {
            int lastRowNum = sheet.getLastRowNum();
            for (int j = firstRow; j <= lastRowNum; j++) {
                Row row = sheet.getRow(j);
                ArrayList<String> csvLine = new ArrayList<>();

                int lastCellNum = maxRowWidth - 1;
                for (int k = 0; k <= lastCellNum; k++) {
                    Cell cell = row.getCell(k);
                    if (cell == null) {
                        csvLine.add("");
                    } else {
                        if (cell.getCellType() != CellType.FORMULA) {
                            csvLine.add(formatter.formatCellValue(cell));
                        } else {
                            csvLine.add(formatter.formatCellValue(cell, evaluator));
                        }

                    }
                }
                this.csvData.add(csvLine);
            }
        }
    }

    private void saveCSVFile(File file, int maxRowWidth) throws IOException {
        ArrayList<String> line;
        StringBuilder buffer;
        String csvLineElement;

        try (BufferedWriter bw = Files.newBufferedWriter(file.toPath(), StandardCharsets.UTF_8)) {

            System.out.println("Saving the CSV file [" + file.getName() + "]");

            for (int i = 0; i < this.csvData.size(); i++) {
                buffer = new StringBuilder();

                line = this.csvData.get(i);
                for (int j = 0; j < maxRowWidth; j++) {
                    if (line.size() > j) {
                        csvLineElement = line.get(j);
                        if (csvLineElement != null) {
                            buffer.append(escapeEmbeddedCharacters(csvLineElement));
                        }
                    }
                    if (j < (maxRowWidth - 1)) {
                        buffer.append(DEFAULT_SEPARATOR);
                    }
                }

                bw.write(buffer.toString().trim());
                if (i < (this.csvData.size() - 1)) {
                    bw.newLine();
                }
            }
        }
    }

}

