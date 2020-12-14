package SqueakyClean.Selenium.Helpers.Locators;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.AjaxElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

import java.lang.reflect.Field;

public class AjaxVisibleElementFactory implements ElementLocatorFactory {
    private final WebDriver driver;
    private final int timeOutInSeconds;

    public AjaxVisibleElementFactory(WebDriver driver, int timeOutInSeconds){
        this.driver = driver;
        this.timeOutInSeconds = timeOutInSeconds;
    }

    @Override
    public ElementLocator createLocator(Field field) {
        return new VisibleAjaxElementLocaltor(driver, field,timeOutInSeconds);
    }

    private class VisibleAjaxElementLocaltor extends AjaxElementLocator {
        public VisibleAjaxElementLocaltor(WebDriver driver, Field field, int timeOutInSeconds) {
            super(driver, field, timeOutInSeconds);
        }

        @Override
        protected boolean isElementUsable(WebElement element) {
            if(element==null){
                return  false;
            }
            return element.isDisplayed()&& element.isEnabled();
        }
    }
}
