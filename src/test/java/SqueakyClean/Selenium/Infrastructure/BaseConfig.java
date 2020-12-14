package SqueakyClean.Selenium.Infrastructure;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseConfig {

    public void LoadPropertiesFromConfig() {

        String propFileName = "config.properties";

        try {
            InputStream configFile = BaseConfig.class.getClassLoader().getResourceAsStream(propFileName);

            Properties prop = new Properties(System.getProperties());
            prop.load(configFile);

            // set the system properties
            System.setProperties(prop);

        } catch (IOException  e) {
            System.out.println("Exception: " + e);
        }
    }

    public String getUrl(){
        return System.getProperty("Url");
    }

    public String getBrowser() {
        return System.getProperty("Browser", "");
    }

    public int getDefaultWaitForPageLoad() {
        return Integer.parseInt(System.getProperty("WaitPageInSecond", "10"));
    }

    public int getDefaultWaitForElementLoad() {
        return Integer.parseInt(System.getProperty("WaitElementInSecond", "5"));
    }
}

