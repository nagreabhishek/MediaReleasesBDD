package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    public SelenideElement keywordHeading = $(By.xpath("//button[contains(@class,'expandable-field__button expandable')]/child::span[normalize-space()='Keyword']"));
//    public ElementsCollection listOfMinisters = $$(By.xpath("//label[@class='nsw-form__checkbox-label option']"));
    public SelenideElement clearAllButton = $(By.xpath("//button[text()='Clear all']"));
    public SelenideElement numberOfResult = $(By.xpath("//header[@class='nsw-results-bar']/child::div[@class='nsw-results-bar__info']"));
    public SelenideElement applyFiltersButton = $(By.xpath("//input[@value='Apply filters']"));
    public SelenideElement clearAllFiltersButton = $(By.xpath("//button[text()='Clear all filters']"));
}
