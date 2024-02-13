import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Test_Case_3 {
    public static void main(String[] args) throws InterruptedException {

        //Napisati 5 negativnih log-in test case-eva za dati sajt : https://practicetestautomation.com/

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practicetestautomation.com/practice-test-login/");

        //TEST CASE 3

        //Test Case ID - 3
        //Test Case Name - Fill both input fields with invalid data, and press the "submit" button.
        //Steps:
            //1. Open browser URL: "https://practicetestautomation.com/practice-test-login/";
            //2. Type username incorrect into "Username" field.
            //3. Type password incorrect into "Password" field.
            //4. Click "Submit" button.
            //5. Verify error or warning message is displayed.
        //User credentials:
            //username - "kristina";
            //password - "password";

        String incorrectUsername = "kristina";
        String incorrectPassword = "password";

        WebElement invalidUsername = driver.findElement(By.id("username"));
        invalidUsername.sendKeys(incorrectUsername);

        WebElement invalidPassword = driver.findElement(By.id("password"));
        invalidPassword.sendKeys(incorrectPassword);

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement errorMessage = driver.findElement(By.id("error"));
        String error = errorMessage.getText();
        Assert.assertEquals(error, "Your username is invalid!");

        driver.quit();

        //Expected result: The user cannot log in.
        //Actual result: The user cannot log in with incorrect values, and the error message is displayed.

    }
}
