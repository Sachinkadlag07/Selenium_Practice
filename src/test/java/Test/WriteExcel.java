package Test;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {

    public static void main(String[] args) throws IOException {

       XSSFWorkbook workbook = new XSSFWorkbook();

       XSSFSheet sheet= workbook.createSheet("Data");

       XSSFRow row1 =sheet.createRow(0);
       row1.createCell(0).setCellValue("Name");
       row1.createCell(1).setCellValue("Age");
       row1.createCell(2).setCellValue("city");

        XSSFRow row2 = sheet.createRow(1);
        row2.createCell(0).setCellValue("Sachin");
        row2.createCell(1).setCellValue(30);
        row2.createCell(2).setCellValue("Pune");

        FileOutputStream  file = new FileOutputStream("C:\\Users\\skadla01\\Downloads\\writefile.xlsx");

        workbook.write(file);

        workbook.close();
        file.close();

        System.out.println("Excel file written successfully");

    }
}
