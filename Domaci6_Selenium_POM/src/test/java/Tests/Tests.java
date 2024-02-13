package Tests;

import Base.BaseTest;
import Pages.HomePage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Tests extends BaseTest {


    @BeforeMethod
    public void pageSetUp() {
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test
    public void addAndRemoveElementsLink() {
        homePage.clickOnAddRemoveElementsMenu();
        addRemoveElementsPage.clickOnAddElementButton();
        addRemoveElementsPage.checkThisPagesURL();
        addRemoveElementsPage.clickOnDeleteButton();
    }

    @Test
    public void clickOnDisappearingElementsLink() {
        homePage.clickOnDisappearingElementsMenu();
        disappearingElementsPage.checkDisappearingElemURL();
        disappearingElementsPage.clickOnAboutLink();
        disappearingAboutPage.checkTheTitleIsDisplayed();
    }

    @Test
    public void clickOnDynamicControlsLink() throws InterruptedException {
        homePage.clickOnDynamicControlsMenu();
        dynamicControlsPage.checkTheTitleIsDisplayed();
        dynamicControlsPage.clickOnRemoveButton();
        dynamicControlsPage.checkMessageAfterClickedRemoveButton();
        dynamicControlsPage.clickOnAddButton();
        dynamicControlsPage.checkMessageAfterClickedAddButton();
    }

    @Test
    public void formLink() {
        homePage.clickOnFormMenu();
        loginFormPage.checkTheLoginPageURL();
        loginFormPage.checkTheLoginTitle();
    }

    @Test
    public void userCanLoginWithValidData() {
        formLink();
        loginFormPage.userValidUsername("tomsmith");
        loginFormPage.userValidPassword("SuperSecretPassword!");
        loginFormPage.clickLoginButton();
    }

    @Test
    public void userCannotLoginWithInvalidData() {
        formLink();
        loginFormPage.userInvalidUsername("kristina");
        loginFormPage.userInvalidPassword("Password");
        loginFormPage.clickLoginButton();
    }

    @Test
    public void userProfileAfterLogging() {
       userCanLoginWithValidData();
        userProfileAfterLoggingPage.checkTheLoginURL();
        userProfileAfterLoggingPage.successfullyMessageAfterLogin();
        userProfileAfterLoggingPage.checkTitleAfterLogin();
        userProfileAfterLoggingPage.checkAndCLickOnLogoutButton();
    }

    @Test
    public void userCannotLoginWithEmptyFields() {
        formLink();
        loginFormPage.usernameEmptyField();
        loginFormPage.passwordEmptyField();
        loginFormPage.clickLoginButton();
        userProfileAfterLoggingPage.errorMessage();
    }
}
