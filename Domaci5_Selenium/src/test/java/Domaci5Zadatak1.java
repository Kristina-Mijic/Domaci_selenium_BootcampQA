import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Domaci5Zadatak1 {

    //Domaci Zadatak 2:
    //Otici na sajt Herkouapp(https://the-internet.herokuapp.com/)
    // i napisati sto vise test case-eva (Vas izbor sta cete testirati).

    WebDriver driver;
    WebElement addRemoveElements;
    WebElement addElementButton;
    WebElement deleteElementButton;
    WebElement disappearingElementsMenu;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();


    }

    @BeforeMethod
    public void homePageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(3L));

        WebElement welcomeHomeTitle = driver.findElement(By.className("heading"));
        Assert.assertTrue(welcomeHomeTitle.isDisplayed());

        WebElement availableExamplesTitle = driver.findElement(By.xpath("/html/body/div[2]/div/h2"));
        Assert.assertTrue(availableExamplesTitle.isDisplayed());
    }

    @Test
    public void addRemoveElementsMenu() {
        addRemoveElements = driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[2]/a"));
        addRemoveElements.click();

        String addRemoveElemURL = "https://the-internet.herokuapp.com/add_remove_elements/";
        Assert.assertEquals(driver.getCurrentUrl(), addRemoveElemURL);

        addElementButton = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        addElementButton.click();

        deleteElementButton = driver.findElement(By.cssSelector("button[onclick='deleteElement()']"));
        Assert.assertTrue(deleteElementButton.isDisplayed());
        deleteElementButton.click();

        driver.navigate().back();
    }

    @Test
    public void disappearingElementsMenu() {
        disappearingElementsMenu = driver.findElement(By.linkText("Disappearing Elements"));
        disappearingElementsMenu.click();

        String disappearingElemURL = "https://the-internet.herokuapp.com/disappearing_elements";
        Assert.assertEquals(driver.getCurrentUrl(), disappearingElemURL);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[2]/div/div/h3"))));
        WebElement title = driver.findElement(By.xpath("/html/body/div[2]/div/div/h3"));
        Assert.assertTrue(title.isDisplayed());

        WebElement aboutNav = driver.findElement(By.linkText("About"));
        aboutNav.click();

        WebElement aboutPageTitle = driver.findElement(By.xpath("/html/body/h1"));
        Assert.assertTrue(aboutPageTitle.isDisplayed());

        driver.navigate().back();
    }

    @Test
    public void dynamicControlsMenu() {
        WebElement dynamicControls = driver.findElement(By.linkText("Dynamic Controls"));
        dynamicControls.click();

        WebElement dynamicControlsPageTitle = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/h4[1]"));
        Assert.assertTrue(dynamicControlsPageTitle.isDisplayed());

        WebElement removeButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[1]/button"));
        removeButton.click();
        WebElement messageAfterClickedRemoveButton = driver.findElement(By.id("message"));
        Assert.assertTrue(messageAfterClickedRemoveButton.isDisplayed());


        WebElement addButton = driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/form[1]/button"));
        Assert.assertTrue(addButton.isDisplayed());
        addButton.click();

        WebElement messageAfterClickedAddButton = driver.findElement(By.id("message"));
        Assert.assertTrue(messageAfterClickedAddButton.isDisplayed());

        driver.navigate().back();
    }

    @Test
    public void formAuthenticationMenu() {
        WebElement formAuthentication = driver.findElement(By.xpath("/html/body/div[2]/div/ul/li[21]/a"));
        formAuthentication.click();

        String formAuthenticationURL = "https://the-internet.herokuapp.com/login";
        Assert.assertEquals(driver.getCurrentUrl(), formAuthenticationURL);

        WebElement loginPageTitle = driver.findElement(By.xpath("/html/body/div[2]/div/div/h2"));
        Assert.assertTrue(loginPageTitle.isDisplayed());
    }

    @Test
    public void userCanLoginFormAuthentication() {
        formAuthenticationMenu();

        String validUsername = "tomsmith";
        String validPassword = "SuperSecretPassword!";

        WebElement usernameInputField = driver.findElement(By.id("username"));
        usernameInputField.sendKeys(validUsername);

        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys(validPassword);

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();
        //

        String successfullyLoginURL = "https://the-internet.herokuapp.com/secure";
        Assert.assertEquals(driver.getCurrentUrl(), successfullyLoginURL);

        WebElement secureAreaTitle = driver.findElement(By.xpath("/html/body/div[2]/div/div/h2"));
        Assert.assertTrue(secureAreaTitle.isDisplayed());

        WebElement logoutButton = driver.findElement(By.cssSelector(".button.secondary.radius"));
        logoutButton.click();
    }

    @Test
    public void userCannotLoginWithInvalidDataLoginFormAuthentication() {
        formAuthenticationMenu();

        String invalidUsername = "kristina";
        String invalidPassword = "password";

        WebElement usernameInputField = driver.findElement(By.id("username"));
        usernameInputField.sendKeys(invalidUsername);

        WebElement passwordInputField = driver.findElement(By.id("password"));
        passwordInputField.sendKeys(invalidPassword);

        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector(".flash.error"));
        Assert.assertTrue(errorMessage.isDisplayed());
    }

    @Test
    public void userCannotLoginWithEmptyFieldsLoginFormAuthentication() {
        formAuthenticationMenu();

        WebElement usernameInputField = driver.findElement(By.id("username"));
        WebElement passwordInputField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

        usernameInputField.clear();
        passwordInputField.clear();
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.cssSelector(".flash.error"));
        Assert.assertTrue(errorMessage.isDisplayed());

    }

}
