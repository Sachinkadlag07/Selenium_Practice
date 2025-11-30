package Test;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelRead {

    public static void main(String[] args) throws IOException {

        FileInputStream file = new FileInputStream("C:\\Users\\skadla01\\Downloads\\Test Data -.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(file);

        XSSFSheet sheet = workbook.getSheetAt(0);

         int totalrows = sheet.getLastRowNum();

         int totalcols = sheet.getRow(0).getLastCellNum();

        System.out.println("Total rows: "+totalrows);
        System.out.println("Total cols: "+totalcols);

        for(int r=1; r<=totalrows;r++){

            XSSFRow currentrow = sheet.getRow(r);

            String Bookname = currentrow.getCell(0).toString();
            String purchase_date = currentrow.getCell(1).toString();
            double price = currentrow.getCell(2).getNumericCellValue();
            String Location = currentrow.getCell(3).toString();
            int age = (int)currentrow.getCell(4).getNumericCellValue();


            System.out.println(Bookname + "\t" + purchase_date + "\t" + price + "\t" + Location + "\t" + age);


//            for(int c=0;c<totalcols;c++){
//
//                XSSFCell currentcell = currentrow.getCell(c);
//
//                 System.out.print(currentcell.toString() + "\t");
//
//            }
            System.out.println();


        }

        workbook.close();
        file.close();

    }
}


