package pl.med.clinic.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CSVImportScanner {

    static File csvFileIn = new File("src/main/resources/icd-9_pl_cm_v_5.67.csv");
    static File SQLFileOut = new File("src/main/resources/insertProcedures.sql");

    public static void main(String[] args) {
        CSVImportScanner.readFile(csvFileIn, SQLFileOut);
        //        CSVImport.readCSV();
    }

    public static void readFile(File fileIn, File fileOut) {

        try (Scanner sc = new Scanner(fileIn)) {

            try (PrintWriter out = new PrintWriter(fileOut)) {
                while (sc.hasNextLine()) {
                    String line = sc.nextLine();
                    if (line.contains("'")) {
                        line = line.replace("'", "''");
                    }
                    String[] chunks = line.split(";", 8);

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