package uiPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/*This is the abstract page base class  where all other classes are inherited from.
      It contains all the methods and variables which are common and will be used on all pages.*/
public class PageBase {

    // Declaration the webDriver and the wait time that will be used.
    protected static WebDriver driver;
    protected WebDriverWait wait;

    // Initialize the driver and set the explicit wait time
    public PageBase(WebDriver driver){
        this.driver =driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //A method to wait until the page loaded before searching for elements
    protected void waitMethod(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    //A method to click on a button after checking its visibility and clickability
    protected void clickButton(By buttonName) {
        WebElement button = driver.findElement(buttonName);
        wait.until(ExpectedConditions.visibilityOf(button));
        wait.until(ExpectedConditions.elementToBeClickable(button));
        button.click();
    }

    // A method to type text in a field after clearing the initial text if exists
    protected void sendText (By textFieldName, String value) {
        WebElement textField = driver.findElement(textFieldName);
        wait.until(ExpectedConditions.visibilityOf(textField));
        textField.clear();
        textField.sendKeys(value);
    }
    // A method to type verify that the link is working and responding well
    protected boolean verifyLink(String url){
        try {
            URL link = new URL (url);
            HttpURLConnection connection =  (HttpURLConnection) link.openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();
            if(connection.getResponseCode() != 200){
                System.out.println( "Error in link " + url);
                System.out.println( "Response code is " + connection.getResponseCode());
                return false;
            }

        } catch (MalformedURLException e) {
            System.out.println( "Error in opening "+ url);
            System.out.println(e.getMessage());
            return false;

        } catch (IOException e) {
            System.out.println( "Error in opening "+ url);
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
