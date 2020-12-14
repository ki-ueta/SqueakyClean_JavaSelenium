package SqueakyClean.Selenium.PageObjects;

import SqueakyClean.Selenium.EventListeners.ConsoleLogEventListener;
import SqueakyClean.Selenium.EventListeners.HighlightEventListener;
import SqueakyClean.Selenium.EventListeners.ScreenshotEventListener;
import SqueakyClean.Selenium.Helpers.Locators.AjaxVisibleElementFactory;
import SqueakyClean.Selenium.Infrastructure.BaseConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LoadableBookOnlinePage extends LoadableComponent {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private EventFiringWebDriver events;

    @FindBy(how = How.CLASS_NAME, using = "MultiOfferingsTitle2066011707--root")
    private WebElement pageTitle;

    @FindAll({@FindBy(how = How.CLASS_NAME, using = "Grid3915352077--item"),
            @FindBy(how = How.CSS, using = "#prefix_xsz7thmk4 > ul > li")})
    private List<WebElement> services;

    public LoadableBookOnlinePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, new BaseConfig().getDefaultWaitForElementLoad());

        events = new EventFiringWebDriver(driver);
        events.register(new ConsoleLogEventListener());
        events.register(new HighlightEventListener());
        events.register(new ScreenshotEventListener());

        PageFactory.initElements(new AjaxVisibleElementFactory(driver, new BaseConfig().getDefaultWaitForPageLoad()),this);
    }

    public String waitForFinalPageTitle(){

        wait.until(ExpectedConditions.
                textToBePresentInElement(pageTitle,"Our Services"));
        return pageTitle.getText();
    }

    public int getNumberOfServicesShown(){
        return services.size();
    }

    @Override
    protected void load() {
        events.get(new BaseConfig().getUrl() + "/book-online");
    }

    @Override
    protected void isLoaded() throws Error {
        boolean ready=false;

        try {
            boolean hasTitleLoaded = driver.getTitle().equals("Book Online | Squeaky Clean!");

            ready = hasTitleLoaded;
        } catch (Exception e) {
            e.printStackTrace();
        }

        if(!ready){
            throw new Error("Page has not loaded");
        }
    }
}
