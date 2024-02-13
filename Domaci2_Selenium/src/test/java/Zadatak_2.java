import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Zadatak_2 {

    public static void main(String[] args) throws InterruptedException {

        //Domaci Zadatak 2:
        //https://demoqa.com/text-box
        //napisati test case za dati text box

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/text-box/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));


                                                //TEST CASE 1:
        // Test Case ID - 1:
        // Test Case Name : Verify that we are on thr actual page.
        //Steps:
            //1.Open browser
            //2.Navigate to URL : "https://demoqa.com/text-box/";
            //3.Verify that the current URL is the same as the actual URL

        String expectedURL = "https://demoqa.com/text-box/";
        Assert.assertEquals(driver.getCurrentUrl(), expectedURL);

        //Expected result: The current URL is the same as the actual URL.
        //Actual result: The current URL is the same as the ACTUAL URL.



                                                //TEST CASE 2:
        // Test Case ID - 2
        // Test Case Name : Verify that the user cannot write characters on the field for the "Full name".
        //Steps:
            //1.Open browser
            //2.Navigate to URL: "https://demoqa.com/text-box/".
        //User credentials:
            //Full name - "123!@".

        String invalidName = "123!@";

        WebElement fullNameField = driver.findElement(By.id("userName"));
        fullNameField.sendKeys(invalidName);
        Assert.assertTrue(fullNameField.isDisplayed());

        //Expected result: The input field must be blocked for characters.
        //Actual result: The input field IS NOT blocked for characters, the user can write characters.

    }
}
