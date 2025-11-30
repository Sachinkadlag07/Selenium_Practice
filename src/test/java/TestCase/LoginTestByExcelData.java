package TestCase;

import org.testng.annotations.DataProvider;
import Utilites.ExcelUtilites;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestByExcelData {

    @DataProvider(name = "LoginData",indices = {})
    public Object[][] getLoginData() throws IOException {
        return ExcelUtilites.getTestData("C:\\Users\\skadla01\\IdeaProjects\\NortonCheckURL\\TestData\\test Data for EXcel.xlsx", "Sheet1");
    }

    @Test(dataProvider = "LoginData")
    public void LoginTest(String username, String password) {
        System.out.println("Username: " + username + ", Password: " + password);
        // Add your login test logic here
    }
}