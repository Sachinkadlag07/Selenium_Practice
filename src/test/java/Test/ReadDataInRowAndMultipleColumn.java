package Test;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class ReadDataInRowAndMultipleColumn {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\skadla01\\Downloads\\testrow.xlsx"; // Replace with your Excel file path
        Map<String, String> credentials = new HashMap<>();

        try
                (FileInputStream fis = new FileInputStream(filePath);
                 Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // First sheet


            // Skip header row
            int rowCount = sheet.getPhysicalNumberOfRows();


            // Read rows

            for (int i = 0; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                if (row != null) {
                    Cell usernameCell = row.getCell(0); // Column A: User name
                    Cell passwordCell = row.getCell(1); // Column B: Password


                    if (usernameCell != null && passwordCell != null) {
                        String username = usernameCell.getStringCellValue().trim();
                        String password = passwordCell.getStringCellValue().trim();
                        credentials.put(username, password);
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print the map
        System.out.println("Credentials: " + credentials);

    }
}



