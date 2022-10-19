package uiTests;

import uiPages.ScrollbarsPage;
import uiPages.UIHomePage;
import org.testng.annotations.Test;

public class ScrollbarsTest extends TestBase{

    @Test
    public void scrollBarTest(){
        UIHomePage uiHomePage = new UIHomePage(driver);
        uiHomePage.openScrollbarsPage();
        ScrollbarsPage scrollbarsPage = new ScrollbarsPage(driver);
        scrollbarsPage.scroll();

    }
}
