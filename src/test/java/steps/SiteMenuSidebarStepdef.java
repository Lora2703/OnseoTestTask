package steps;

import io.cucumber.java.en.And;
import pages.SiteMenuSidebar;

public class SiteMenuSidebarStepdef {
    SiteMenuSidebar siteMenuSidebar = new SiteMenuSidebar();

    @And("I click Settings button on Site menu sidebar")
    public void iClickSettingsButtonOnSiteMenuSidebar() {
        siteMenuSidebar.clickSettingsButton();
    }
}
