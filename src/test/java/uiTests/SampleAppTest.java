package uiTests;

import uiPages.SampleAppPage;
import uiPages.UIHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleAppTest extends TestBase{

    @Test
    public void sampleAppTest(){
        UIHomePage uiHomePage = new UIHomePage(driver);
        uiHomePage.openSampleAppPage();
        SampleAppPage sampleAppPage = new SampleAppPage(driver);

        //assert for successful login
        Assert.assertTrue(sampleAppPage.loginProcess("TestUser","pwd"));
    }

}
