package pages;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Constants;

import java.util.List;

@Getter
@Setter
public class AbstractBasePage {

    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver(WebDriver driver) {
        AbstractBasePage.driver = driver;
    }

    public WebElement findElementByXPath(String xpath) {
        return waitForVisibilityOfElement(xpath);
    }

    public WebElement waitForVisibilityOfElement(String locator) {
        return new WebDriverWait(driver, Constants.EXPLICIT_WAIT).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public List<WebElement> findAllElementsByXPath(String xpath) {
        return driver.findElements(By.xpath(xpath));
    }

    public WebElement findClickableElementByXPath(String xpath) {
        return waitForClickabilityOfElement(xpath);
    }

    public WebElement waitForClickabilityOfElement(String locator) {
        return new WebDriverWait(getDriver(), Constants.EXPLICIT_WAIT)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }

    public void javascriptClickOnWebElement(WebElement webElement) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", webElement);
    }

    public void javascriptScroll(){
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,250)", "");
    }


}
