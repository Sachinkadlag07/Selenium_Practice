package TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;

public class calenderwithdropdown {

    private static final Logger log = LoggerFactory.getLogger(calenderwithdropdown.class);

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement  calenderelement = driver.findElement(By.id("txtDate"));

        calenderelement.click();

        String date  = "29-Aug-2027";
        String [] dateArray = date.split("-");
        String day = dateArray[0];
        String month = dateArray[1];
        String year = dateArray[2];

        // select year

        WebElement yearDropdown = driver.findElement(By.className("ui-datepicker-year"));
        Select selectYear = new Select(yearDropdown);
        selectYear.selectByVisibleText(year);

        WebElement monthDropdown = driver.findElement(By.className("ui-datepicker-month"));
        Select selectMonth = new Select(monthDropdown);
        selectMonth.selectByVisibleText(month);

        // select date

       List<WebElement> daysarry = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td//a"));

       for(WebElement dayElement : daysarry){
           if(dayElement.getText().equals(day)){
               dayElement.click();
               break;
           }
       }

      String inputvalue =  calenderelement.getAttribute("value");
        System.out.println(inputvalue);

       driver.quit();







    }
}
