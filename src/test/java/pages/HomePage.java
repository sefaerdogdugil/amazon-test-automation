package pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HomePage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(HomePage.class);

    public HomePage() {
        super("home");
    }

    public void open() {
        openUrl("https://www.amazon.com");
    }

    public void clickContinueButton() {

        if (isVisible("continueButton")) {
            waitForClickable("continueButton");
            click("continueButton");
            log.info("Countiniue Tıklandı");
        } else {
            log.info("Countinue Button görünmedi");
        }

    }


    public void closeDeliveryAddressPopup() {
        if (isVisible("deliveryPopUp")) {
            waitForClickable("deliveryPopUp");
            click("deliveryPopUp");
        } else log.info("Pop up görünmedi");
    }


    public void verifyLogoIsDisplayed() {
        waitForVisible("logo");
        assert isVisible("logo") : "Amazon logo is not visible";
    }

    public void typeProductToSearchBox(String product) {
        waitForVisible("searchBox");
        click("searchBox");
        sendKeys("searchBox", product);
    }

    public void clickSearchButton() {
        waitForClickable("searchButton");
        click("searchButton");
    }

    public void verifySearchResults(String product) {

        waitForVisible("searchResultText");

        String resultText = getText("searchResultText");

        if (product == null || product.trim().isEmpty()) {
            throw new AssertionError("Product param is EMPTY!");
        }

        if (!resultText.toLowerCase().contains(product.toLowerCase())) {
            throw new AssertionError(
                    "Search result does not contain product: " + product +
                            " | Actual text: " + resultText
            );
        }

        log.info("Search result contains product: " + product);
    }


    public void clickFirstResult() {
        waitForClickable("firstResult");
        click("firstResult");
        log.info("Ürüne tıklandı");

    }
}

