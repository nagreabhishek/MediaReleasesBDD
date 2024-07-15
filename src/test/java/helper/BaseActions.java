package helper;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import utils.Base;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BaseActions extends Base {

//    public Boolean isElementChecked(String ministerValue) {
//        SelenideElement ministerCheckbox = $(By.xpath("//label[@class='nsw-form__checkbox-label option' and normalize-space()='" + ministerValue + "']"));
//        return ministerCheckbox.isSelected();
//    }
//
//    public String isCheckedAttri(String ministerValue) {
//        SelenideElement ministerCheckbox = $(By.xpath("//label[@class='nsw-form__checkbox-label option' and normalize-space()='" + ministerValue + "']"));
//        return ministerCheckbox.getAttribute("checked");
//    }

    public void verifyEmptyUrlAdd() {
        ElementsCollection listOfItemCards = $$(By.xpath("//a[@data-analytics-component='filter_content_result_link']"));
        logger.info("Assert that the href urls are not null");
        for (SelenideElement card : listOfItemCards) {
            String url = card.getAttribute("href");
            Assert.assertNotNull(url);
        }
    }

    public void verifyEmptyImageAdd() {
        ElementsCollection listOfItemCardsImages = $$(By.xpath("//div[@class='nsw-list-item__image']/descendant::picture/img"));
        logger.info("Assert that the image urls are not null");
        for (SelenideElement image : listOfItemCardsImages) {
            String url = image.getAttribute("src");
            Assert.assertNotNull(url);
        }
    }

    public void verifyItemCardHeading() {
        ElementsCollection listOfItemCardHeadings = $$(By.xpath("//div[@class='nsw-list-item__label']"));
        for (SelenideElement heading : listOfItemCardHeadings) {
            String headingText = heading.getText();
            Assert.assertEquals(headingText, "Ministerial media release");
        }
    }

    public void verifyItemCardDate() {
        ElementsCollection listOfItemCardDates = $$(By.xpath("//div[@class='nsw-list-item__info']"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date currentD = new Date();
        for (SelenideElement date : listOfItemCardDates) {
            String dateText = date.getText();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", Locale.ENGLISH);
            LocalDate convertedDate = LocalDate.parse(dateText, formatter);
//            Assert.assertTrue(convertedDate. <= java.time.LocalDate.now());
        }
    }

    public void selectCheckbox(String ministerValue) {
        SelenideElement ministerCheckbox = $(By.xpath("//label[@class='nsw-form__checkbox-label option' and normalize-space()='" + ministerValue + "']"));
        ministerCheckbox.click();
    }

//    public void scrollToView(WebElement element) throws InterruptedException {
//        ((JavascriptExecutor) getWebDriver()).executeScript("arguments[0].scrollIntoView(false);", element);
//
//    }
//
//    public void scrollToTop() throws InterruptedException {
//        ((JavascriptExecutor) getWebDriver()).executeScript("window.scrollTo(0, 0);");
//        Thread.sleep(500);
//    }
//
//    public void hoverOnElement(WebElement element) {
//        Actions act = new Actions(TestGlobals.getWebDriver());
//        act.moveToElement(element).build().perform();
//        act.release();
//    }
//
//    public void javaScriptClick(WebElement ele) {
//        JavascriptExecutor executor = (JavascriptExecutor) getWebDriver();
//        executor.executeScript("arguments[0].click();", ele);
//    }

//    public boolean isElementDisplayed(WebElement element, int explicitWaitSeconds) {
//        boolean isDisplayed = false;
//        try {
////			WebDriverWait wait = new WebDriverWait(getWebDriver(), explicitWaitSeconds);
////			wait.until(ExpectedConditions.visibilityOf(element));
//            isDisplayed = true;
//
//        } catch (TimeoutException e) {
//            logger.error("Element Not displayed even after waiting for " + explicitWaitSeconds + " Seconds");
//            e.printStackTrace();
//        }
//        return isDisplayed;
//    }

}
