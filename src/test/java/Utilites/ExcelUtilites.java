package Utilites;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtilites {

    public static String [][] getTestData(String Path,String SheetName) throws IOException {

        FileInputStream file = new FileInputStream(Path);
        XSSFWorkbook workbook  = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheet(SheetName);

        int TotalRows = sheet.getLastRowNum();
        int TotalCols = sheet.getRow(0).getLastCellNum();

        String [][] data = new String[TotalRows-1][TotalCols];

        for(int r=1; r<TotalRows; r++){

            XSSFRow currentrow = sheet.getRow(r);

            for(int c=0;c<TotalCols;c++){

                XSSFCell cell = currentrow.getCell(c);

                data[r-1][c]=cell.toString();

            }
        }

        workbook.close();
        file.close();

        return data;
    }
}
