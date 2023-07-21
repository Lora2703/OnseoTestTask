package hooks;

import drivers.DriverInit;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import pages.AbstractBasePage;

public class CucumberHooks {
    private WebDriver driver;

    @Before
    public void getDriver() {
        driver = new DriverInit().setDriver();
        AbstractBasePage.setDriver(driver);
    }

    @After
    public void quitDriver() {
        if (driver != null)
            AbstractBasePage.getDriver().quit();
    }
}
