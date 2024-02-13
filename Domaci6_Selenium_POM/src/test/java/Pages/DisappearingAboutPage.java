package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DisappearingAboutPage {
    WebDriver driver;
    WebElement aboutPageTitle;

    public DisappearingAboutPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getAboutPageTitle() {
        return driver.findElement(By.xpath("/html/body/h1"));
    }

    //-------------


    public void checkTheTitleIsDisplayed() {
        Assert.assertTrue(getAboutPageTitle().isDisplayed());
        driver.navigate().back();
        driver.navigate().back();
    }
}
