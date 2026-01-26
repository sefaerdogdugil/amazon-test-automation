package utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import driver.DriverFactory;
import org.openqa.selenium.By;

import java.io.InputStreamReader;
import java.util.Objects;

public class LocatorUtil {

    public static By getLocator(String page, String name) {
        String path = "locators/" + page + ".json";

        JsonObject json = JsonParser.parseReader(
                new InputStreamReader(
                        Objects.requireNonNull(LocatorUtil.class
                                .getClassLoader()
                                .getResourceAsStream(path), "Locator JSON bulunamadı: " + path)
                )
        ).getAsJsonObject();

        JsonObject locator = json.getAsJsonObject(name);
        if (locator == null) {
            throw new RuntimeException("Locator JSON içinde bulunamadı: " + name + " sayfa: " + page);
        }

        String type = locator.get("type").getAsString();
        String value = locator.get("value").getAsString();

        switch (type) {
            case "id":
                return By.id(value);
            case "name":
                return By.name(value);
            case "css":
                return By.cssSelector(value);
            case "xpath":
                return By.xpath(value);
            default:
                throw new RuntimeException("Locator type desteklenmiyor: " + type);
        }
    }
}
