package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

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

}
