package SqueakyClean.Selenium.PageObjects;

import SqueakyClean.Selenium.EventListeners.ConsoleLogEventListener;
import SqueakyClean.Selenium.EventListeners.HighlightEventListener;
import SqueakyClean.Selenium.EventListeners.ScreenshotEventListener;
import SqueakyClean.Selenium.Helpers.Locators.AjaxVisibleElementFactory;
import SqueakyClean.Selenium.Infrastructure.BaseConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

public class LoadableHomePage extends LoadableComponent {
    private final WebDriver driver;
    private EventFiringWebDriver events;

    @FindBy(how = How.XPATH, using = "//*[@id=\"comp-kijl9tqg\"]/h1/span")
    private WebElement welcomeBanner;

    public LoadableHomePage(WebDriver driver){
        this.driver = driver;
        events = new EventFiringWebDriver(driver);
        events.register(new ConsoleLogEventListener());
        events.register(new HighlightEventListener());
        events.register(new ScreenshotEventListener());

        PageFactory.initElements(new AjaxVisibleElementFactory(driver, new BaseConfig().getDefaultWaitForPageLoad()),this);
    }

    public String welcomeBannerMessage(){
        return welcomeBanner.getText();
    }

    @Override
    protected void load() {
        events.get(new BaseConfig().getUrl());
    }

    @Override
    protected void isLoaded() throws Error {
        boolean ready=false;

        try {
            boolean hasTitleLoaded = events.getTitle().equals("Home | Squeaky Clean!");

            ready = hasTitleLoaded;
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(!ready){
            throw new Error("Page has not loaded");
        }
    }
}
