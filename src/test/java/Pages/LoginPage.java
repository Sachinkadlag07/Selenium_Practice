package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

//Locators
    private By usernameField= By.id("username");
    private By password = By.id("password");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By errorMessage= By.id("errorMsg");

    //constructor
    public LoginPage(WebDriver driver){
        this.driver= driver;
    }

    //Actions
    public void enterusername(String username){

        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterpassword(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }
    public void clickLoginButton(){
        driver.findElement(loginButton).click();
    }
    public String getErrorMessage(){
        return driver.findElement(errorMessage).getText();
    }



}
