package pages;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.LocatorUtil;
import utils.WaitUtil;

import static utils.ElementUtil.isVisible;

public class HomePage {

    WebDriver driver = DriverFactory.getDriver();

    private final By logo = LocatorUtil.getLocator("home", "logo");
    private final By searchBox = LocatorUtil.getLocator("home", "searchBox");
    private final By acceptCookiesBtn = LocatorUtil.getLocator("home", "acceptCookies");
    private final By searchButton = LocatorUtil.getLocator("home", "searchButton");
    private final By searchResult = LocatorUtil.getLocator("home", "searchResult");

    public void open() {
        driver.get("https://www.hepsiburada.com");
    }

    public void acceptCookiesIfPresent() {
        try {
            WaitUtil.waitForClickable(acceptCookiesBtn).click();
            System.out.println("🍪 Cookies accepted");
        } catch (Exception e) {
            System.out.println("🍪 No cookies popup");
        }
    }

    public void logoIsDisplayed() {
        isVisible(logo);
    }

    public void clickSearchBox() {
        WaitUtil.waitForClickable(searchBox).click();
    }

    public void writeSearchText(String text) {
       driver.findElement(searchBox).sendKeys(text);
    }

    public void clickSearchButton() {
        WaitUtil.waitForClickable(searchButton).click();
    }

    public void checkSearchResult() {
        isVisible(searchResult);
    }
}
