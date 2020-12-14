package SqueakyClean.Selenium.Helpers.Locators;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ByGlobalDataAttribute extends By {
    private final String name;
    private final String value;

    public ByGlobalDataAttribute(String dataAttributeName, String valueToMatch) {
        this.name = dataAttributeName;
        this.value = valueToMatch;
    }

    @Override
    public List<WebElement> findElements(SearchContext context) {
        return context.findElements(By.cssSelector(
                String.format("[data-%s='%s']", name, value)
        ));
    }
}
