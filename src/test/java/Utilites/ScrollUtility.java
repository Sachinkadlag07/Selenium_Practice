package Utilites;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class ScrollUtility {
    WebDriver driver;
    JavascriptExecutor js;

    public ScrollUtility(WebDriver driver){
        this.driver =driver;
        js = (JavascriptExecutor)driver;

    }

    public void scrollToBottom(){
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    public void scrollToTop(){
        js.executeScript("window.scrollTo(0,0)");
    }

    public void scrollToElement(WebElement element){
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    public void scrollByoffset(int x, int y){
        js.executeScript("window.scrollBy("+x+","+y+")");
    }

    public void scrollByFoldByFold() {
        // long height = (long) js.executeScript("return document.body.scrollHeight");
        long lastHeight = (long) js.executeScript("return document.body.scrollHeight");
        long viewportHeight = (long) js.executeScript("return window.innerHeight");

        while(true){
            //scroll down by one viewport height
            js.executeScript("window.scrollBy(0,arguments[0]);", viewportHeight);

            try {
                Thread.sleep(1000); //wait for half a second to load content
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            long newHeight = (long) js.executeScript("return document.body.scrollHeight");

            if(newHeight == lastHeight){
                break; //reached the bottom
            }
            lastHeight = newHeight;
        }
    }

    public void scrolluntilElementFoundAndClick(By locator) throws InterruptedException {
        long lastHeight = (long) js.executeScript("return document.body.scrollHeight");
        long viewportHeight = (long) js.executeScript("return window.innerHeight");

        while(true){

            List<WebElement> elements =driver.findElements(locator);



            if(elements.size()>0){
                js.executeScript("arguments[0].scrollIntoView(true);",elements.get(0));
                elements.get(0).click();
                break;

            }
        }

        js.executeScript("window.scrollBy(0,arguments[0]);", viewportHeight);
        Thread.sleep(500);

        long newHeight = (long) js.executeScript("return document.body.scrollHeight");

        if(newHeight == lastHeight){
            System.out.println("Element not found after reaching the bottom of the page.");
            //reached the bottom


        }

         lastHeight =newHeight;
    }
}
