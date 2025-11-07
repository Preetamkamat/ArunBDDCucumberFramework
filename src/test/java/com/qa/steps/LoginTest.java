package com.qa.steps;


import com.qa.base.Base;
import com.qa.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginTest extends Base {

    @Given("User navigates to Login page")
    public void user_navigates_to_login_page() {
        homePage = new HomePage(driver);
        homePage.clickOnMyAccountDropMenu();
        loginPage = homePage.selectLoginOptions();
    }

    @When("User enters valid email and valid password into the fields")
    public void user_enters_valid_email_and_valid_password_into_the_fields() {
        loginPage.clickOnEmailIdField(prop.getProperty("validEmailId"));
        loginPage.clickOnPasswordField(prop.getProperty("validPwd"));

    }

    @And("User clicks on Login button")
    public void user_clicks_on_login_button() {
        myAccountPage = loginPage.clickOnLoginButton();
    }

    @Then("User should get logged in successfully")
    public void user_should_get_logged_in_successfully() {
        Assert.assertTrue(myAccountPage.isUserLoggedIn());
    }

    @And("User should be taken to My Account page")
    public void user_should_be_taken_to_my_account_page() {
        Assert.assertEquals("My Account", driver.getTitle());
    }


    @When("User enters invalid email and invalid password into the fields")
    public void user_enters_invalid_email_and_invalid_password_into_the_fields() {
        loginPage.clickOnEmailIdField(prop.getProperty("invalidEmailId"));
        loginPage.clickOnPasswordField(prop.getProperty("invalidPwd"));
    }

    @Then("User should not get login")
    public void user_should_not_get_login() {
        Assert.assertEquals("Account Login", driver.getTitle());
    }

    @When("User enters invalid email and valid password into the fields")
    public void user_enters_invalid_email_and_valid_password_into_the_fields() {
        loginPage.clickOnEmailIdField(prop.getProperty("invalidEmailId"));
        loginPage.clickOnPasswordField(prop.getProperty("validPwd"));
    }

    @When("User enters valid email and invalid password into the fields")
    public void user_enters_valid_email_and_invalid_password_into_the_fields() {
        loginPage.clickOnEmailIdField(prop.getProperty("validEmailId"));
        loginPage.clickOnPasswordField(prop.getProperty("invalidPwd"));
    }

    @And("User should get a proper warning message")
    public void user_should_get_a_proper_warning_message() {
        if ("Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.".equals(loginPage.getWarningMessage())) {
            Assert.assertEquals("Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.", loginPage.getWarningMessage());
        } else {
            Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", loginPage.getWarningMessage());
        }
    }

    @When("User do not enter any credentials into the email and password fields")
    public void user_do_not_enter_any_credentials_into_the_email_and_password_fields() {

    }


}
