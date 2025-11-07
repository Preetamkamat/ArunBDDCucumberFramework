package com.qa.steps;

import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.MyAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.qa.hooks.Hooks.driver;
import static com.qa.hooks.Hooks.prop;

public class LogoutTest {

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;

    @Given("User is logged in")
    public void user_is_logged_in() {
        homePage = new HomePage(driver);
        homePage.clickOnMyAccountDropMenu();
        loginPage = homePage.selectLoginOptions();
        loginPage.clickOnEmailIdField(prop.getProperty("validEmailId"));
        loginPage.clickOnPasswordField(prop.getProperty("validPwd"));
        myAccountPage = loginPage.clickOnLoginButton();
    }

    @When("User clicks on My Account drop menu")
    public void user_clicks_on_my_account_drop_menu() {
        myAccountPage.selectMyAccountDropMenu();

    }

    @And("User clicks on Logout option")
    public void user_clicks_on_logout_option() {
        myAccountPage.logoutUsingOptionUnderMyAccountDropMenu();

    }

    @Then("User should get logged out")
    public void user_should_get_logged_out() {
        Assert.assertEquals("Account Logout", driver.getTitle());
    }


    @When("User clicks on Logout option from Right Column options")
    public void user_clicks_on_logout_option_from_right_column_options() {
        myAccountPage.logoutUsingRightColumnOption();
    }

}
