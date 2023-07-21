package pages;

import org.openqa.selenium.WebElement;

import java.util.List;


public class DashboardPage extends AbstractBasePage {

    private static final String TIME_OF_EVENTS_BEGINNING = "//span[@class='fs']";


    public void clickNotStartedEvent() {

        boolean isNotStartedEventClicked = false;
        while (!isNotStartedEventClicked) {
            List<WebElement> allEventsBeginningTimes = findAllElementsByXPath(TIME_OF_EVENTS_BEGINNING);
            for (WebElement eventBeginningTime : allEventsBeginningTimes) {
                if (eventBeginningTime.getText().contains(":")) {
                    javascriptClickOnWebElement(eventBeginningTime);
                    isNotStartedEventClicked = true;
                    break;
                }
            }
            javascriptScroll();
        }
    }
}
