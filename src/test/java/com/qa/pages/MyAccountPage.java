package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement rightColumnLogoutOption;

    @FindBy(xpath = "//span[text()='My Account']")
    WebElement myAccountDropMenu;

    @FindBy(linkText = "Logout")
    WebElement logoutOptionUnderMyAccountDropMenu;

    public boolean isUserLoggedIn() {
        return rightColumnLogoutOption.isDisplayed();
    }

    public void selectMyAccountDropMenu() {
        myAccountDropMenu.click();
    }

    public void logoutUsingOptionUnderMyAccountDropMenu() {
        logoutOptionUnderMyAccountDropMenu.click();
    }

    public void logoutUsingRightColumnOption() {
        rightColumnLogoutOption.click();
    }
}
