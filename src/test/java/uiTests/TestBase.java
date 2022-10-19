package uiTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;

import java.time.Duration;

public class TestBase {
    //Declare the Driver
    public static WebDriver driver;
    protected WebDriverWait wait;

    /*Set Options for the used webDriver (Chrome is the default)
     & open the driver to access the pages with*/
    @BeforeSuite
    @org.testng.annotations.Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName) {

        String path = "";
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--headless");
            driver = new ChromeDriver(options);
        }else if (browserName.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if (browserName.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
    }

    /* open the required page before any test cases to make sure
     that the steps are the same for every test case */
    @BeforeMethod
    public void navigateToURL() {
        String url= "http://www.uitestingplayground.com/";
        driver.navigate().to(url);
        /* Set implicit time for the driver to wait after opening the driver to allow
        the page to be fully loaded */
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    //Close the browser after finishing the test case to clear cache
    @AfterSuite
    public void closeBrowser(){
        driver.quit();
    }
}
