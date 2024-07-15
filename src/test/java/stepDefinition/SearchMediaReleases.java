package stepDefinition;

import com.codeborne.selenide.Condition;
import helper.BaseActions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import utils.DriverManager;

import static com.codeborne.selenide.Selenide.page;

public class SearchMediaReleases extends DriverManager {
    BaseActions baseActions;
    int resultCountBeforeFilter = 0;
    int resultCountAfterFilter = 0;

    @Given("User launches the website")
    public void user_launches_the_website() throws Throwable {
        DriverManager.launchBrowser();
        HomePage homePage = page(HomePage.class);
        homePage.keywordHeading.scrollTo();
    }

    @When("User selects the {string} from the accordion")
    public void userSelectsTheFromTheAccordion(String minister) {
        HomePage homePage = page(HomePage.class);
        baseActions = new BaseActions();
        String[] listOfMinisters = minister.split(",");
        for (String ministerValue: listOfMinisters) {
            baseActions.selectCheckbox(ministerValue.trim());
        }
        Assert.assertTrue(homePage.clearAllButton.isDisplayed(), "Clear All button is not displayed!!!");
    }

    @And("User clicks on apply filters button")
    public void userClicksOnApplyFiltersButton() {
        HomePage homePage = page(HomePage.class);
        String num = homePage.numberOfResult.getText().substring(18, 22).trim();
        resultCountBeforeFilter = Integer.parseInt(num);
        homePage.applyFiltersButton.scrollTo();
        Assert.assertTrue(homePage.clearAllFiltersButton.isDisplayed(), "Clear All Filters button is not displayed!!!");
        homePage.applyFiltersButton.click();
    }

    @And("User verifies the item cards")
    public void userVerifiesTheItemCards() {
        HomePage homePage = page(HomePage.class);
        homePage.numberOfResult.shouldBe(Condition.visible);
        String num = homePage.numberOfResult.getText().substring(18, 21).trim();
        resultCountAfterFilter = Integer.parseInt(num);
        logger.info("Assert that resultCountAfterFilter<=resultCountBeforeFilter");
        Assert.assertTrue(resultCountAfterFilter <= resultCountBeforeFilter, "Results count at the top of Items Cart is greater than initial count!!!");
        baseActions = new BaseActions();
        baseActions.verifyEmptyUrlAdd();
        baseActions.verifyEmptyImageAdd();
        baseActions.verifyItemCardHeading();
        baseActions.verifyItemCardInformationText();
    }

    @And("User clicks on Clear all filters button")
    public void userClicksOnClearAllFiltersButton() {
        HomePage homePage = new HomePage();
        homePage.applyFiltersButton.scrollTo();
        homePage.clearAllFiltersButton.click();
    }

    @Then("User verifies that the filters are cleared")
    public void userVerifiesThatTheFiltersAreCleared() {
        HomePage homePage = new HomePage();
        homePage.clearAllButton.shouldNotBe(Condition.visible);
        homePage.numberOfResult.scrollTo();
        String num = homePage.numberOfResult.getText().substring(18, 22).trim();
        Assert.assertEquals(Integer.parseInt(num), resultCountBeforeFilter, "Results count at the top of Items Cart is not equal to initial count!!!");
    }
}