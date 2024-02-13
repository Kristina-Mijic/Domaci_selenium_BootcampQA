import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Text_Case_2 {
    public static void main(String[] args) throws InterruptedException {

        //Napisati 5 negativnih log-in test case-eva za dati sajt : https://practicetestautomation.com/

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practicetestautomation.com/practice-test-login/");

        //TEST CASE 2:

        //Test Case ID - 2
        //Test Case Name - Verify the user cannot log in with numeric values in the "username" fields.
        //Steps:
            //1. Open browser
            //2. Navigate to URL : "https://practicetestautomation.com/practice-test-login/";
            //3. Write numeric values in the "Username" field.
            //4. Type the correct password into the "password" field.
            //5. Click the "submit" button.
            //6. Verify error or warning message is displayed
        //User credential:
            //Username : "1234";

        String numericUsername = "1234";
        String correctPassword = "Password123";

        WebElement invalidUsername = driver.findElement(By.id("username"));
        invalidUsername.sendKeys(numericUsername);

        WebElement validPassword = driver.findElement(By.id("password"));
        validPassword.sendKeys(correctPassword);


        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement errorMessage = driver.findElement(By.id("error"));
        String error = errorMessage.getText();
        Assert.assertEquals(error, "Your username is invalid!");

        driver.quit();

        //Expected result: The user cannot log in with one filled input field.
        //Actual result: The user cannot log in with one filled input field, and the user can see a warning message.
    }
}
