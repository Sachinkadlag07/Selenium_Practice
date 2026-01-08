package TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class RedBusAutomation {



    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.redbus.in/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        driver.findElement(By.id("srcinput")).sendKeys("Pune");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'listHeader')]")));

        List<WebElement> suggestions = driver.findElements(By.xpath("//div[contains(@class,'listHeader')]"));

        for(WebElement suggestion : suggestions){
            System.out.println(suggestion.getText());
            if(suggestion.getText().equals("Pune")){
                suggestion.click();
                break;
            }
        }

        
        driver.findElement(By.id("destinput")).sendKeys("Mumbai");

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'listHeader')]")));


        List<WebElement> suggestions1 = driver.findElements(By.xpath("//div[contains(@class,'listHeader')]"));

        for(WebElement suggestion : suggestions1){
            System.out.println(suggestion.getText());
            if(suggestion.getText().equals("Mumbai")){
                suggestion.click();
                break;
            }
        }

        WebElement calanderinput = driver.findElement(By.xpath("//span[text()='Date of Journey']"));

         JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", calanderinput);


        while (true){

            String displaytext = driver.findElement(By.xpath("//div[contains(@class,'monthYearHolidayWrap')]")).getText();

            System.out.println(displaytext);

            if(displaytext.contains("January") && displaytext.contains("2026")){
                break;
            }
            else{
                driver.findElement(By.xpath("//i[contains(@aria-label,'Next month')]")).click();
            }
        }

        //day selection

        List<WebElement> days = driver.findElements(By.xpath("//li[contains(@class,'dateItem')]"));

        for(WebElement day : days){
            String daytext = day.getText();
            if(daytext.equals("15")){
                day.click();
                break;
            }
        }

        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[@aria-label='Search buses']")).click();

        //button[@aria-label='Search buses']










    }
}
