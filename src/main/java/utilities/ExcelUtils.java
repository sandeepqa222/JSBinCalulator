package utilities;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import static org.apache.poi.ss.usermodel.Row.MissingCellPolicy.RETURN_BLANK_AS_NULL;

public class ExcelUtils {
    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;
    private static XSSFRow Row;

    public static String getExcelPath() {
        return System.getProperty("user.dir") + "/src/main/resources/testData.xlsx";
    }

    static void setExcelFile() throws Exception {
        try {
            FileInputStream ExcelFile = new FileInputStream(getExcelPath());
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet("Sheet1");
        } catch (Exception e) {
            throw (e);
        }
    }

    public static String getCellData(int RowNum, int ColNum) {
        try {
            setExcelFile();
            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            return Cell.getStringCellValue();
        } catch (Exception e) {
            return "";
        }

    }

    public static String getCellData(String testName, String ColName) {
        try {
            setExcelFile();
            int rownumber = -1;
            int columnnumber = -1;
            for (int i = 0; i < ExcelWSheet.getLastRowNum(); i++) {
                String testname = ExcelWSheet.getRow(i).getCell(0).getStringCellValue();
                if (testName.equalsIgnoreCase(testname)) {
                    rownumber = i;
                    break;
                }
            }
            for (int j = 0; j < ExcelWSheet.getRow(0).getLastCellNum(); j++) {
                String columnName = ExcelWSheet.getRow(0).getCell(j).getStringCellValue();
                if (columnName.equalsIgnoreCase(ColName)) {
                    columnnumber = j;
                    break;
                }
            }

            Cell = ExcelWSheet.getRow(rownumber).getCell(columnnumber);
            return Cell.getStringCellValue();
        } catch (Exception e) {
            return "";
        }

    }


    //This method is to write in the Excel cell, Row num and Col num are the parameters

    public static void setCellData(String Result, int RowNum, int ColNum) throws Exception {

        try {
            setExcelFile();
            Row = ExcelWSheet.getRow(RowNum);
            Cell = Row.getCell(ColNum, RETURN_BLANK_AS_NULL);
            if (Cell == null) {
                Cell = Row.createCell(ColNum);
                Cell.setCellValue(Result);
            } else {
                Cell.setCellValue(Result);
            }
            FileOutputStream fileOut = new FileOutputStream(getExcelPath());
            ExcelWBook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (Exception e) {
            throw (e);
        }

    }

}