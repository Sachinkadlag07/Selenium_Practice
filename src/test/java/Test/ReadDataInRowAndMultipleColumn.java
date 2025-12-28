package Test;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class ReadDataInRowAndMultipleColumn {

    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\skadla01\\Downloads\\testrow.xlsx"; // Replace with your Excel file path
        Map<String, String> credentials = new HashMap<>();
        try {
            FileInputStream fis = new FileInputStream(filePath);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);

            XSSFRow userRow = sheet.getRow(0); // first row → usernames
            XSSFRow passRow = sheet.getRow(1); // second row → passwords
          //  HashMap <String, String> credentials = new HashMap<>();
            int totalColumns = userRow.getLastCellNum();
            for (int col = 1; col < totalColumns; col++)
            { String username = userRow.getCell(col).getStringCellValue();
                String password = passRow.getCell(col).getStringCellValue();
                credentials.put(username, password); } // Print all username–password pairs
           // credentials.forEach((u, p) -> System.out.println("Username: " + u + " | Password: " + p));
            wb.close();
            fis.close(); }
        catch (Exception e)
        { e.printStackTrace(); }

        // Print the map
        System.out.println("Credentials: " + credentials);

    }
}



