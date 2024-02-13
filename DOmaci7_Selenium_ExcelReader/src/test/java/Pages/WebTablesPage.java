package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class WebTablesPage extends BaseTest {

    public WebTablesPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "addNewRecordButton")
    public WebElement addButton;

    @FindBy(className = "rt-tr-group")
    public List<WebElement> listOfUsers;

    @FindBy(className = "rt-tr-group")
    public List<WebElement> userRowInfo;


    //----------


    public void isThisPagesURL() {
        String webTablesURL = "https://demoqa.com/webtables";
        Assert.assertEquals(driver.getCurrentUrl(), webTablesURL);
    }

    public void isTheAddButtonPresentOnThePage() {
        Assert.assertTrue(addButton.isDisplayed());
    }

    public void clickOnAddButton() {
        addButton.click();
    }

    public void checkAddedUsersInProfileTable(List<String> userInfo) {
        for (int i = 0; i < userInfo.size(); i++) {
            String onPage = getRowData(listOfUsers.get(i + 3).findElements(By.xpath("div[1]/div")));
            Assert.assertEquals(onPage, userInfo.get(i));
        }
    }

    private String getRowData(List<WebElement> elements) {
        return "FirstNAme:" + elements.get(0).getText().trim() +
                " LastName:" + elements.get(1).getText().trim() +
                " Email:" +elements.get(3).getText().trim() +
                " Age:" + elements.get(2).getText().trim() +
                " Salary:" + elements.get(4).getText().trim() +
                " Department:" + elements.get(5).getText().trim();
    }


}
