package TestCase;

import com.tvsmotoriqube.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.Arrays;

public class DynamicTable {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://demo.guru99.com/test/web-table-element.php");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

         int row = driver.findElements(By.xpath("//table[@class='dataTable']//tr")).size();

         System.out.println("number of row in table :"+row);

         //lowest current price

        float []  pricelist = new float [row-1];

         for(int i=1;i<row;i++){

          float price= Float.parseFloat(driver.findElement(By.xpath("//table[@class='dataTable']//tr["+i+"]//td[4]")).getText());

          pricelist[i-1]=price;

         }
         for(float num:pricelist){
             System.out.println("price value : "+num);
         }

         Arrays.sort(pricelist);
        System.out.println("lowest price is : "+pricelist[0]);
        System.out.println("Higest price is : "+pricelist[pricelist.length-1]);

        float lowestprice = pricelist[0];
        float higestprice =pricelist[pricelist.length-1];

        //System.out.println(Arrays.toString(pricelist));

        for(int i=1;i<row;i++){

           float pricefromtable= Float.parseFloat(driver.findElement(By.xpath("//table[@class='dataTable']//tr["+i+"]//td[4]")).getText());

           if(pricefromtable==(higestprice)){

             WebElement companyelement =  driver.findElement(By.xpath("//table[@class='dataTable']//tr["+i+"]//td[1]"));
               System.out.println("company name with lowest price :"+companyelement.getText());

               //click on company name

               companyelement.click();
               break;

           }
        }


        driver.quit();




    }


}
