package steps;

import cache.TestCache;
import cache.TestCacheKey;
import io.cucumber.java.en.And;
import pages.SettingsPage;

import java.time.LocalDateTime;

public class SettingsPageStepdef {
    SettingsPage settingsPage = new SettingsPage();

    @And("I choose random Time zone from drop down menu on Settings page")
    public void iChooseRandomTimeZoneFromDropDownMenuOnSettingsPage() {
        String oldTimeZone;
        do {
            oldTimeZone = settingsPage.getTextTimeZoneButton();
            System.out.println("time zone " + oldTimeZone);
        } while (!oldTimeZone.contains(":"));
        String[] oldTimeZoneArray = oldTimeZone.split("\\s|:");

        String oldTimeOfEventBeginning = TestCache.getStringFromCache(TestCacheKey.OLD_TIME_OF_EVENT_BEGINNING);
        LocalDateTime zeroTimeOfEventBeginning = LocalDateTime.parse(oldTimeOfEventBeginning)
                .minusMinutes(Long.parseLong(oldTimeZoneArray[2])).minusHours(Long.parseLong(oldTimeZoneArray[1]));
        TestCache.putDataInCache(TestCacheKey.ZERO_TIME_OF_EVENT_BEGINNING, zeroTimeOfEventBeginning.toString());

        settingsPage.clickTimeZoneButton();
        settingsPage.clickRandomTimeZoneDropdownButton();
        String newTimeZone = settingsPage.getTextTimeZoneButton();
        TestCache.putDataInCache(TestCacheKey.NEW_TIME_ZONE, newTimeZone);
    }

    @And("I click Apply button on Settings page")
    public void iClickApplyButtonOnSettingsPage() {
        settingsPage.clickApplyButton();
    }
}
