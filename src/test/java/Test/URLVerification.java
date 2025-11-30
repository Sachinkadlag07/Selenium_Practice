package Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class URLVerification {

   static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

        //driver.get("https://at.nortonmotorcycles.com/");
        //uat store url
        driver.get("https://uat-norton-store.myshopify.com/en-gb/collections/casual-wear");

        driver.findElement(By.id("password")).sendKeys("uat-norton-555");
        driver.findElement(By.xpath("//button[@type='submit']")).click();


        Thread.sleep(2000);

        List<WebElement> links  =driver.findElements(By.tagName("a"));
        System.out.println("Total number of links are : " + links.size());


        for(WebElement link :links){
              String url=  link.getAttribute("href");

              if (url ==null ||url.isEmpty()){
                  System.out.println(link + ": Href does not have any value");
                  continue;
              }

           try {

               HttpsURLConnection connection = (HttpsURLConnection) new URL(url).openConnection();


               connection.setRequestMethod("HEAD");
               connection.connect();
               int responsecode = connection.getResponseCode();
               ;

               if (responsecode >= 400) {
                   System.out.println(url + " Is Broken Link");
               } else {

                   System.out.println(url + "  Not Broken Link");
               }

           }catch(Exception e){
               e.printStackTrace();
           }

        }

        driver.quit();





    }
}
