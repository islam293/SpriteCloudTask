package uiPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/* This is the class containing all the elements, actions & methods
 that will be done on the Dynamic Table page  */
public class DynamicTablePage extends PageBase{

    //create constructor for the webDriver
    public DynamicTablePage(WebDriver driver) {super(driver);}

    //Declare the elements that we are dealing with
    By headerRow = By.xpath("//div[@role=\"table\"]/div[@role=\"rowgroup\"][1]/div");
    String cpuPath = "./*[normalize-space(.)=\"CPU\"]";
    By tableContent = By.xpath("//div[@role=\"table\"]/div[@role=\"rowgroup\"][2]");
    By txtMsg = By.className("bg-warning");
    String cellPath = "//div[@role=\"table\"]/div[@role=\"rowgroup\"][2]/div[rowNo]/span[clnNo]";

    // Get the chrome Cpu percentage from table and verify it is equal to the value in the message below
    public boolean getChromeCPUPercentage(){

        WebElement headerRowElement = driver.findElement(headerRow);
        WebElement cpuCell = headerRowElement.findElement(By.xpath(cpuPath));

        //Get All Children for the title header row
        List <WebElement> cpuRow = headerRowElement.findElements(By.xpath("*"));
        int cpuIndex = cpuRow.indexOf(cpuCell)+1;

        WebElement chromeHeaderElement = driver.findElement(tableContent);
        //Get All Children for the table content
        List <WebElement> chromeRow = chromeHeaderElement.findElements(By.xpath("*"));
        int chromeIndex = -1;

        //Loop to find the index of the row  that has chrome
        for(int i = 0; i < chromeRow.size(); i++){
            WebElement row = chromeRow.get(i);
            List<WebElement> data = row.findElements(By.xpath("*"));
            String browser = data.get(0).getText();
            if (browser.contentEquals("Chrome")) {
                chromeIndex = i+1;
                break;
            }
        }
        if (chromeIndex <1 ){
            System.out.println("Chrome is not exist in browsers list");
            return false;
        }

        //Reformat the xpath with indexes of chrome and cpu
        cellPath = cellPath.replace("rowNo", String.valueOf(chromeIndex));
        cellPath = cellPath.replace("clnNo", String.valueOf(cpuIndex));
        WebElement cellValue = driver.findElement(By.xpath(cellPath));
        WebElement msgValue = driver.findElement(txtMsg);

        //verify that the value shown in the success msg is correct
        if(msgValue.getText().contains(cellValue.getText())){
            return true;
        }
        return false;
    }
}
