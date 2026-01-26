package utils;

import driver.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Selenium wait işlemleri için yardımcı sınıf
 * LocatorUtil ile birlikte çalışır
 */
public class WaitUtil {

    private static final int DEFAULT_TIMEOUT = 10;
    private static final int SHORT_TIMEOUT = 5;
    private static final int LONG_TIMEOUT = 30;

    private static WebDriverWait getWait() {
        return getWait(DEFAULT_TIMEOUT);
    }

    private static WebDriverWait getWait(int timeoutInSeconds) {
        WebDriver driver = DriverFactory.getDriver();
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    }

    // ==================== VİSİBİLİTY WAITS ====================

    /**
     * Element görünür olana kadar bekler
     */
    public static WebElement waitForVisible(By locator) {
        return waitForVisible(locator, DEFAULT_TIMEOUT);
    }

    /**
     * Element görünür olana kadar bekler (özel timeout)
     */
    public static WebElement waitForVisible(By locator, int timeoutInSeconds) {
        try {
            return getWait(timeoutInSeconds).until(
                    ExpectedConditions.visibilityOfElementLocated(locator)
            );
        } catch (TimeoutException e) {
            throw new TimeoutException(
                    "Element " + timeoutInSeconds + " saniye içinde görünür olmadı: " + locator, e
            );
        }
    }

    /**
     * LocatorUtil ile kullanım için - Sayfa ve element adı ile bekler
     */
    public static WebElement waitForVisible(String page, String elementName) {
        return waitForVisible(page, elementName, DEFAULT_TIMEOUT);
    }

    /**
     * LocatorUtil ile kullanım için - Özel timeout ile
     */
    public static WebElement waitForVisible(String page, String elementName, int timeoutInSeconds) {
        By locator = LocatorUtil.getLocator(page, elementName);
        return waitForVisible(locator, timeoutInSeconds);
    }

    /**
     * WebElement görünür olana kadar bekler
     */
    public static WebElement waitForVisible(WebElement element) {
        return waitForVisible(element, DEFAULT_TIMEOUT);
    }

    /**
     * WebElement görünür olana kadar bekler (özel timeout)
     */
    public static WebElement waitForVisible(WebElement element, int timeoutInSeconds) {
        try {
            return getWait(timeoutInSeconds).until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            throw new TimeoutException(
                    "Element " + timeoutInSeconds + " saniye içinde görünür olmadı", e
            );
        }
    }

    /**
     * Tüm elementler görünür olana kadar bekler
     */
    public static List<WebElement> waitForAllVisible(By locator) {
        return waitForAllVisible(locator, DEFAULT_TIMEOUT);
    }

    /**
     * Tüm elementler görünür olana kadar bekler (özel timeout)
     */
    public static List<WebElement> waitForAllVisible(By locator, int timeoutInSeconds) {
        try {
            return getWait(timeoutInSeconds).until(
                    ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)
            );
        } catch (TimeoutException e) {
            throw new TimeoutException(
                    "Elementler " + timeoutInSeconds + " saniye içinde görünür olmadı: " + locator, e
            );
        }
    }

    // ==================== CLİCKABLE WAITS ====================

    /**
     * Element tıklanabilir olana kadar bekler
     */
    public static WebElement waitForClickable(By locator) {
        return waitForClickable(locator, DEFAULT_TIMEOUT);
    }

    /**
     * Element tıklanabilir olana kadar bekler (özel timeout)
     */
    public static WebElement waitForClickable(By locator, int timeoutInSeconds) {
        try {
            return getWait(timeoutInSeconds).until(
                    ExpectedConditions.elementToBeClickable(locator)
            );
        } catch (TimeoutException e) {
            throw new TimeoutException(
                    "Element " + timeoutInSeconds + " saniye içinde tıklanabilir olmadı: " + locator, e
            );
        }
    }

    /**
     * LocatorUtil ile kullanım için
     */
    public static WebElement waitForClickable(String page, String elementName) {
        return waitForClickable(page, elementName, DEFAULT_TIMEOUT);
    }

    /**
     * LocatorUtil ile kullanım için - Özel timeout
     */
    public static WebElement waitForClickable(String page, String elementName, int timeoutInSeconds) {
        By locator = LocatorUtil.getLocator(page, elementName);
        return waitForClickable(locator, timeoutInSeconds);
    }

    /**
     * WebElement tıklanabilir olana kadar bekler
     */
    public static WebElement waitForClickable(WebElement element) {
        return waitForClickable(element, DEFAULT_TIMEOUT);
    }

    /**
     * WebElement tıklanabilir olana kadar bekler (özel timeout)
     */
    public static WebElement waitForClickable(WebElement element, int timeoutInSeconds) {
        try {
            return getWait(timeoutInSeconds).until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            throw new TimeoutException(
                    "Element " + timeoutInSeconds + " saniye içinde tıklanabilir olmadı", e
            );
        }
    }

    // ==================== PRESENCE WAITS ====================

    /**
     * Element DOM'da var olana kadar bekler
     */
    public static WebElement waitForPresence(By locator) {
        return waitForPresence(locator, DEFAULT_TIMEOUT);
    }

    /**
     * Element DOM'da var olana kadar bekler (özel timeout)
     */
    public static WebElement waitForPresence(By locator, int timeoutInSeconds) {
        try {
            return getWait(timeoutInSeconds).until(
                    ExpectedConditions.presenceOfElementLocated(locator)
            );
        } catch (TimeoutException e) {
            throw new TimeoutException(
                    "Element " + timeoutInSeconds + " saniye içinde DOM'da bulunamadı: " + locator, e
            );
        }
    }

    /**
     * LocatorUtil ile kullanım için
     */
    public static WebElement waitForPresence(String page, String elementName) {
        return waitForPresence(page, elementName, DEFAULT_TIMEOUT);
    }

    /**
     * LocatorUtil ile kullanım için - Özel timeout
     */
    public static WebElement waitForPresence(String page, String elementName, int timeoutInSeconds) {
        By locator = LocatorUtil.getLocator(page, elementName);
        return waitForPresence(locator, timeoutInSeconds);
    }

    // ==================== INVİSİBİLİTY WAITS ====================

    /**
     * Element görünmez olana kadar bekler
     */
    public static boolean waitForInvisible(By locator) {
        return waitForInvisible(locator, DEFAULT_TIMEOUT);
    }

    /**
     * Element görünmez olana kadar bekler (özel timeout)
     */
    public static boolean waitForInvisible(By locator, int timeoutInSeconds) {
        try {
            return getWait(timeoutInSeconds).until(
                    ExpectedConditions.invisibilityOfElementLocated(locator)
            );
        } catch (TimeoutException e) {
            return false;
        }
    }

    /**
     * LocatorUtil ile kullanım için
     */
    public static boolean waitForInvisible(String page, String elementName) {
        return waitForInvisible(page, elementName, DEFAULT_TIMEOUT);
    }

    /**
     * LocatorUtil ile kullanım için - Özel timeout
     */
    public static boolean waitForInvisible(String page, String elementName, int timeoutInSeconds) {
        By locator = LocatorUtil.getLocator(page, elementName);
        return waitForInvisible(locator, timeoutInSeconds);
    }

    // ==================== TEXT WAITS ====================

    /**
     * Element'te belirli bir text görünene kadar bekler
     */
    public static boolean waitForTextPresent(By locator, String text) {
        return waitForTextPresent(locator, text, DEFAULT_TIMEOUT);
    }

    /**
     * Element'te belirli bir text görünene kadar bekler (özel timeout)
     */
    public static boolean waitForTextPresent(By locator, String text, int timeoutInSeconds) {
        try {
            return getWait(timeoutInSeconds).until(
                    ExpectedConditions.textToBePresentInElementLocated(locator, text)
            );
        } catch (TimeoutException e) {
            throw new TimeoutException(
                    "Text '" + text + "' " + timeoutInSeconds + " saniye içinde bulunamadı: " + locator, e
            );
        }
    }

    /**
     * LocatorUtil ile kullanım için
     */
    public static boolean waitForTextPresent(String page, String elementName, String text) {
        return waitForTextPresent(page, elementName, text, DEFAULT_TIMEOUT);
    }

    /**
     * LocatorUtil ile kullanım için - Özel timeout
     */
    public static boolean waitForTextPresent(String page, String elementName, String text, int timeoutInSeconds) {
        By locator = LocatorUtil.getLocator(page, elementName);
        return waitForTextPresent(locator, text, timeoutInSeconds);
    }

    // ==================== URL & TİTLE WAITS ====================

    /**
     * URL belirli text içerene kadar bekler
     */
    public static void waitForUrlContains(String text) {
        waitForUrlContains(text, DEFAULT_TIMEOUT);
    }

    /**
     * URL belirli text içerene kadar bekler (özel timeout)
     */
    public static void waitForUrlContains(String text, int timeoutInSeconds) {
        try {
            getWait(timeoutInSeconds).until(ExpectedConditions.urlContains(text));
        } catch (TimeoutException e) {
            String currentUrl = DriverFactory.getDriver().getCurrentUrl();
            throw new TimeoutException(
                    "URL " + timeoutInSeconds + " saniye içinde '" + text + "' içermedi. Mevcut URL: " + currentUrl, e
            );
        }
    }

    /**
     * URL tam olarak eşleşene kadar bekler
     */
    public static void waitForUrlToBe(String url) {
        waitForUrlToBe(url, DEFAULT_TIMEOUT);
    }

    /**
     * URL tam olarak eşleşene kadar bekler (özel timeout)
     */
    public static void waitForUrlToBe(String url, int timeoutInSeconds) {
        try {
            getWait(timeoutInSeconds).until(ExpectedConditions.urlToBe(url));
        } catch (TimeoutException e) {
            String currentUrl = DriverFactory.getDriver().getCurrentUrl();
            throw new TimeoutException(
                    "URL " + timeoutInSeconds + " saniye içinde '" + url + "' olmadı. Mevcut URL: " + currentUrl, e
            );
        }
    }

    /**
     * Sayfa başlığı belirli text içerene kadar bekler
     */
    public static void waitForTitleContains(String title) {
        waitForTitleContains(title, DEFAULT_TIMEOUT);
    }

    /**
     * Sayfa başlığı belirli text içerene kadar bekler (özel timeout)
     */
    public static void waitForTitleContains(String title, int timeoutInSeconds) {
        try {
            getWait(timeoutInSeconds).until(ExpectedConditions.titleContains(title));
        } catch (TimeoutException e) {
            String currentTitle = DriverFactory.getDriver().getTitle();
            throw new TimeoutException(
                    "Title " + timeoutInSeconds + " saniye içinde '" + title + "' içermedi. Mevcut title: " + currentTitle, e
            );
        }
    }

    // ==================== ALERT WAITS ====================

    /**
     * Alert görünene kadar bekler
     */
    public static Alert waitForAlert() {
        return waitForAlert(DEFAULT_TIMEOUT);
    }

    /**
     * Alert görünene kadar bekler (özel timeout)
     */
    public static Alert waitForAlert(int timeoutInSeconds) {
        try {
            return getWait(timeoutInSeconds).until(ExpectedConditions.alertIsPresent());
        } catch (TimeoutException e) {
            throw new TimeoutException(
                    "Alert " + timeoutInSeconds + " saniye içinde görünmedi", e
            );
        }
    }

    // ==================== PAGE LOAD WAITS ====================

    /**
     * Sayfa tamamen yüklenene kadar bekler
     */
    public static void waitForPageLoad() {
        waitForPageLoad(LONG_TIMEOUT);
    }

    /**
     * Sayfa tamamen yüklenene kadar bekler (özel timeout)
     */
    public static void waitForPageLoad(int timeoutInSeconds) {
        try {
            getWait(timeoutInSeconds).until((ExpectedCondition<Boolean>) driver ->
                    ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete")
            );
        } catch (TimeoutException e) {
            throw new TimeoutException(
                    "Sayfa " + timeoutInSeconds + " saniye içinde yüklenmedi", e
            );
        }
    }

    /**
     * jQuery işlemleri tamamlanana kadar bekler
     */
    public static void waitForJQueryLoad() {
        waitForJQueryLoad(DEFAULT_TIMEOUT);
    }

    /**
     * jQuery işlemleri tamamlanana kadar bekler (özel timeout)
     */
    public static void waitForJQueryLoad(int timeoutInSeconds) {
        try {
            getWait(timeoutInSeconds).until((ExpectedCondition<Boolean>) driver ->
                    (Boolean) ((JavascriptExecutor) driver).executeScript(
                            "return (typeof jQuery != 'undefined') ? jQuery.active == 0 : true"
                    )
            );
        } catch (TimeoutException | JavascriptException e) {
            // jQuery yoksa veya yüklenmemişse sessizce devam et
        }
    }

    // ==================== UTİLİTY METHODS ====================

    /**
     * Belirtilen süre kadar hard wait yapar
     * Not: Mümkün olduğunca explicit wait tercih edin
     */
    public static void hardWait(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Wait interrupted", e);
        }
    }

    /**
     * Element seçili olana kadar bekler (checkbox/radio button)
     */
    public static boolean waitForSelected(By locator) {
        return waitForSelected(locator, DEFAULT_TIMEOUT);
    }

    /**
     * Element seçili olana kadar bekler (özel timeout)
     */
    public static boolean waitForSelected(By locator, int timeoutInSeconds) {
        try {
            return getWait(timeoutInSeconds).until(
                    ExpectedConditions.elementToBeSelected(locator)
            );
        } catch (TimeoutException e) {
            throw new TimeoutException(
                    "Element " + timeoutInSeconds + " saniye içinde seçilmedi: " + locator, e
            );
        }
    }

    /**
     * Yeni pencere açılana kadar bekler
     */
    public static void waitForNumberOfWindows(int expectedWindowCount) {
        waitForNumberOfWindows(expectedWindowCount, DEFAULT_TIMEOUT);
    }

    /**
     * Yeni pencere açılana kadar bekler (özel timeout)
     */
    public static void waitForNumberOfWindows(int expectedWindowCount, int timeoutInSeconds) {
        try {
            getWait(timeoutInSeconds).until(
                    ExpectedConditions.numberOfWindowsToBe(expectedWindowCount)
            );
        } catch (TimeoutException e) {
            throw new TimeoutException(
                    expectedWindowCount + " pencere " + timeoutInSeconds + " saniye içinde açılmadı", e
            );
        }
    }

    /**
     * Özel koşul için bekler
     */
    public static <T> T waitForCondition(ExpectedCondition<T> condition) {
        return waitForCondition(condition, DEFAULT_TIMEOUT);
    }

    /**
     * Özel koşul için bekler (özel timeout)
     */
    public static <T> T waitForCondition(ExpectedCondition<T> condition, int timeoutInSeconds) {
        try {
            return getWait(timeoutInSeconds).until(condition);
        } catch (TimeoutException e) {
            throw new TimeoutException(
                    "Koşul " + timeoutInSeconds + " saniye içinde sağlanmadı", e
            );
        }
    }
}