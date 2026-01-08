package Utilites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitFor {

    WebDriver driver ;
    WebDriverWait wait;

    public WaitFor(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,java.time.Duration.ofSeconds(10));
    }

    public WebElement waitForElementToBeVisible(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementToBeClickable(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public WebElement waitForElementToBePresent(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}
