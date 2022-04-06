package common.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {
    // The framework will focus on using Chrome Driver for now
    public static WebDriver createChromeWebDriver()
    {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        chromeOptions.addArguments("start-maximized");
        //chromeOptions.addArguments("headless");
        //chromeOptions.addArguments("disable-gpu");
        //chromeOptions.addArguments("window-size=1200,1100");
        return new ChromeDriver(chromeOptions);
    }
}
