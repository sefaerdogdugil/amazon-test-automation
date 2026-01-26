package utils;

import driver.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Element işlemleri için yardımcı sınıf
 * WaitUtil ve LocatorUtil ile birlikte çalışır
 */
public class ElementUtil {

    // ==================== CLICK OPERATIONS ====================

    /**
     * Element'e tıklar (WaitUtil ile)
     */
    public static void click(By locator) {
        WaitUtil.waitForClickable(locator).click();
    }

    /**
     * LocatorUtil ile element'e tıklar
     */
    public static void click(String page, String elementName) {
        By locator = LocatorUtil.getLocator(page, elementName);
        click(locator);
    }

    /**
     * JavaScript ile tıklar
     */
    public static void clickWithJS(By locator) {
        WebElement element = WaitUtil.waitForPresence(locator);
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        js.executeScript("arguments[0].click();", element);
    }

    /**
     * LocatorUtil ile JavaScript tıklama
     */
    public static void clickWithJS(String page, String elementName) {
        By locator = LocatorUtil.getLocator(page, elementName);
        clickWithJS(locator);
    }

    /**
     * Actions ile tıklar
     */
    public static void clickWithActions(By locator) {
        WebElement element = WaitUtil.waitForClickable(locator);
        Actions actions = new Actions(DriverFactory.getDriver());
        actions.click(element).perform();
    }

    // ==================== INPUT OPERATIONS ====================

    /**
     * Element'e text gönderir
     */
    public static void sendKeys(By locator, String text) {
        WebElement element = WaitUtil.waitForVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * LocatorUtil ile text gönderir
     */
    public static void sendKeys(String page, String elementName, String text) {
        By locator = LocatorUtil.getLocator(page, elementName);
        sendKeys(locator, text);
    }

    /**
     * JavaScript ile text gönderir
     */
    public static void sendKeysWithJS(By locator, String text) {
        WebElement element = WaitUtil.waitForPresence(locator);
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        js.executeScript("arguments[0].value='" + text + "';", element);
    }

    /**
     * Yavaşça yazmak için (insan gibi)
     */
    public static void sendKeysSlowly(By locator, String text, int delayMillis) {
        WebElement element = WaitUtil.waitForVisible(locator);
        element.clear();
        for (char c : text.toCharArray()) {
            element.sendKeys(String.valueOf(c));
            WaitUtil.hardWait(delayMillis);
        }
    }

    // ==================== GET OPERATIONS ====================

    /**
     * Element'in text'ini alır
     */
    public static String getText(By locator) {
        return WaitUtil.waitForVisible(locator).getText();
    }

    /**
     * LocatorUtil ile text alır
     */
    public static String getText(String page, String elementName) {
        By locator = LocatorUtil.getLocator(page, elementName);
        return getText(locator);
    }

    /**
     * Element'in attribute değerini alır
     */
    public static String getAttribute(By locator, String attributeName) {
        return WaitUtil.waitForPresence(locator).getAttribute(attributeName);
    }

    /**
     * LocatorUtil ile attribute alır
     */
    public static String getAttribute(String page, String elementName, String attributeName) {
        By locator = LocatorUtil.getLocator(page, elementName);
        return getAttribute(locator, attributeName);
    }

    /**
     * Element'in CSS değerini alır
     */
    public static String getCssValue(By locator, String propertyName) {
        return WaitUtil.waitForVisible(locator).getCssValue(propertyName);
    }

    // ==================== CHECK OPERATIONS ====================

    /**
     * Element görünür mü kontrol eder
     */
    public static boolean isVisible(By locator) {
        try {
            return WaitUtil.waitForVisible(locator, 2) != null;
        } catch (TimeoutException e) {
            return false;
        }
    }

    /**
     * LocatorUtil ile görünürlük kontrolü
     */
    public static boolean isVisible(String page, String elementName) {
        By locator = LocatorUtil.getLocator(page, elementName);
        return isVisible(locator);
    }

    /**
     * Element mevcut mu kontrol eder
     */
    public static boolean isPresent(By locator) {
        try {
            DriverFactory.getDriver().findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Element enabled mı kontrol eder
     */
    public static boolean isEnabled(By locator) {
        return WaitUtil.waitForPresence(locator).isEnabled();
    }

    /**
     * Element seçili mi kontrol eder (checkbox/radio)
     */
    public static boolean isSelected(By locator) {
        return WaitUtil.waitForPresence(locator).isSelected();
    }

    // ==================== DROPDOWN OPERATIONS ====================

    /**
     * Dropdown'dan visible text ile seçim yapar
     */
    public static void selectByVisibleText(By locator, String text) {
        WebElement element = WaitUtil.waitForVisible(locator);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    /**
     * LocatorUtil ile dropdown seçimi
     */
    public static void selectByVisibleText(String page, String elementName, String text) {
        By locator = LocatorUtil.getLocator(page, elementName);
        selectByVisibleText(locator, text);
    }

    /**
     * Dropdown'dan value ile seçim yapar
     */
    public static void selectByValue(By locator, String value) {
        WebElement element = WaitUtil.waitForVisible(locator);
        Select select = new Select(element);
        select.selectByValue(value);
    }

    /**
     * Dropdown'dan index ile seçim yapar
     */
    public static void selectByIndex(By locator, int index) {
        WebElement element = WaitUtil.waitForVisible(locator);
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    /**
     * Dropdown'daki tüm seçenekleri alır
     */
    public static List<WebElement> getAllOptions(By locator) {
        WebElement element = WaitUtil.waitForVisible(locator);
        Select select = new Select(element);
        return select.getOptions();
    }

    // ==================== SCROLL OPERATIONS ====================

    /**
     * Element'e kadar scroll yapar
     */
    public static void scrollToElement(By locator) {
        WebElement element = WaitUtil.waitForPresence(locator);
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        WaitUtil.hardWait(500);
    }

    /**
     * LocatorUtil ile scroll
     */
    public static void scrollToElement(String page, String elementName) {
        By locator = LocatorUtil.getLocator(page, elementName);
        scrollToElement(locator);
    }

    /**
     * Sayfayı en alta scroll yapar
     */
    public static void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        WaitUtil.hardWait(500);
    }

    /**
     * Sayfayı en üste scroll yapar
     */
    public static void scrollToTop() {
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        js.executeScript("window.scrollTo(0, 0);");
        WaitUtil.hardWait(500);
    }

    // ==================== HOVER OPERATIONS ====================

    /**
     * Element üzerine hover yapar
     */
    public static void hover(By locator) {
        WebElement element = WaitUtil.waitForVisible(locator);
        Actions actions = new Actions(DriverFactory.getDriver());
        actions.moveToElement(element).perform();
        WaitUtil.hardWait(500);
    }

    /**
     * LocatorUtil ile hover
     */
    public static void hover(String page, String elementName) {
        By locator = LocatorUtil.getLocator(page, elementName);
        hover(locator);
    }

    // ==================== MULTIPLE ELEMENTS ====================

    /**
     * Tüm elementleri bulur
     */
    public static List<WebElement> findElements(By locator) {
        return WaitUtil.waitForAllVisible(locator);
    }

    /**
     * LocatorUtil ile tüm elementleri bulur
     */
    public static List<WebElement> findElements(String page, String elementName) {
        By locator = LocatorUtil.getLocator(page, elementName);
        return findElements(locator);
    }

    /**
     * Element sayısını döner
     */
    public static int getElementCount(By locator) {
        return DriverFactory.getDriver().findElements(locator).size();
    }

    // ==================== CLEAR OPERATIONS ====================

    /**
     * Input alanını temizler
     */
    public static void clear(By locator) {
        WebElement element = WaitUtil.waitForVisible(locator);
        element.clear();
    }

    /**
     * JavaScript ile input alanını temizler
     */
    public static void clearWithJS(By locator) {
        WebElement element = WaitUtil.waitForPresence(locator);
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        js.executeScript("arguments[0].value='';", element);
    }

    // ==================== HIGHLIGHT (DEBUG İÇİN) ====================

    /**
     * Element'i vurgular (debug için)
     */
    public static void highlightElement(By locator) {
        WebElement element = WaitUtil.waitForPresence(locator);
        JavascriptExecutor js = (JavascriptExecutor) DriverFactory.getDriver();
        js.executeScript("arguments[0].style.border='3px solid red'", element);
        WaitUtil.hardWait(500);
        js.executeScript("arguments[0].style.border=''", element);
    }
}