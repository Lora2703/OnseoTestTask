package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.ConfigReader;
import utils.Constants;

import java.util.concurrent.TimeUnit;

@Getter
public class DriverInit {
    private WebDriver driver;

    public WebDriver setDriver() {
        if (driver == null) {
            ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
            String browserName = ConfigReader.getPropertyValue("browser");
            switch (browserName) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                default:
                    throw new RuntimeException("Invalid browser name");
            }
            String url = ConfigReader.getPropertyValue("url");
            driver.get(url);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        }
        return driver;
    }


    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
