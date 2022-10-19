package uiTests;

import uiPages.DynamicTablePage;
import uiPages.UIHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicTableTest extends TestBase {

    @Test
    public void dynamicTableTest(){
        UIHomePage uiHomePage = new UIHomePage(driver);
        uiHomePage.openDynamicTablePage();
        DynamicTablePage dynamicTablePage = new DynamicTablePage(driver);

        //assert that the value is as shown in table
        Assert.assertTrue(dynamicTablePage.getChromeCPUPercentage());
    }
}
