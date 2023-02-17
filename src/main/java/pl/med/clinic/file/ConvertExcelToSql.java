package pl.med.clinic.file;

import static pl.med.clinic.file.ExcelToCSVConverter.runExcelToCSVConversion;

public class ConvertExcelToSql {

    public static final String DEFAULT_SEPARATOR = "#";
    public static final int MAX_ROW_WIDTH = 8;
    private static final int SHEET_NUM = 0;
    private static final int FIRST_ROW = 2;

    public static final String STR_CSV_FILE = "src/main/resources/icd-9_pl_cm_v_5.68.csv";
    public static final String STR_SQL_FILE = "src/main/resources/insertProcedures.sql";
    private static final String STR_EXCEL_SOURCE = "Files-Upload/main/resources/icd-9_pl_cm_v_5.68.xlsx";
    private static final String STR_DESTINATION = "src/main/resources/";

    public static void main(String[] args) {

        runExcelToCSVConversion(STR_EXCEL_SOURCE, STR_DESTINATION,
                MAX_ROW_WIDTH, SHEET_NUM, FIRST_ROW);

        CSVToSQLConverter.convertCsvToSql(MAX_ROW_WIDTH, DEFAULT_SEPARATOR);

    }

}
