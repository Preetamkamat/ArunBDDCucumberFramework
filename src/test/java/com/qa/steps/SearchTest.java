package com.qa.steps;

import com.qa.pages.HomePage;
import com.qa.pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.qa.hooks.Hooks.driver;
import static com.qa.hooks.Hooks.prop;

public class SearchTest {

    WebDriver driver;
    HomePage homePage;
    SearchPage searchPage;

    @Given("User is on the Home page")
    public void user_is_on_the_home_page() {
        Assert.assertEquals("Your Store", driver.getTitle());
    }

    @When("User enters existing product into the Search box field")
    public void user_enters_existing_product_into_the_search_box_field() {
        homePage = new HomePage(driver);
        homePage.enterProductInToSearchField(prop.getProperty("existingProduct"));
    }

    @And("User clicks on Search button")
    public void user_clicks_on_search_button() {
        searchPage = homePage.clickOnSearchButton();

    }

    @Then("Product should be displayed in the search results")
    public void product_should_be_displayed_in_the_search_results() {
        Assert.assertTrue(searchPage.isProductDisplayedInSearchResults());
    }

    @When("User enters non existing product into the Search box field")
    public void user_enters_non_existing_product_into_the_search_box_field() {
        homePage.enterProductInToSearchField(prop.getProperty("nonExistingProduct"));
    }

    @Then("Proper message should be displayed in the search results")
    public void proper_message_should_be_displayed_in_the_search_results() {
        Assert.assertEquals("There is no product that matches the search criteria.", searchPage.getNoProductMachingMessage());
    }

    @When("User doesnt enter any product into the Search box field")
    public void user_doesnt_enter_any_product_into_the_search_box_field() {
        homePage.enterProductInToSearchField(prop.getProperty(""));
    }
}
