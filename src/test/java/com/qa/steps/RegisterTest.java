package com.qa.steps;

import com.qa.base.Base;
import com.qa.hooks.Hooks;
import com.qa.pages.AccountSuccessPage;
import com.qa.pages.HomePage;
import com.qa.pages.RegisterPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

import static com.qa.hooks.Hooks.driver;

public class RegisterTest {
    WebDriverWait myWait;
    HomePage homePage;
    RegisterPage registryPage;
    AccountSuccessPage accountSuccessPage;

    @Given("User navigates to Register Account page")
    public void user_navigates_to_register_account_page() {
        homePage = new HomePage(driver);
        homePage.clickOnMyAccountDropMenu();
        registryPage = homePage.selectRegisterOptions();

    }

    @When("User enters below fields")
    public void user_enters_below_fields(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap();
        registryPage.setFirstNameField(map.get("firstName"));
        registryPage.setLastNameField(map.get("lastName"));
        String email = generateEmailWithNanoTime();
        registryPage.setEmailAddressField(email);
        registryPage.setTelephoneField(map.get("telephone"));
        registryPage.setPasswordFieldField(map.get("password"));
        registryPage.setConfirmPasswordFieldField(map.get("password"));
    }

    @When("User selects Privacy Policy field")
    public void user_selects_privacy_policy_field() {
        registryPage.clickOnAgreeCheckBox();
    }

    @When("User clicks on Continue button")
    public void user_clicks_on_continue_button() {
        accountSuccessPage = registryPage.clickOnContinueButton();

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
        registryPage.selectYesNewsLetterOption();
    }

    @Then("Yes option in the newsletter page should be displayed as selected")
    public void yes_option_in_the_newsletter_page_should_be_displayed_as_selected() {
        registryPage.selectYesNewsLetterOption();
    }

    public static String generateEmailWithNanoTime() {
        long nanoTime = System.nanoTime();
        return "user_" + nanoTime + "@example.com";
    }

}
