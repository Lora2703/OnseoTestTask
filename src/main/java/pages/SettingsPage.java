package pages;

import cache.TestCache;
import cache.TestCacheKey;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class SettingsPage extends AbstractBasePage {
    private static final String TIME_ZONE_BUTTON = "//*[@id='TZ_SELECT-label']";
    private static final String TIME_ZONE_DROPDOWN_BUTTON = "//div[@class='Ui selectItem']";
    private static final String APPLY_BUTTON = "//button[@class='Gf primary fullWidth']";

    public void clickTimeZoneButton() {
       javascriptClickOnWebElement(findElementByXPath(TIME_ZONE_BUTTON));
    }

    public String getTextTimeZoneButton() {
        return findElementByXPath(TIME_ZONE_BUTTON).getText();
    }

    public void clickRandomTimeZoneDropdownButton() {
        ArrayList<WebElement> allTimeZoneDropdownButtons = (ArrayList<WebElement>) findAllElementsByXPath(TIME_ZONE_DROPDOWN_BUTTON);
        int randomIndex = (int) (Math.random() * 47);
        String timeZoneText = allTimeZoneDropdownButtons.get(randomIndex).getText();
        TestCache.putDataInCache(TestCacheKey.TIME_ZONE_TEXT, timeZoneText);
        javascriptClickOnWebElement(allTimeZoneDropdownButtons.get(randomIndex));
    }

    public void clickApplyButton() {
        javascriptClickOnWebElement(findElementByXPath(APPLY_BUTTON));
    }
}
