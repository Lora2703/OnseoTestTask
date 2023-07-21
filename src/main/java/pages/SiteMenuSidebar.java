package pages;

public class SiteMenuSidebar extends AbstractBasePage {
    private static final String SETTINGS_BUTTON = "//span[text()='Settings']";

    public void clickSettingsButton() {
        javascriptClickOnWebElement(findElementByXPath(SETTINGS_BUTTON));
    }
}
