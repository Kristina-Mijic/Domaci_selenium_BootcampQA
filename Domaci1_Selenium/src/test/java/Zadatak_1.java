import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Zadatak_1 {
    public static void main(String[] args) throws InterruptedException {

        //Domaci Zadatak 1: - za nedelju 14.01.2024
        //Otici na Google, zatim preko browser-a otici na YouTube i pustiti neku pesmu po Vasem izboru.


        WebDriverManager.chromedriver().setup();
        WebDriver driver  = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.google.com/");

//Pretraga reci "youtube" na "google"
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/div/textarea")).sendKeys("youtube");
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[2]/div[2]/div[6]/center/input[1]")).click();

//Ulazak na prvi link - youtube
        driver.findElement(By.xpath("/html/body/div[5]/div/div[9]/div[1]/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div/div/div[1]/div/span/a/h3")).click();

//Search area:
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[4]/div[2]/ytd-searchbox/form/div[1]/div[1]/input"))
                .sendKeys("Miles Teller - Great Balls of Fire");

//Searchbox button:
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/div/ytd-masthead/div[4]/div[2]/ytd-searchbox/button")).click();

        Thread.sleep(2000);

//Otvaranje pesme:
        driver.findElement(By.xpath("/html/body/ytd-app/div[1]/ytd-page-manager/ytd-search/div[1]/ytd-two-column-search-results-renderer/div/ytd-section-list-renderer/div[2]/ytd-item-section-renderer/div[3]/ytd-video-renderer[1]/div[1]/div/div[1]/div/h3/a"))
                .click();

    }

    //Ovaj Thread.sleep() - sam stavila jer kada dodjem do pesme da se otvori, test padne,
    //jer on pokusava da klikne video, a stranica sa pesmama se nije ucitala.
}
