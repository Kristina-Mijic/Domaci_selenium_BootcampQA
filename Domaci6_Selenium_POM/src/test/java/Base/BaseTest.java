package Base;

import Pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    //Domaci Zadatak 1 - (ponedeljak 22.01.2024):
    //Otici na sajt Herkouapp(https://the-internet.herokuapp.com/)
    // i napisati sto vise test case-eva (Vas izbor sta cete testirati) (Domaci od petka), uraditi koristeci POM.

    public WebDriver driver;
    public WebDriverWait wait;

    public HomePage homePage;
    public AddRemoveElementsPage addRemoveElementsPage;
    public DisappearingElementsPage disappearingElementsPage;
    public DisappearingAboutPage disappearingAboutPage;
    public DynamicControlsPage dynamicControlsPage;
    public LoginFormPage loginFormPage;
    public UserProfileAfterLoggingPage userProfileAfterLoggingPage;


    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        homePage = new HomePage(driver);
        addRemoveElementsPage = new AddRemoveElementsPage(driver);
        disappearingElementsPage = new DisappearingElementsPage(driver);
        disappearingAboutPage = new DisappearingAboutPage(driver);
        dynamicControlsPage = new DynamicControlsPage(driver);
        loginFormPage = new LoginFormPage(driver);
        userProfileAfterLoggingPage = new UserProfileAfterLoggingPage(driver);

    }
}
