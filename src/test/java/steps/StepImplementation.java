package steps;

import com.thoughtworks.gauge.Step;
import pages.HomePage;

public class StepImplementation {

    HomePage homePage = new HomePage();

    @Step("Hepsiburada anasayfasına git")
    public void openHomePage() {
        homePage.open();
    }

    @Step("Çerezleri kabul et")
    public void acceptCookies() {
        homePage.acceptCookiesIfPresent();
    }

    @Step("Logo yüklendi mi?")
    public void logoDisplayed() {
        homePage.logoIsDisplayed();
    }

    @Step("Arama kutusuna tıkla")
    public void aramaKutusunaTikla() {
        homePage.clickSearchBox();
    }

    @Step("Arama kutusuna <text> yaz")
    public void aramaKutusunaYaz(String text) {
        homePage.writeSearchText(text);
    }

    @Step("Aramayı başlat")
    public void aramaBaslat() {
        homePage.clickSearchButton();
    }

    @Step("Arama sonuçları görüntülenmeli")
    public void aramaSonucuKontrolEt() {
        homePage.checkSearchResult();
    }
}
