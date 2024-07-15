package stepDefinition;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import utils.DriverManager;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Base64;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Hooks extends DriverManager {

    @AfterStep
    public void afterStep(Scenario scenario) {
        // Take screenshot regardless of pass or fail
//        byte[] screenshotExtent = Selenide.screenshot(OutputType.BYTES);
//        scenario.attach(screenshotExtent, "image/png", scenario.getName());
        String screenshot = Selenide.screenshot(OutputType.BASE64);
        InputStream targetStream = new ByteArrayInputStream(Base64.getDecoder().decode(screenshot));
        Allure.addAttachment(scenario.getName(), targetStream);
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            if (scenario.isFailed()) {
                logger.info(scenario.getName() + " is Fail");
            } else {
                logger.info(scenario.getName() + " is Pass");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close WebDriver after attaching screenshot
            if (getWebDriver() != null) {
                getWebDriver().quit();
            }
            logger.info("Browser closed Successfully");
        }
    }
}
