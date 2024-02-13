package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginFormPage {
    WebDriver driver;
    WebElement loginPageTitle;
    WebElement usernameField, passwordField;
    WebElement loginButton;
    WebElement secureAreaTitle;


    public WebElement getUsernameField() {
        return driver.findElement(By.id("username"));
    }

    public WebElement getPasswordField() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginButton() {
        return driver.findElement(By.cssSelector("button[type='submit']"));
    }

    public WebElement getLoginPageTitle() {
        return driver.findElement(By.xpath("/html/body/div[2]/div/div/h2"));
    }

    public LoginFormPage(WebDriver driver) {
        this.driver = driver;
    }

    //-------------

    public void checkTheLoginPageURL() {
        String formAuthenticationURL = "https://the-internet.herokuapp.com/login";
        Assert.assertEquals(driver.getCurrentUrl(), formAuthenticationURL);
    }

    public void checkTheLoginTitle() {
        Assert.assertTrue(getLoginPageTitle().isDisplayed());
    }

    public void userValidUsername(String usernameField) {
        getUsernameField().clear();
        getUsernameField().sendKeys(usernameField);
    }

    public void userValidPassword(String passwordField) {
        getPasswordField().clear();
        getPasswordField().sendKeys(passwordField);
    }

    public void clickLoginButton() {
        getLoginButton().click();
    }

    //

    public void userInvalidUsername(String invalidUsernameField) {
        getUsernameField().clear();
        getUsernameField().sendKeys(invalidUsernameField);
    }

    public void userInvalidPassword(String invalidPasswordField) {
        getPasswordField().clear();
        getPasswordField().sendKeys(invalidPasswordField);
    }

    //

    public void usernameEmptyField() {
        getUsernameField().clear();
    }

    public void passwordEmptyField() {
        getPasswordField().clear();
    }
}
