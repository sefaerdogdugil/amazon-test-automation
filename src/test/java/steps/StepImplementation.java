package steps;

import com.thoughtworks.gauge.Step;
import pages.HomePage;

public class StepImplementation {

    private final HomePage homePage = new HomePage();

    @Step("Amazon anasayfasına git")
    public void openHomePage() {
        homePage.open();
    }

    @Step("Continue butonuna bas")
    public void clickContinueButton() {
        homePage.clickContinueButton();


    }

    @Step("Delivery adres popupını kapat")
    public void closeDeliveryAddressPopup() {
        homePage.closeDeliveryAddressPopup();
    }

    @Step("Amazon logosu görüntülenmeli")
    public void verifyAmazonLogoIsDisplayed()  {
        homePage.verifyLogoIsDisplayed();
    }

    @Step("Arama kutusuna <product> yaz")
    public void typeProductToSearchBox(String product)  {
        homePage.typeProductToSearchBox(product);
    }

    @Step("Aramayı başlat")
    public void clickSearchButton() {
        homePage.clickSearchButton();
    }

    @Step("Results for <product> yazısı görüntülenmeli")
    public void verifySearchResultsForProduct(String product)  {
        homePage.verifySearchResults(product);
    }
}
