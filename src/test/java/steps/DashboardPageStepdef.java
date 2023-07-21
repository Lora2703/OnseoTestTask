package steps;

import io.cucumber.java.en.When;
import pages.DashboardPage;

public class DashboardPageStepdef {

    private static final DashboardPage dashboardPage = new DashboardPage();

    @When("I click on not started event on Dashboard page")
    public void iClickOnNotStartedEventOnDashboardPage() {
        dashboardPage.clickNotStartedEvent();
    }
}
