package pl.med.clinic.library;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;

import static pl.med.clinic.library.ConvertExcelToSql.*;

@Slf4j
public class CSVToSQLConverter {

    public static void convertCsvToSql(int maxRowWidth, String separator) {

        File csvFileIn = new File(STR_CSV_FILE);
        File sqlFileOut = new File(STR_SQL_FILE);

        try (Reader in = new FileReader(csvFileIn)) {
            Iterable<CSVRecord> records = CSVFormat.newFormat(DEFAULT_SEPARATOR.charAt(0)).parse(in);

            try (PrintWriter out = new PrintWriter(sqlFileOut)) {
                for (CSVRecord record : records) {
                    String SQLInsert;
                    String recordsSQLInsert = "";
                    for (int i = 0; i < maxRowWidth - 1; i++) {
                        recordsSQLInsert = recordsSQLInsert + record.get(i) + "', '";
                    }
                    recordsSQLInsert = recordsSQLInsert + record.get(maxRowWidth - 1) + "'";
                    SQLInsert = "INSERT INTO procedure (" +
                            "chapter_id, " +
                            "chapter, " +
                            "subchapter_id, " +
                            "subchapter, " +
                            "main_category_id, " +
                            "main_category, " +
                            "detailed_category_id, " +
                            "detailed_category) " +
                            "VALUES ('" +
                            recordsSQLInsert +
                            ");";
                    out.println(SQLInsert);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                log.error("File {} was not found! {}", sqlFileOut, e);
            }
            log.info("SQL file created.");
        } catch (FileNotFoundException e) {
            log.error("File {} was not found! {}", csvFileIn, e);
        } catch (IOException e) {
            log.error("File processing error!", e);
            log.debug("File not processed: {}", STR_CSV_FILE);
        }
    }
}