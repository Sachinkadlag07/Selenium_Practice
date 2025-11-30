package TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class GoogleSearch {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                driver.get("https://www.google.com/");

                driver.findElement(By.name("q")).sendKeys("selenium");

        List<WebElement> list = driver.findElements(By.xpath(" //ul[@role='listbox']//li//div[@role='option']"));

        System.out.println("Total number of suggestions: " + list.size());

        for(WebElement option : list){
            System.out.println(option.getText());
           if(option.getText().equals("selenium download")){
               option.click();
               break;
           }

        }

        driver.quit();





    }
}
