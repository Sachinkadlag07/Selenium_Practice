package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SVGClicking {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();;
        driver.manage().window().maximize();
        driver.get("https://uat.nortonmotorcycles.com/en-in");
        driver.findElement(By.xpath("//button[@aria-label='Open menu']//*[name()='svg']")).click();
        Thread.sleep(2000);
        driver.quit();

    }
}
