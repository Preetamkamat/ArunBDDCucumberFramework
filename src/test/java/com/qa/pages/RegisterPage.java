package com.qa.pages;

import com.qa.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class RegisterPage extends Base {

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "input-firstname")
    WebElement firstNameField;

    @FindBy(id = "input-lastname")
    WebElement lastNameField;
    @FindBy(id = "input-email")
    WebElement emailIdTField;
    @FindBy(id = "input-telephone")
    WebElement telephoneField;
    @FindBy(id = "input-password")
    WebElement passwordField;
    @FindBy(id = "input-confirm")
    WebElement confirmPasswordField;
    @FindBy(name = "agree")
    WebElement privacyPolicyField;
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueButton;
    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement logOutTextInColumn;
    @FindBy(xpath = "//input[@name='newsletter']")
    WebElement yesNewsLetterOption;

    public void setFirstNameField(String firstNameText) {
        firstNameField.sendKeys(firstNameText);
    }

    public void setLastNameField(String lastNameText) {
        lastNameField.sendKeys(lastNameText);
    }

    public void setEmailAddressField(String emailAddressText) {
        emailIdTField.sendKeys(emailAddressText);
    }

    public void setTelephoneField(String telephoneText) {
        telephoneField.sendKeys(telephoneText);
    }

    public void setPasswordFieldField(String passwordText) {
        passwordField.sendKeys(passwordText);
    }

    public void setConfirmPasswordFieldField(String confirmPasswordText) {
        confirmPasswordField.sendKeys(confirmPasswordText);
    }

    public void clickOnAgreeCheckBox() {
        privacyPolicyField.click();
    }

    public AccountSuccessPage clickOnContinueButton() {
        continueButton.click();
        return new AccountSuccessPage(driver);
    }

    public boolean clickOnLogOutTextInColumn() {
        return logOutTextInColumn.isDisplayed();
    }

    public void selectYesNewsLetterOption() {
        yesNewsLetterOption.click();
    }
}
