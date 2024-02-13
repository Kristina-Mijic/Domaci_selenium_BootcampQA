package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    WebDriver driver;
    WebElement addRemoveElementsLink;
    WebElement disappearingElementsLink;
    WebElement dynamicControlsLink;
    WebElement formAuthenticationLink;

    public WebElement getFormAuthenticationLink() {
        return driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[21]/a"));
    }

    public WebElement getDynamicControlsLink() {
        return driver.findElement(By.linkText("Dynamic Controls"));
    }

    public WebElement getDisappearingElementsLink() {
        return driver.findElement(By.linkText("Disappearing Elements"));
    }

    public WebElement getAddRemoveElementsLink() {
        return driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[2]/a"));
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //---------------

    public void clickOnAddRemoveElementsMenu() {
        getAddRemoveElementsLink().click();
    }

    public void clickOnDisappearingElementsMenu() {
        getDisappearingElementsLink().click();
    }

    public void clickOnDynamicControlsMenu() {
        getDynamicControlsLink().click();
    }

    public void clickOnFormMenu() {
        getFormAuthenticationLink().click();
    }
}
