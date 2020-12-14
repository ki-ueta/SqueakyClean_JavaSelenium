package SqueakyClean.Selenium.Infrastructure;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseDriver {
    public WebDriver open() {
        switch (new BaseConfig().getBrowser()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            default:
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
        }
    }
}
