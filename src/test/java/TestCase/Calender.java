package TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Calender {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement calendertextbox=driver.findElement(By.id("datepicker"));
        calendertextbox.click();


        String date = "15-August-2027";
        String [] dateArray = date.split("-");
        String day = dateArray[0];
        String month = dateArray[1];
        String year = dateArray[2];


        //month and year selection and comparison



        while(true){

            String current_month =   driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
            String current_year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();

            System.out.println(current_month +" "+current_year);

            if(current_year.equals(year) && current_month.equals(month)){
                break;
            }
                //click on next button
                driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();

        }

         //date selection

        List<WebElement> alldays = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tr//td//a"));

        for(WebElement dayElement : alldays){

            if(dayElement.getText().equals(day)){
                dayElement.click();
                break;

            }
        }

        String  selecteddate = driver.findElement(By.id("datepicker")).getAttribute("value");

        System.out.println("selected date is : "+selecteddate);


        driver.quit();

    }
}
