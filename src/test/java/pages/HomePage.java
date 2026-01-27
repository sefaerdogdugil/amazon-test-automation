package pages;

public class HomePage extends BasePage {

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
        }
    }


    public void closeDeliveryAddressPopup() {
        isVisible("deliveryPopUp");
        waitForClickable("deliveryPopUp");
        click("deliveryPopUp");


    }


    public void verifyLogoIsDisplayed() {
        waitForVisible("logo", 15);
        assert isVisible("logo") : "Amazon logo is not visible";
    }

    public void typeProductToSearchBox(String product) {
        waitForVisible("searchBox", 15);
        click("searchBox");
        sendKeys("searchBox", product);
    }

    public void clickSearchButton() {
        waitForClickable("searchButton");
        click("searchButton");
    }

    public void verifySearchResults(String product) {
        waitForVisible("searchResultText", 15);

        String resultText = getText("searchResultText");

        assert resultText.contains(product)
                : "Search result does not contain product: " + product
                + " Actual text: " + resultText;
    }
}
