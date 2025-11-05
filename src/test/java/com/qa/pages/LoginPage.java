package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement myAccountDropMenu;

    @FindBy(linkText = "Login")
    WebElement loginDropMenuList;

    @FindBy(linkText = "Register")
    WebElement registerDropMenuList;

    @FindBy(id = "input-email")
    WebElement emailIdField;

    @FindBy(id = "input-password")
    WebElement passwordField;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement loginButton;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement warningMessage;

    public void clickOnMyAccountDropMenu() {
        myAccountDropMenu.click();
    }

    public void clickOnRegisterDropList() {
        registerDropMenuList.click();
    }

    public void clickOnEmailIdField(String emailId) {
        emailIdField.sendKeys(emailId);
    }

    public void clickOnPasswordField(String password) {
        passwordField.sendKeys(password);
    }

    public MyAccountPage clickOnLoginButton() {
        loginButton.click();
        return new MyAccountPage(driver);
    }

    public String getWarningMessage() {
        return warningMessage.getText();
    }

}
