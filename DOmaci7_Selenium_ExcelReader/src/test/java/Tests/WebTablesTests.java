package Tests;

import Base.BaseTest;
import Pages.RegistrationFormAlertPage;
import Pages.WebTablesPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WebTablesTests extends BaseTest {

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/webtables");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        webTablesPage = new WebTablesPage();
        registrationFormAlertPage = new RegistrationFormAlertPage();
    }


    @Test (priority = 10)
    public void openRegisterForm() {
        webTablesPage.isThisPagesURL();
        webTablesPage.isTheAddButtonPresentOnThePage();
        webTablesPage.clickOnAddButton();
    }

    @Test (priority = 20)
    public void fillAllFieldsWithInvalidDataExcelReader() {
        webTablesPage.clickOnAddButton();

        List<String> userData = new ArrayList<>();

        String invalidFirstName = excelReader.getStringData("RegistrationCredentials", 4, 0);
        String invalidLastName = excelReader.getStringData("RegistrationCredentials", 4, 1);
        String invalidEmail = excelReader.getStringData("RegistrationCredentials", 4, 2);
        String age = String.valueOf(excelReader.getStringData("RegistrationCredentials", 4, 3));
        String salary = excelReader.getStringData("RegistrationCredentials", 4, 4);
        String department = excelReader.getStringData("RegistrationCredentials", 4, 5);

        String userRow = "FirstNAme:" + invalidFirstName + " LastName:" + invalidLastName + " Email:" + invalidEmail + " Age:" + age + " Salary:" + salary + " Department:" + department;
        userData.add(userRow);

        registrationFormAlertPage.inputFirstName(invalidFirstName);
        registrationFormAlertPage.inputLastName(invalidLastName);
        registrationFormAlertPage.inputEmail(invalidEmail);
        registrationFormAlertPage.inputAge(age);
        registrationFormAlertPage.inputSalary(salary);
        registrationFormAlertPage.inputDepartment(department);
        registrationFormAlertPage.submit();

        webTablesPage.checkAddedUsersInProfileTable(userData);
    }

    @Test (priority = 30)
    public void fillAllFieldsWithValidDataExcelReader() {

        List<String> userData = new ArrayList<>();
        for(int i = 1; i < 4; i++) {
            webTablesPage.clickOnAddButton();

            String validFirstName = excelReader.getStringData("RegistrationCredentials", i, 0);
            String validLastName = excelReader.getStringData("RegistrationCredentials", i, 1);
            String validEmail = excelReader.getStringData("RegistrationCredentials", i, 2);
            String age = String.valueOf(excelReader.getStringData("RegistrationCredentials", 1, 3));
            String salary = excelReader.getStringData("RegistrationCredentials", i, 4);
            String department = excelReader.getStringData("RegistrationCredentials", i, 5);

            String userRow = "FirstNAme:" +validFirstName + " LastName:" + validLastName + " Email:" + validEmail + " Age:" + age + " Salary:" + salary + " Department:" + department;
            userData.add(userRow);
            registrationFormAlertPage.inputFirstName(validFirstName);
            registrationFormAlertPage.inputLastName(validLastName);
            registrationFormAlertPage.inputEmail(validEmail);
            registrationFormAlertPage.inputAge(age);
            registrationFormAlertPage.inputSalary(salary);
            registrationFormAlertPage.inputDepartment(department);
            registrationFormAlertPage.submit();

        }
        webTablesPage.checkAddedUsersInProfileTable(userData);
    }


}
