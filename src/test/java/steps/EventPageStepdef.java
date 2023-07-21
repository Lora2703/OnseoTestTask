package steps;

import cache.TestCache;
import cache.TestCacheKey;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;
import pages.EventPage;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class EventPageStepdef {
    private static final EventPage eventPage = new EventPage();

    @And("I click Site menu button on Event page")
    public void iClickSiteMenuButtonOnEventPage() {
        String timeOfBeginning = eventPage.getTimeOfBeginning();
        System.out.println("Time of beginning " + timeOfBeginning);
        String[] hours = timeOfBeginning.split(":");

        LocalDateTime oldCurrentDate = LocalDateTime.now();
        LocalDateTime oldTimeOfEventBeginning = oldCurrentDate.withHour(Integer.parseInt(hours[0]))
                .withMinute(Integer.parseInt(hours[1]));

        TestCache.putDataInCache(TestCacheKey.OLD_TIME_OF_EVENT_BEGINNING, oldTimeOfEventBeginning.toString());
        eventPage.clickSiteMenuButton();
    }

    @Then("I see new event beginning time on Event page")
    public void iSeeNewEventBeginningTimeOnEventPage() {
        String actualTimeOfEventBeginning = eventPage.getTimeOfBeginning();
        String actualDateOfEventBeginning = eventPage.getDateOfBeginning();
        String newTimeZone = TestCache.getStringFromCache(TestCacheKey.NEW_TIME_ZONE);
        if (!actualDateOfEventBeginning.equals("Today")) {
            if (newTimeZone.contains("+")) {
                actualDateOfEventBeginning = LocalDateTime.now().plusDays(1).format(DateTimeFormatter.ofPattern("yyy-MM-dd"));
            } else {
                actualDateOfEventBeginning = LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyy-MM-dd"));
            }
        } else {
            actualDateOfEventBeginning = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        }

        String[] newTimeZoneArray = newTimeZone.split("\\s|:");
        String zeroTimeOfEventBeginning = TestCache.getStringFromCache(TestCacheKey.ZERO_TIME_OF_EVENT_BEGINNING);
        String timeZoneText = TestCache.getStringFromCache(TestCacheKey.TIME_ZONE_TEXT);
        LocalDateTime newTimeOfEventBeginning;
        if (timeZoneText.contains("+")) {
            newTimeOfEventBeginning = LocalDateTime.parse(zeroTimeOfEventBeginning)
                    .plusMinutes(Long.parseLong(newTimeZoneArray[2])).plusHours(Long.parseLong(newTimeZoneArray[1]));
        } else {
            newTimeOfEventBeginning = LocalDateTime.parse(zeroTimeOfEventBeginning)
                    .minusMinutes(Long.parseLong(newTimeZoneArray[2])).plusHours(Long.parseLong(newTimeZoneArray[1]));

        }

        String expectedTimeOfEventBeginning = newTimeOfEventBeginning.format(DateTimeFormatter.ofPattern("HH:mm"));
        String expectedDateOfEventBeginning = newTimeOfEventBeginning.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        Assertions.assertThat(actualTimeOfEventBeginning).as("Actual time of event beginning: "
                        + actualTimeOfEventBeginning + "Expected time of event beginning " + expectedTimeOfEventBeginning)
                .isEqualTo(expectedTimeOfEventBeginning);
        Assertions.assertThat(actualDateOfEventBeginning).as("Actual date of event beginning: "
                        + actualDateOfEventBeginning + "Expected date of event beginning " + expectedDateOfEventBeginning)
                .isEqualTo(expectedDateOfEventBeginning);
    }
}
