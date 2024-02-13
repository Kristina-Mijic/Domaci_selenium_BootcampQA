package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class UserProfileAfterLoggingPage {
    WebDriver driver;
    WebElement secureAreaTitle;

    WebElement message;
    WebElement logOutButton;

    public WebElement getMessage() {
        return driver.findElement(By.id("flash"));
    }

    public WebElement getLogOutButton() {
        return driver.findElement(By.cssSelector(".button.secondary.radius"));
    }

    public UserProfileAfterLoggingPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getSecureAreaTitle() {
        return driver.findElement(By.xpath("/html/body/div[2]/div/div/h2"));
    }

    //---------

    public void checkTitleAfterLogin() {
        Assert.assertTrue(getSecureAreaTitle().isDisplayed());
    }

    public void checkTheLoginURL() {
        String successfullyLoginURL = "https://the-internet.herokuapp.com/secure";
        Assert.assertEquals(driver.getCurrentUrl(), successfullyLoginURL);
    }

    public void successfullyMessageAfterLogin() {
        Assert.assertTrue(getMessage().isDisplayed());
    }

    public void errorMessage() {
        Assert.assertTrue(getMessage().isDisplayed());
    }

    public void checkAndCLickOnLogoutButton() {
        Assert.assertTrue(getLogOutButton().isDisplayed());
        getLogOutButton().click();
    }
}
