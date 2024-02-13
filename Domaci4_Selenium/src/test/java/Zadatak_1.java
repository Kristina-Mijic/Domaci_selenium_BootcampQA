import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Zadatak_1 {
    //Koristeci Anotacije - Ulogujte se na demoqa(https://demoqa.com/ -> Book Store Application) preko cookies-a,
    // dodati dve knjige na svoj nalog, zatim se izlogovati brisanjem cookies-a.
    //Ulogovati se ponovo preko log-in forme i potvrditi da se knjige i dalje nalaze na nalogu

    WebDriver driver;
    WebElement usernameInputField;
    WebElement passwordInputField;
    WebElement loginButton;
    WebElement bookStoreLink;
    WebElement firstBook;
    WebElement secondBook;
    WebElement addToYouCollectionButton;
    WebElement backToBookStoreButton;
    WebDriverWait wait;
    String validUsername, validPassword, loggedInURL;


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        validUsername = "kristinam";
        validPassword = "Password123!";
        loggedInURL = "https://demoqa.com/profile";
    }

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));

        List<WebElement> bookStore = driver.findElements(By.cssSelector(".card.mt-4.top-card"));
        bookStore.get(5).click();

        WebElement loginMenuLink = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[1]"));
        loginMenuLink.click();

        usernameInputField = driver.findElement(By.id("userName"));
        passwordInputField = driver.findElement(By.id("password"));
        loginButton = driver.findElement(By.id("login"));

    }

    @Test (priority = 10)
    public void userCanLoginAndAddBooks() throws InterruptedException {

        usernameInputField.clear();
        usernameInputField.sendKeys(validUsername);

        passwordInputField.clear();
        passwordInputField.sendKeys(validPassword);
        loginButton.click();

        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[2]"))));
        bookStoreLink = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[6]/div/ul/li[2]"));
        bookStoreLink.click();

        Assert.assertNotEquals(driver.getCurrentUrl(), loggedInURL);

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.linkText("Git Pocket Guide"))));
        firstBook = driver.findElement(By.linkText("Git Pocket Guide"));
        firstBook.click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[2]/button"))));
        addToYouCollectionButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[2]/button"));
        addToYouCollectionButton.click();

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
            System.out.println(e);
        }

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[1]/button"))));
        backToBookStoreButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[1]/button"));
        backToBookStoreButton.click();

        secondBook = driver.findElement(By.linkText("Learning JavaScript Design Patterns"));
        secondBook.click();


        addToYouCollectionButton = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/div[2]/div[9]/div[2]/button"));
        addToYouCollectionButton.click();

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert2 = driver.switchTo().alert();
            alert2.accept();
        } catch (Exception e) {
            System.out.println(e);
        }

        WebElement logOutButton = driver.findElement(By.id("submit"));
        logOutButton.click();

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }

    @Test (priority = 20)
    public void isThereExistedBooksOnUserProfile() {
        usernameInputField.clear();
        usernameInputField.sendKeys(validUsername);

        passwordInputField.clear();
        passwordInputField.sendKeys(validPassword);
        loginButton.click();

        firstBook = driver.findElement(By.linkText("Git Pocket Guide"));
        Assert.assertTrue(firstBook.isDisplayed());

        secondBook = driver.findElement(By.linkText("Learning JavaScript Design Patterns"));
        Assert.assertTrue(secondBook.isDisplayed());
    }


}
