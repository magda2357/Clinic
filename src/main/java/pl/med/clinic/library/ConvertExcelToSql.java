package pl.med.clinic.library;

import static pl.med.clinic.library.ExcelToCSVConverter.runExcelToCSVConversion;

public class ConvertExcelToSql {

    public static final int EXCEL_STYLE_ESCAPING = 0;
    public static final int UNIX_STYLE_ESCAPING = 1;
    public static final String DEFAULT_SEPARATOR = ",";
    public static final int MAX_ROW_WIDTH = 8;
    private static final int SHEET_NUM = 0;
    private static final int FIRST_ROW = 2;

    public static final String STR_CSV_FILE = "src/main/resources/icd-9_pl_cm_v_5.68.csv";
    public static final String STR_SQL_FILE = "src/main/resources/insertProcedures.sql";
    private static final String STR_EXCEL_SOURCE = "src/main/resources/icd-9_pl_cm_v_5.68.xlsx";
    private static final String STR_DESTINATION = "src/main/resources/";

    public static void main(String[] args) {

        runExcelToCSVConversion(STR_EXCEL_SOURCE, STR_DESTINATION, DEFAULT_SEPARATOR, EXCEL_STYLE_ESCAPING,
                MAX_ROW_WIDTH, SHEET_NUM, FIRST_ROW);

        CSVToSQLConverter.convertCsvToSql(MAX_ROW_WIDTH, DEFAULT_SEPARATOR);

    }

}
