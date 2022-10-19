package uiTests;

import uiPages.ClickPage;
import uiPages.UIHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;



public class ClickTest extends TestBase{

    @Test
    public void clickTest(){
        UIHomePage uiHomePage = new UIHomePage(driver);
        uiHomePage.openClickPage();
        ClickPage clickPage = new ClickPage(driver);
        //assert that the btn is clickable
        Assert.assertTrue(clickPage.clickBadBtn());
    }
}
