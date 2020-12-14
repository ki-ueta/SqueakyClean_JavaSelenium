package SqueakyClean.Selenium.Tests;

import SqueakyClean.Selenium.Infrastructure.BaseTest;
import SqueakyClean.Selenium.PageObjects.LoadableBookOnlinePage;
import SqueakyClean.Selenium.PageObjects.LoadableHomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class SeleniumTest extends BaseTest {

    @Test
    public void WelcomeBannerDisplayed(){
        LoadableHomePage page = new LoadableHomePage(this.driver);

        page.get();
        Assertions.assertEquals("Welcome to Squeaky Clean!",page.welcomeBannerMessage());
    }

    @Test
    public void BookOnlinePageShowsFinalPageTitle(){
        LoadableBookOnlinePage page = new LoadableBookOnlinePage(this.driver);

        page.get();
        Assertions.assertNotNull(page.waitForFinalPageTitle());
    }

    @Test
    public void BookOnlinePageShowsServices(){
        LoadableBookOnlinePage page = new LoadableBookOnlinePage(this.driver);

        page.get();
        Assertions.assertTrue(page.getNumberOfServicesShown() > 0);
    }
}

