package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestGlobals {
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	public static void setWebDriver(WebDriver driver) {
		tlDriver.set(driver);
		loadDriver(driver);
	}
	
	public static WebDriver getWebDriver() {
		return tlDriver.get();
	}

	public static void loadDriver(WebDriver driver){
		WebDriverRunner.setWebDriver(driver);
	}
	
	public synchronized static void removeDriver() {
		if (tlDriver != null) {
			getWebDriver().quit();
			setWebDriver(null);
//			WebDriverRunner.setWebDriver(null);
		}
	}
	
}
