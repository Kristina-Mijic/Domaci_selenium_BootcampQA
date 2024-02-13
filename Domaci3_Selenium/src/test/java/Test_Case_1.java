import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Test_Case_1 {
    public static void main(String[] args) throws InterruptedException {

        //Napisati 5 negativnih log-in test case-eva za dati sajt : https://practicetestautomation.com/

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practicetestautomation.com/practice-test-login/");

        //TEST CASE 1:

        //Test Case ID - 1
        //Test Case Name - Click the "submit" button without filling in all fields.
        //Steps:
            //1. Open browser
            //2. Navigate to URL : "https://practicetestautomation.com/practice-test-login/";
            //3. Leave the "username"  input field empty.
            //4. leave the "password"  input field empty
            //5. Click the "submit" button.
            //6. Verify error or warning message is displayed

        String emptyUsername = "";
        String emptyPassword = "";

        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys(emptyUsername);

        WebElement invalidPassword = driver.findElement(By.id("password"));
        invalidPassword.sendKeys(emptyPassword);


        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        WebElement errorMessage = driver.findElement(By.id("error"));
        String error = errorMessage.getText();
        Assert.assertEquals(error, "Your username is invalid!");

        driver.quit();

        //Expected result: The user cannot log in with empty input fields.
        //Actual result: The user cannot log in with empty input fields, and the user can see a warning message.

    }
}
