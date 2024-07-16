package utils;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import java.net.MalformedURLException;

public class DriverManager extends Base {

    public static PropertiesReader readConfig = new PropertiesReader();
    public static String browserName = readConfig.getPropertyValue("BROWSER");
    public static String baseURL = readConfig.getPropertyValue("URL");

    public static void launchBrowser() throws MalformedURLException {
        try {
            Configuration.browser = browserName;
            if (browserName.equalsIgnoreCase("chrome")) {
                Configuration.browserSize = "1920x1080";
            }
            Configuration.headless = false;
            if ("CHROME".equals(browserName.toUpperCase())) {
                Configuration.browserCapabilities = new ChromeOptions().addArguments("--remote-allow-origins=*");
            }
            open(baseURL);
            if (browserName.equalsIgnoreCase("safari")) {
                WebDriverRunner.getWebDriver().manage().window().maximize();
            }
            logger.info("Browser Launched Successfully");
        } catch (Exception e) {
            logger.error("Error while opening browser. Browser Name = " + browserName);
            e.printStackTrace();
        }
    }
}
