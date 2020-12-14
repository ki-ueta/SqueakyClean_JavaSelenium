package SqueakyClean.Selenium.Infrastructure;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class BaseTest {
    public WebDriver driver;
    public final String MAINURL =
            new BaseConfig().getUrl();


    @BeforeAll
    public static void LoadConfig() throws IOException {
        new BaseConfig().LoadPropertiesFromConfig();
    }

    @BeforeEach
    public void startBrowser(){
        driver = new BaseDriver().open();
    }

    @AfterEach
    public void closeBrowser(){
        driver.close();
    }
}
