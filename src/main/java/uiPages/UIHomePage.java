package uiPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/* This is the class containing all the elements, actions & methods
 that will be done on the Home page  */
public class UIHomePage extends PageBase{

    //create constructor for the webDriver
    public UIHomePage(WebDriver driver) {super(driver);}

    //Declare the elements that we are dealing with
    By click = By.xpath("//div[@class=\"container\"]/div/div/h3/a[normalize-space(.)=\"Click\"]");
    By dynamicTable = By.xpath("//div[@class=\"container\"]/div/div/h3/a[normalize-space(.)=\"Dynamic Table\"]");
    By verifyText = By.xpath("//div[@class=\"container\"]/div/div/h3/a[normalize-space(.)=\"Verify Text\"]");
    By sampleApp = By.xpath("//div[@class=\"container\"]/div/div/h3/a[normalize-space(.)=\"Sample App\"]");
    By scrollbars = By.xpath("//div[@class=\"container\"]/div/div/h3/a[normalize-space(.)=\"Scrollbars\"]");
    By progressBar = By.xpath("//div[@class=\"container\"]/div/div/h3/a[normalize-space(.)=\"/Progress Bar\"]");

    //Get All the links in the page and check they are working well
    public boolean CheckBrokenLinks(){
        List <WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total links in page: " + links.size());
        boolean linkFlag = true;
        for(int i = 0; i< links.size(); i++){
            WebElement element = links.get(i);
            String url = element.getAttribute("href");
            if(!verifyLink(url)){
                System.out.println("Link text is " + element.getText());
                linkFlag = false;
            }
        }
        return linkFlag;
    }

    //open The Click Page test
    public void openClickPage(){
        clickButton(click);
    }
    //open The Dynamic Table Page test
    public void openDynamicTablePage(){
        clickButton(dynamicTable);
    }
    //open The Sample App Page test
    public void openSampleAppPage(){
        clickButton(sampleApp);
    }
    //open The Scrollbars Page test
    public void openScrollbarsPage(){
        clickButton(scrollbars);
    }

}
