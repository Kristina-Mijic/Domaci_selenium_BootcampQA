package Base;

import Pages.RegistrationFormAlertPage;
import Pages.WebTablesPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class BaseTest {

    //Domaci Zadatak 7 (23.01.2024 - utorak):
    //Pomocu Excel-a dodati podatke u https://demoqa.com/webtables

    public static WebDriver driver;
    public WebTablesPage webTablesPage;
    public RegistrationFormAlertPage registrationFormAlertPage;
    public ExcelReader excelReader;

    @BeforeClass
    public void setUp() throws IOException {
        WebDriverManager.chromedriver().setup();
        excelReader = new ExcelReader("RegistrationCredentials.xlsx");

    }

}
