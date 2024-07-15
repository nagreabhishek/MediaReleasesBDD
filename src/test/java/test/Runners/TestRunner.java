package test.Runners;


import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.TestGlobals;

import java.io.IOException;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

//import cucumber.api.testng.CucumberFeatureWrapper;

@CucumberOptions
        (
                features = {"src/test/resources/features/"},
                glue = {"test.Runners", "stepDefinition"},
                plugin = {"pretty", "json:target/cucumber-reports/cucumber.json", "html:target/cucumber/report.html", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
                tags = "@mediaReleases",
                monochrome = true
        )

public class TestRunner {
    private TestNGCucumberRunner testNGCucumberRunner;

    @Test(description = "Runs Cucumber Features", dataProvider = "scenarios")
    private void runScenarios(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        try {
            testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DataProvider(name = "scenarios", parallel = false)
    private Object[][] getScenario() {
        Object[][] scenarios = null;
        try {
            if (testNGCucumberRunner == null) {
                testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        scenarios = testNGCucumberRunner.provideScenarios();
        return (scenarios);
    }

    @AfterMethod
    private synchronized void scenarioClosure(ITestResult result) throws IOException {
        getWebDriver().quit();
    }

    @AfterClass
    private void tearDown() {
        testNGCucumberRunner.finish();
    }
}
