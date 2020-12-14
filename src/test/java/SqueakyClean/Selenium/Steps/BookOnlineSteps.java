package SqueakyClean.Selenium.Steps;

import SqueakyClean.Selenium.Infrastructure.BaseTest;
import SqueakyClean.Selenium.PageObjects.LoadableBookOnlinePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

public class BookOnlineSteps extends BaseTest {
    private LoadableBookOnlinePage page;

    @When("I am on a Book Online page")
    public void iAmOnABookOnlinePage() {

        LoadableBookOnlinePage page = new LoadableBookOnlinePage(driver);

        page.get();
    }

    @Then("Services are displayed")
    public void servicesAreDisplayed() {

        Assertions.assertTrue(page.getNumberOfServicesShown() > 0);

    }
}
