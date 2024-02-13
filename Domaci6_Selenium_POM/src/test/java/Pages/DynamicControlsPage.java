package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.time.Instant;

public class DynamicControlsPage {
    WebDriver driver;
    WebElement dynamicControlPageTitle;
    WebElement removeButton;
    WebElement addButton;
    WebElement messageAfterClickRemoveButton;
    WebElement messageAfterClickAddButton;

    public DynamicControlsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getDynamicControlPageTitle() {
        return driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/h4[1]"));
    }

    public WebElement getRemoveButton() {
        return driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[1]/button"));
    }

    public WebElement getAddButton() {
        return driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[1]/button"));
    }

    public WebElement getMessageAfterClickRemoveButton() {
        return driver.findElement(By.id("message"));
    }

    public WebElement getMessageAfterClickAddButton() {
        return driver.findElement(By.id("message"));
    }


    //------------------

    public void checkTheTitleIsDisplayed() {
        Assert.assertTrue(getDynamicControlPageTitle().isDisplayed());
    }

    public void clickOnRemoveButton() {
        getRemoveButton().click();
    }

    public void checkMessageAfterClickedRemoveButton() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(getMessageAfterClickRemoveButton().isDisplayed());
    }

    public void clickOnAddButton() {
        getAddButton().click();
    }

    public void checkMessageAfterClickedAddButton() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(getMessageAfterClickAddButton().isDisplayed());

        driver.navigate().back();
    }




}
