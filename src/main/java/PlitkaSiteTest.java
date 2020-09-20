import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.swing.*;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class PlitkaSiteTest {
    WebDriver webDriver = new ChromeDriver();
    MainPage mainPage;
@Before
    public void PrepeareTest () {
    mainPage = new MainPage (webDriver);
    mainPage.SwitchToelement();
    // Telling the system where to find the Chrome driver
    System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

@Test
    public void SiteSite () throws InterruptedException {
    webDriver.get("https://svitkeramiki.com.ua/");
    Thread.sleep(3000);
    WebElement menuCeramic = webDriver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li/div/div/ul/li[2]"));
    WebElement ceramicStone = webDriver.findElement(By.xpath("//*[@id=\"menu\"]/ul/li/div/div/ul/li[2]/div/div/ul/li[2]"));
    Actions actions = new Actions(webDriver);
    Thread.sleep(1000);
    actions.moveToElement(menuCeramic).build().perform();//hover over the menu
    Thread.sleep(1000);
    actions.moveToElement(ceramicStone).build().perform();//hover over the menu chapter
    Thread.sleep(1500);
    ceramicStone.click();
    webDriver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[3]/div/div[2]/button")).click();
    Thread.sleep(2500);//add item to the card
    webDriver.findElement(By.xpath("//*[@id=\"cart-modal\"]/div/div/div[2]/div[1]/div[1]/div/div[2]/div/" +
            "div/div[1]/div/button[2]")).click();//add quantity
    Thread.sleep(500);
    webDriver.findElement(By.xpath("//*[@id=\"cart-modal\"]/div/div/div[2]/div[2]/a")).click();
    Thread.sleep(500);//tap complete the order
    webDriver.findElement(By.id("customer_firstname")).sendKeys("Lishko Adolf");//filling the forms
    webDriver.findElement(By.id("customer_telephone")).sendKeys("0000880707");//filling the forms
    webDriver.findElement(By.id("customer_email")).sendKeys("rockettester024@yopmail.com");//filling the forms
    Thread.sleep(500);
    webDriver.findElement(By.name("shipping_method")).click();//selecting shipping method
    Thread.sleep(500);
    webDriver.findElement(By.xpath("//*[@id=\"simplecheckout_shipping\"]/div[3]/fieldset/div/div/select/option[2]")).click();
    //selecting payment method
    Thread.sleep(500);
    webDriver.findElement(By.name("payment_method"));
    Thread.sleep(500);
    WebElement PayMethod = webDriver.findElement(By.name("payment_method"));
    PayMethod.click();
    webDriver.findElement(By.xpath("//*[@id=\"simplecheckout_payment\"]/div[2]/fieldset/div/div/div/select/option[2]")).click();
    Thread.sleep(500);
    //competing the order
    webDriver.findElement(By.id("simplecheckout_button_confirm"));//submitting order
    Thread.sleep(500);
    WebElement submitButton = webDriver.findElement(By.id("simplecheckout_button_confirm"));
    JavascriptExecutor jse = (JavascriptExecutor)webDriver;
    jse.executeScript("arguments[0].click()", submitButton);
    webDriver.get("http://www.yopmail.com/ru/");//open email
    webDriver.findElement(By.id("login")).sendKeys("rockettester024");
    webDriver.findElement(By.xpath("//*[@id=\"f\"]/table/tbody/tr[1]/td[3]/input")).click();

    }

@After
    public void TestEnd (){
        if (webDriver != null);
        System.out.print("Test was completed");
    }


 }

