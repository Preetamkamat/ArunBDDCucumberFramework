package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "HP LP3065")
    WebElement hpProduct;

    @FindBy(xpath = "//h2/following-sibling::p")
    WebElement noProductMatchingMessage;

    public String getNoProductMachingMessage() {
        return noProductMatchingMessage.getText();
    }

    public boolean isProductDisplayedInSearchResults() {
        return hpProduct.isDisplayed();
    }

}
