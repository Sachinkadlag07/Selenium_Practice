package TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

import static org.bouncycastle.oer.its.template.ieee1609dot2.basetypes.Ieee1609Dot2BaseTypes.Duration;

public class table2 {

    public static void main(String[] args) {

         WebDriver driver=  new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(4));
        driver.get("https://practice.expandtesting.com/dynamic-table");

        int row= driver.findElements(By.xpath("//table[@class='table table-striped']//tr")).size();
        System.out.println("number of row in table :"+row);
       // String CPU=null;
        for(int i=1;i<row;i++){

            String browserName= driver.findElement(By.xpath("//table[@class='table table-striped']//tr["+i+"]//td[1]")).getText();

            if(browserName.equals("Chrome")){

                String CPU = driver.findElement(By.xpath("//table[@class='table table-striped']//tr["+i+"]//td[2]")).getText();
                System.out.println("CPU value for chrome is :"+CPU);
                break;
            }
        }

         String Yellow_text = driver.findElement(By.xpath("//p[@id='chrome-cpu']")).getText();

        //Assert.assertEquals(CPU,Yellow_text);

    }
}
