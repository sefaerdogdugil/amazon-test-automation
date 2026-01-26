package pages;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ElementUtil;
import utils.LocatorUtil;
import utils.WaitUtil;

import java.util.List;

/**
 * Tüm Page Object sınıfları için base class
 * WaitUtil, ElementUtil ve LocatorUtil ile çalışır
 */
public abstract class BasePage {

    protected WebDriver driver;
    protected String pageName; // JSON dosya adı için

    public BasePage(String pageName) {
        this.driver = DriverFactory.getDriver();
        this.pageName = pageName;
    }

    // ==================== NAVIGATION ====================

    /**
     * Sayfayı açar
     */
    protected void openUrl(String url) {
        driver.get(url);
        WaitUtil.waitForPageLoad();
    }

    /**
     * Geri git
     */
    protected void goBack() {
        driver.navigate().back();
        WaitUtil.waitForPageLoad();
    }

    /**
     * İleri git
     */
    protected void goForward() {
        driver.navigate().forward();
        WaitUtil.waitForPageLoad();
    }

    /**
     * Sayfayı yenile
     */
    protected void refresh() {
        driver.navigate().refresh();
        WaitUtil.waitForPageLoad();
    }

    // ==================== ELEMENT OPERATIONS (JSON LOCATOR) ====================

    /**
     * JSON'dan locator alıp element'e tıklar
     */
    protected void click(String elementName) {
        ElementUtil.click(pageName, elementName);
    }

    /**
     * JSON'dan locator alıp text gönderir
     */
    protected void sendKeys(String elementName, String text) {
        ElementUtil.sendKeys(pageName, elementName, text);
    }

    /**
     * JSON'dan locator alıp text alır
     */
    protected String getText(String elementName) {
        return ElementUtil.getText(pageName, elementName);
    }

    /**
     * JSON'dan locator alıp görünür mü kontrol eder
     */
    protected boolean isVisible(String elementName) {
        return ElementUtil.isVisible(pageName, elementName);
    }

    /**
     * JSON'dan locator alıp scroll yapar
     */
    protected void scrollTo(String elementName) {
        ElementUtil.scrollToElement(pageName, elementName);
    }

    /**
     * JSON'dan locator alıp hover yapar
     */
    protected void hover(String elementName) {
        ElementUtil.hover(pageName, elementName);
    }

    // ==================== ELEMENT OPERATIONS (BY LOCATOR) ====================

    /**
     * By locator ile element'e tıklar
     */
    protected void click(By locator) {
        ElementUtil.click(locator);
    }

    /**
     * By locator ile text gönderir
     */
    protected void sendKeys(By locator, String text) {
        ElementUtil.sendKeys(locator, text);
    }

    /**
     * By locator ile text alır
     */
    protected String getText(By locator) {
        return ElementUtil.getText(locator);
    }

    /**
     * By locator ile görünür mü kontrol eder
     */
    protected boolean isVisible(By locator) {
        return ElementUtil.isVisible(locator);
    }

    // ==================== WAIT OPERATIONS ====================

    /**
     * Element görünür olana kadar bekler
     */
    protected WebElement waitForVisible(String elementName) {
        return WaitUtil.waitForVisible(pageName, elementName);
    }

    /**
     * Element tıklanabilir olana kadar bekler
     */
    protected WebElement waitForClickable(String elementName) {
        return WaitUtil.waitForClickable(pageName, elementName);
    }

    /**
     * URL bekleme
     */
    protected void waitForUrl(String urlPart) {
        WaitUtil.waitForUrlContains(urlPart);
    }

    // ==================== UTILITY METHODS ====================

    /**
     * Mevcut URL'i döner
     */
    protected String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Sayfa başlığını döner
     */
    protected String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Screenshot alır (başarısız testler için)
     */
    protected byte[] takeScreenshot() {
        return ((org.openqa.selenium.TakesScreenshot) driver)
                .getScreenshotAs(org.openqa.selenium.OutputType.BYTES);
    }

    /**
     * Tüm elementleri bulur
     */
    protected List<WebElement> findElements(String elementName) {
        return ElementUtil.findElements(pageName, elementName);
    }

    /**
     * Sayfayı en alta scroll yapar
     */
    protected void scrollToBottom() {
        ElementUtil.scrollToBottom();
    }

    /**
     * Sayfayı en üste scroll yapar
     */
    protected void scrollToTop() {
        ElementUtil.scrollToTop();
    }

    /**
     * Alert kabul eder
     */
    protected void acceptAlert() {
        WaitUtil.waitForAlert().accept();
    }

    /**
     * Alert reddeder
     */
    protected void dismissAlert() {
        WaitUtil.waitForAlert().dismiss();
    }
}