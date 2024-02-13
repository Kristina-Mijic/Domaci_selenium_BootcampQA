package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DisappearingElementsPage {
    WebDriver driver;
    WebElement aboutNavigationLink;
    WebElement disappearingPageTitle;
    WebElement aboutPageTitle;

    public WebElement getDisappearingPageTitle() {
        return  driver.findElement(By.xpath("/html/body/div[2]/div/div/h3"));
    }

    public WebElement getAboutPageTitle() {
        return driver.findElement(By.xpath("/html/body/h1"));
    }

    public WebElement getAboutNavigationLink() {
        return driver.findElement(By.linkText("About"));
    }

    public DisappearingElementsPage(WebDriver driver) {
        this.driver = driver;
    }



    //---------------

    public void clickOnAboutLink() {
        getAboutNavigationLink().click();
    }

    public void checkDisappearingElemURL() {
        String disappearingElemURL = "https://the-internet.herokuapp.com/disappearing_elements";
        Assert.assertEquals(driver.getCurrentUrl(), disappearingElemURL);
    }

}
