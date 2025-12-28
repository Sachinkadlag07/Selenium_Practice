package Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;


public class OSLevelFileUpload {
    static WebDriver driver;

    public static void main(String[] args) throws AWTException {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://practice.expandtesting.com/upload");

        String filePath = "C:\\Users\\skadla01\\OneDrive - dentsu\\Pictures\\Me\\Resume\\Sr QA Engineer Sachin Kadlag 6.6 years.pdf";

        driver.findElement(By.id("fileInput")).sendKeys(filePath);

       // String filePath = "C:\\Users\\skadla01\\C:\Users\skadla01\OneDrive - dentsu\Pictures\Me\Resume\Sr QA Engineer Sachin Kadlag 6.6 years.pdf
        // OneDrive - dentsu\\Pictures\\Me\\Resume\\Sr QA Engineer Sachin Kadlag 6.6 years.pdf";
        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null); // Use Robot to paste path and press Enter
        Robot robot = new Robot();
         robot.delay(2000); // wait for popup to appear
        // Press CTRL+V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        //press Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        System.out.println("File uploaded successfully!");

        driver.findElement(By.id("fileSubmit")).click();


        driver.quit();



    }
}
