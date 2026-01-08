package TestCase;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AjaxLoader {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://webdriveruniversity.com/Ajax-Loader/index.html");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

        WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement clickme =mywait.until(ExpectedConditions.elementToBeClickable(By.id("button1")));
        clickme.click();

        String expectedText = "Well done for waiting....!!!";

        String  actualtext = driver.findElement(By.xpath("//h4[text()='Well Done For Waiting....!!!']")).getText();


        Assert.assertEquals(actualtext, expectedText);

        Thread.sleep(2000);

        driver.close();


    }
}
