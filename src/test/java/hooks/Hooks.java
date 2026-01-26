package hooks;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import driver.DriverFactory;

public class Hooks {

    @BeforeScenario
    public void beforeScenario() {
        DriverFactory.createDriver();

    }

    @AfterScenario
    public void afterScenario() {
        DriverFactory.quitDriver();
    }
}
