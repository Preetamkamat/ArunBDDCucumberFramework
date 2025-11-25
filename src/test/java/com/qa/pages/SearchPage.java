package com.qa.pages;

import com.qa.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends Base {

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "HP LP3065")
    WebElement hpProduct;

    @FindBy(xpath = "//h2/following-sibling::p")
    WebElement noProductMatchingMessage;

    public String getNoProductMatchingMessage() {
        return noProductMatchingMessage.getText();
    }

    public boolean isProductDisplayedInSearchResults() {
        return hpProduct.isDisplayed();

    }

}
