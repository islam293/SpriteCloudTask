package uiPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/* This is the class containing all the elements, actions & methods
 that will be done on the home page  */
public class SampleAppPage extends PageBase{

    //create constructor for the webDriver
    public SampleAppPage(WebDriver driver) {super(driver);}

    //Declare the elements that we are dealing with
    By userNameTxtBox = By.xpath("//input[@name=\"UserName\"]");
    By passwordTxtBox = By.xpath("//input[@name=\"Password\"]");
    By loginBtn = By.id("login");
    By loginSts = By.id("loginstatus");

    //Perform all actions for success login
    public boolean loginProcess(String userName, String password){
        sendText(userNameTxtBox,userName);
        sendText(passwordTxtBox,password);
        clickButton(loginBtn);
        String txt = driver.findElement(loginSts).getText();

        //verify that a welcome msg is shown after successful login
        if (txt.contains("Welcome")){
            return true;
        }else{
            return false;
        }


    }


}
