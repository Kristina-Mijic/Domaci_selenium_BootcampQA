import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Test_Case_4 {
    public static void main(String[] args) throws InterruptedException {

        //Napisati 5 negativnih log-in test case-eva za dati sajt : https://practicetestautomation.com/

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practicetestautomation.com/practice-test-login/");

        //TEST CASE 4

        //Test Case ID - 4
        //Test Case Name - Verify the correct username and incorrect password, and then, by clicking the submit button.
        //Steps:
            //1. Open browser URL: "https://practicetestautomation.com/practice-test-login/";
            //2. Type the CORRECT username into the "username" field.
            //3. Type the incorrect password into the "password" field.
            //4. Click "Submit" button
            //5. Verify error or warning message is displayed.
        //User credentials:
            //username - "student";
            //password - "password";

        String correctUsername = "student";
        String incorrectPassword = "password";

        WebElement validUsername = driver.findElement(By.id("username"));
        validUsername.sendKeys(correctUsername);

        WebElement invalidPassword = driver.findElement(By.id("password"));
        invalidPassword.sendKeys(incorrectPassword);


        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement errorMessage = driver.findElement(By.id("error"));
        String error = errorMessage.getText();
        Assert.assertEquals(error, "Your password is invalid!");

        driver.quit();

        //Expected result: The user cannot log in with one incorrect values.
        //Actual result: The user cannot log in with one incorrect values, and the error message is displayed.
    }
}
