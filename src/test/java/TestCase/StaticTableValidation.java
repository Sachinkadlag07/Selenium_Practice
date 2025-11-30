package TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class StaticTableValidation {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver. manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://testautomationpractice.blogspot.com/");

        //number of total row

        int total_row = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();

        System.out.println(total_row);




    }
}
