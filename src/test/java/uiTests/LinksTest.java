package uiTests;

import uiPages.UIHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LinksTest extends TestBase{

    @Test
    public void testLinks(){
        UIHomePage uiHomePageElement = new UIHomePage(driver);

        //assert all links are working correctly
        Assert.assertTrue(uiHomePageElement.CheckBrokenLinks());
    }
}
