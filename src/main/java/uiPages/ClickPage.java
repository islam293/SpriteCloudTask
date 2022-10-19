package uiPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/* This is the class containing all the elements, actions & methods
 that will be done on the Click page  */
public class ClickPage extends PageBase{

    //create constructor for the webDriver
    public ClickPage(WebDriver driver) {super(driver);}

    //Declare the elements that we are dealing with
    By button = By.id("badButton");

    //Click on the button and check its name is changed
    public boolean clickBadBtn(){
        waitMethod();
        clickButton(button);
        String className = driver.findElement(button).getAttribute("class");
        if (className.contains("success")){
            return true;
        }else{
            return false;
        }
    }
}
