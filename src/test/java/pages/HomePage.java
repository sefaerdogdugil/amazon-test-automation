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


    public void closeDeliveryAddressPopup()  {
        if (isVisible("deliveryPopUp")) {
            waitForClickable("deliveryPopUp");
            click("deliveryPopUp");
        }
        else System.out.println("Popup görünmedi");
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
    }


}
