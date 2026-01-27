package pages;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ElementUtil;
import utils.WaitUtil;

import java.util.List;

public abstract class BasePage {

    protected WebDriver driver;
    protected String pageName;

    public BasePage(String pageName) {
        this.driver = DriverFactory.getDriver();
        this.pageName = pageName;
    }

    // ==================== NAVIGATION ====================
    protected void openUrl(String url) {
        driver.get(url);
        WaitUtil.waitForPageLoad();
    }

    protected void goBack() { driver.navigate().back(); WaitUtil.waitForPageLoad(); }
    protected void goForward() { driver.navigate().forward(); WaitUtil.waitForPageLoad(); }
    protected void refresh() { driver.navigate().refresh(); WaitUtil.waitForPageLoad(); }

    // ==================== ELEMENT OPERATIONS (JSON) ====================
    protected void click(String elementName) { ElementUtil.click(pageName, elementName); }
    protected void sendKeys(String elementName, String text) { ElementUtil.sendKeys(pageName, elementName, text); }
    protected String getText(String elementName) { return ElementUtil.getText(pageName, elementName); }
    protected boolean isVisible(String elementName) { return ElementUtil.isVisible(pageName, elementName); }
    protected void scrollTo(String elementName) { ElementUtil.scrollToElement(pageName, elementName); }
    protected void hover(String elementName) { ElementUtil.hover(pageName, elementName); }

    // ==================== ELEMENT OPERATIONS (By) ====================
    protected void click(By locator) { ElementUtil.click(locator); }
    protected void sendKeys(By locator, String text) { ElementUtil.sendKeys(locator, text); }
    protected String getText(By locator) { return ElementUtil.getText(locator); }
    protected boolean isVisible(By locator) { return ElementUtil.isVisible(locator); }

    // ==================== WAIT ====================
    protected WebElement waitForVisible(String elementName) { return WaitUtil.waitForVisible(pageName, elementName); }
    protected WebElement waitForClickable(String elementName) { return WaitUtil.waitForClickable(pageName, elementName); }
    protected void waitForUrl(String urlPart) { WaitUtil.waitForUrlContains(urlPart); }

    // ==================== UTILITY ====================
    protected String getCurrentUrl() { return driver.getCurrentUrl(); }
    protected String getPageTitle() { return driver.getTitle(); }
    protected byte[] takeScreenshot() { return ((org.openqa.selenium.TakesScreenshot) driver).getScreenshotAs(org.openqa.selenium.OutputType.BYTES); }
    protected List<WebElement> findElements(String elementName) { return ElementUtil.findElements(pageName, elementName); }
    protected void scrollToBottom() { ElementUtil.scrollToBottom(); }
    protected void scrollToTop() { ElementUtil.scrollToTop(); }
    protected void acceptAlert() { WaitUtil.waitForAlert().accept(); }
    protected void dismissAlert() { WaitUtil.waitForAlert().dismiss(); }
}
