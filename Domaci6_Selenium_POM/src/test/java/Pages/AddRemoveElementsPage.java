package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class AddRemoveElementsPage {
    WebDriver driver;
    WebElement addElementButton;

    public WebElement getDeleteButton() {
        return driver.findElement(By.cssSelector("button[onclick='deleteElement()']"));
    }

    WebElement deleteButton;

    public WebElement getAddElementButton() {
        return driver.findElement(By.cssSelector("button[onclick='addElement()']"));
    }

    public AddRemoveElementsPage(WebDriver driver) {
        this.driver = driver;
    }

    //-------------

    public void clickOnAddElementButton() {
        getAddElementButton().click();
    }

    public void clickOnDeleteButton() {
        getDeleteButton().click();
        driver.navigate().back();
    }

    public void checkThisPagesURL() {
        String addRemoveElemURL = "https://the-internet.herokuapp.com/add_remove_elements/";
        Assert.assertEquals(driver.getCurrentUrl(), addRemoveElemURL);
    }
}
