package setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class seleniumSetup {

    protected WebDriver driver;

    protected void prepareSeleniumWebdriver() {
        driver = new FirefoxDriver();

    }
}
