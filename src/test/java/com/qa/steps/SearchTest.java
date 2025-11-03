package com.qa.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.qa.hooks.Hooks.driver;
import static com.qa.hooks.Hooks.prop;

public class SearchTest {
    @Given("User is on the Home page")
    public void user_is_on_the_home_page() {
        Assert.assertEquals("Your Store", driver.getTitle());
    }

    @When("User enters existing product into the Search box field")
    public void user_enters_existing_product_into_the_search_box_field() {
        driver.findElement(By.name("search")).sendKeys(prop.getProperty("existingProduct"));
    }

    @And("User clicks on Search button")
    public void user_clicks_on_search_button() {
        driver.findElement(By.xpath("//span[@class='input-group-btn']")).click();
    }

    @Then("Product should be displayed in the search results")
    public void product_should_be_displayed_in_the_search_results() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());
    }

    @When("User enters non existing product into the Search box field")
    public void user_enters_non_existing_product_into_the_search_box_field() {
        driver.findElement(By.name("search")).sendKeys(prop.getProperty("nonExistingProduct"));
    }

    @Then("Proper message should be displayed in the search results")
    public void proper_message_should_be_displayed_in_the_search_results() {
        String actualNoProductMsg = driver.findElement(By.xpath("//div[@id='content']/p[2]")).getText();
        Assert.assertEquals("There is no product that matches the search criteria.", actualNoProductMsg);
    }

    @When("User doesnt enter any product into the Search box field")
    public void user_doesnt_enter_any_product_into_the_search_box_field() {

    }
}
