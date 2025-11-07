package com.qa.steps;

import com.qa.base.Base;
import com.qa.pages.HomePage;
import com.qa.util.CommonUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.util.Map;

public class RegisterTest extends Base {

    @Given("User navigates to Register Account page")
    public void user_navigates_to_register_account_page() {
        homePage = new HomePage(driver);
        homePage.clickOnMyAccountDropMenu();
        registerPage = homePage.selectRegisterOptions();

    }

    @When("User enters below fields")
    public void user_enters_below_fields(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap();
        registerPage.setFirstNameField(map.get("firstName"));
        registerPage.setLastNameField(map.get("lastName"));
        String email = CommonUtils.generateEmailWithNanoTime();
        registerPage.setEmailAddressField(email);
        registerPage.setTelephoneField(map.get("telephone"));
        registerPage.setPasswordFieldField(map.get("password"));
        registerPage.setConfirmPasswordFieldField(map.get("password"));
    }

    @When("User selects Privacy Policy field")
    public void user_selects_privacy_policy_field() {
        registerPage.clickOnAgreeCheckBox();
    }

    @When("User clicks on Continue button")
    public void user_clicks_on_continue_button() {
        accountSuccessPage = registerPage.clickOnContinueButton();

    }

    @Then("User should get logged in")
    public void user_should_get_logged_in() {
        Assert.assertTrue(accountSuccessPage.isUserLoggedIn());
    }

    @Then("User should be navigated to Account Success page")
    public void user_should_be_navigated_to_account_success_page() {
        Assert.assertEquals("Your Account Has Been Created!", driver.getTitle());
    }

    @Then("Proper warning messages should be displayed on Register Account page")
    public void proper_warning_messages_should_be_displayed_on_register_account_page() {

    }

    @When("User selects Yes option for Newsletter")
    public void user_selects_yes_option_for_newsletter() {
        registerPage.selectYesNewsLetterOption();
    }

    @Then("Yes option in the newsletter page should be displayed as selected")
    public void yes_option_in_the_newsletter_page_should_be_displayed_as_selected() {
        registerPage.selectYesNewsLetterOption();
    }

}
