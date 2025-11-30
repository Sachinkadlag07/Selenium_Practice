package TestCase.Testcase;
//import PageObjectModel.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class LoginFlowTestCase {
    WebDriver driver;
    LoginPage loginPage;
    //HomePage homePage;

    @BeforeClass
    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/login");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void validLoginTest() {
        loginPage.enterusername("tomsmith");
        loginPage.enterpassword("SuperSecretPassword!");
        loginPage.clickLoginButton();

        //homePage = new HomePage(driver);
     //   Assert.assertEquals(homePage.getHeaderText(), "Secure Area");
    }



    @AfterClass//  this will run each beo
    public void tearDown() {
        driver.quit();
    }
}



