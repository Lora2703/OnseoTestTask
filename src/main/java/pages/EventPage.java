package pages;

public class EventPage extends AbstractBasePage {

    private static final String TIME_OF_BEGINNING = "//span[@id='score-or-time']";
    private static final String DATE_OF_BEGINNING = "//span[@id='SEV__status']";
    private static final String SITE_MENU_BUTTON = "//span[@id='burger-menu-open']//child::img[@data-nimg='intrinsic']";

    public String getTimeOfBeginning() {
        return findElementByXPath(TIME_OF_BEGINNING).getText();
    }

    public String getDateOfBeginning() {
        return findElementByXPath(DATE_OF_BEGINNING).getText();
    }

    public void clickSiteMenuButton() {
        javascriptClickOnWebElement(findElementByXPath(SITE_MENU_BUTTON));
    }

}
