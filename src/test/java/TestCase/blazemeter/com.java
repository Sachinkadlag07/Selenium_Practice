package TestCase.blazemeter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class com {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.blazedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement firstdropdown = driver.findElement(By.xpath("//select[@name='fromPort']"));

         Select select1 = new Select(firstdropdown);

         select1.selectByVisibleText("Boston");

         WebElement seconddropdown = driver.findElement(By.xpath("//select[@name='toPort']"));

         Select select2 = new Select(seconddropdown);

         select2.selectByVisibleText("London");

         WebElement flightbutton = driver.findElement(By.xpath("//input[@type='submit']"));
            flightbutton.click();

            int row = driver.findElements(By.xpath("//table[@class='table']//tr")).size();


            String [] pricelist = new String[row-1];

            for(int i=1;i<row; i++) {

                String price = driver.findElement(By.xpath("//table[@class='table']//tr[" + i + "]//td[6]")).getText();

                //System.out.println("Price list of flight: " + pricelist);
                pricelist[i - 1] = price;
            }
            for(String arrayvalue: pricelist){
                System.out.println("Array value: " + arrayvalue);
            }

            Arrays.sort(pricelist);
            String lowestprice = pricelist[0];

            System.out.println("Lowest price of flight: " + lowestprice);

            //find the flight having lowest price

            for(int r=1; r<row; r++){

                String Price =driver.findElement(By.xpath("//table[@class='table']//tr["+r+"]//td[6]")).getText();

                if( Price.equals(lowestprice)){

                    WebElement chooseflightButton = driver.findElement(By.xpath("//table[@class='table']//tr["+r+"]//td[1]/input"));
                    chooseflightButton.click();
                    break;

                }
            }

            WebElement header = driver.findElement(By.xpath("//h2[text()='Your flight from TLV to SFO has been reserved.']"));
            header.isDisplayed();

            driver.findElement(By.id("inputName")).sendKeys("sachin Kadlag");
            driver.findElement(By.id("address")).sendKeys("boston 3 street");
            driver.findElement(By.id("city")).sendKeys("boston");
            driver.findElement(By.id("state")).sendKeys("ma");
            driver.findElement(By.id("zipCode")).sendKeys("02130");
            driver.findElement(By.id("creditCardNumber")).sendKeys("12344556666");
            driver.findElement(By.id("creditCardMonth")).sendKeys("11");
        driver.findElement(By.id("creditCardYear")).sendKeys("2025");
        driver.findElement(By.id("nameOnCard")).sendKeys("sachin kadlag");
        driver.findElement(By.id("rememberMe")).click();
        driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();

        String Atual_textmessge = driver.findElement(By.xpath("//h1[text()='Thank you for your purchase today!']")).getText();

        Assert.assertEquals(Atual_textmessge,"Thank you for your purchase today!");

        Thread.sleep(2000);



        driver.quit();





    }
}
