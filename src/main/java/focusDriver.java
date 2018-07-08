/**
 * Created by thanos-imac on 8/7/18.
 */
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class focusDriver {

    WebDriver driver;

    @BeforeTest
    public void beforeTest() {

        driver = new ChromeDriver();
        focusBrowser(driver);
        System.setProperty("webdriver.chrome.driver", "/Users/IdeaProjects/focusdriverapp/src/main/resources/chromedriver");
        driver.get("http://www.google.com");
        //maximize window
        driver.manage().window().maximize();
    }
    @Test
    public void test(){}

    @AfterTest
    public void afterTest() {
        driver.close();
        driver.quit();
    }

    private void focusBrowser(WebDriver driver) {
        String currentWindow;
        currentWindow = driver.getWindowHandle();
        ((JavascriptExecutor)driver).executeScript("alert('Test')");
        driver.switchTo().alert().accept();
        driver.switchTo().window(currentWindow);
    }
}
