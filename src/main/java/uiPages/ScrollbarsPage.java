package uiPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/* This is the class containing all the elements, actions & methods
 that will be done on the home page  */
public class ScrollbarsPage extends PageBase{

    //create constructor for the webDriver
    public ScrollbarsPage(WebDriver driver) {super(driver);}

    //Declare the elements that we are dealing with
    By btn = By.id("hidingButton");

    //Perform all actions for scroll test
    public void scroll(){
        WebElement element = driver.findElement(btn);
        //scroll to view the element
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();

    }
}
