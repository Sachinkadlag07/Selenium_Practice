package Utilites;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionHelper {
    WebDriver driver;
    Actions act;

    public ActionHelper(WebDriver driver){
        this.driver = driver;
        act =new Actions(driver);
    }

    public void moveToElement(WebElement element){

        act.moveToElement(element).build().perform();
    }

    public void moveToElementAndClick(WebElement element){
        act.moveToElement(element).click().build().perform();
        //act.moveToElement(element).click().build().perform();
    }
    public void dragAndDrop(WebElement source,WebElement target){
        act.dragAndDrop(source,target).build().perform();
    }

    public void rightClick(WebElement element){
        act.contextClick(element).build().perform();
    }

    public void doubleClick(WebElement element){
        act.doubleClick(element).build().perform();
    }
    public void clickAndHold(WebElement element){

        act.clickAndHold(element).build().perform();
    }

    public void releaseClick(){
        act.release().build().perform();
    }
    public void sendKeys(WebElement element, String text){

        act.sendKeys(element,text).build().perform();
    }
     public void dragAndDropByOffset(WebElement element, int x, int y) {
         act.dragAndDropBy(element, x, y).build().perform();
     }

     public void selectAllText(WebElement element){
         act.click(element).keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();
     }

     public void copyText(WebElement element){
         act.click(element).keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).build().perform();
     }

     public void pasteText(WebElement element){
         act.click(element).keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).build().perform();
     }

     public void clickenter(){
         act.sendKeys(Keys.ENTER).build().perform();
         act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
     }


}

