package TestCase;

import Utilites.ScrollUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ScrollingTestCase {

 static By casualware = By.xpath("//h2[text()='Casual Wear']");
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://www.nortonmotorcycles.com/en-in");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

       //WebElement ele = driver.findElement(By.xpath("//h3[@id='get-current-url']"));

        ScrollUtility scroll  = new ScrollUtility(driver);

        scroll.scrollToBottom();
        Thread.sleep(2000);
        scroll.scrollToTop();
        Thread.sleep(2000);

       // scroll.scrollByFoldByFold();

        Thread.sleep(2000);

        scroll.scrolluntilElementFoundAndClick(casualware);




        //js.executeScript("arguments[0].scrollIntoView({behavior:'smooth'});",ele);
        //js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

        Thread.sleep(5000);

        driver.quit();

        ;
    }
}
