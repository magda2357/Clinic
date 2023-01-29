package pl.med.clinic.library;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import static pl.med.clinic.library.ConvertExcelToSql.*;

public class CSVToSQLConverter {

    public static void convertCsvToSql(int maxRowWidth, String separator) {

        File csvFileIn = new File(STR_CSV_FILE);
        File sqlFileOut = new File(STR_SQL_FILE);

        try (Scanner sc = new Scanner(csvFileIn)) {

            try (PrintWriter out = new PrintWriter(sqlFileOut)) {
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    String[] chunks = line.split(separator, maxRowWidth);

                    String SQLInsert;
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
                            chunks[0] + "', '" +
                            chunks[1] + "', '" +
                            chunks[2] + "', '" +
                            chunks[3] + "', '" +
                            chunks[4] + "', '" +
                            chunks[5] + "', '" +
                            chunks[6] + "', '" +
                            chunks[7] + "');";
                    out.println(SQLInsert);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            System.out.println("File created");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}