package com.qa.pages;

import com.qa.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Base {

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement myAccountDropMenu;

    @FindBy(linkText = "Register")
    WebElement registerTextOnHomePage;

    @FindBy(linkText = "Login")
    WebElement loginDropMenuList;

    @FindBy(name = "search")
    WebElement searchBoxField;

    @FindBy(xpath = "//span[@class='input-group-btn']")
    WebElement searchIconButton;

    public void clickOnMyAccountDropMenu() {
        myAccountDropMenu.click();
    }

    public RegisterPage selectRegisterOptions() {
        registerTextOnHomePage.click();
        return new RegisterPage(driver);
    }

    public LoginPage selectLoginOptions() {
        loginDropMenuList.click();
        return new LoginPage(driver);
    }

    public void enterProductInToSearchField(String searchText) {
        searchBoxField.sendKeys(searchText);
    }

    public SearchPage clickOnSearchButton() {
        searchBoxField.click();
        return new SearchPage(driver);
    }

}
