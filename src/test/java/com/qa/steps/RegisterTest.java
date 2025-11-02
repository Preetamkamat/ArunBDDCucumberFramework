package com.qa.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class RegisterTest {
    WebDriver driver = null;
    WebDriverWait myWait;

    @Given("User navigates to Register Account page")
    public void user_navigates_to_register_account_page() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
        driver.findElement(By.linkText("Register")).click();
    }

    @When("User enters below fields")
    public void user_enters_below_fields(DataTable dataTable) {
        Map<String, String> map = dataTable.asMap();
        driver.findElement(By.id("input-firstname")).sendKeys(map.get("firstName"));
        driver.findElement(By.id("input-lastname")).sendKeys(map.get("lastName"));
        String email = generateEmailWithNanoTime();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email")));
        driver.findElement(By.id("input-email")).sendKeys(email);
        driver.findElement(By.id("input-telephone")).sendKeys(map.get("telephone"));
        driver.findElement(By.id("input-password")).sendKeys(map.get("password"));
        driver.findElement(By.id("input-confirm")).sendKeys(map.get("password"));
    }

    @When("User selects Privacy Policy field")
    public void user_selects_privacy_policy_field() {
        driver.findElement(By.name("agree")).click();
    }

    @When("User clicks on Continue button")
    public void user_clicks_on_continue_button() {
        driver.findElement(By.xpath("//input[@value='Continue']")).click();
    }

    @Then("User should get logged in")
    public void user_should_get_logged_in() {
        Assert.assertTrue(driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).isDisplayed());
    }

    @Then("User should be navigated to Account Success page")
    public void user_should_be_navigated_to_account_success_page() {
        Assert.assertEquals("Your Account Has Been Created!", driver.getTitle());
        driver.quit();
    }

    @Then("Proper warning messages should be displayed on Register Account page")
    public void proper_warning_messages_should_be_displayed_on_register_account_page() {

    }

    @When("User selects Yes option for Newsletter")
    public void user_selects_yes_option_for_newsletter() {
        driver.findElement(By.xpath("//input[@name='newsletter']")).click();
    }

    @When("User clicks on {string} option")
    public void user_clicks_on_option(String string) {
    }

    @Then("Yes option in the newsletter page should be displayed as selected")
    public void yes_option_in_the_newsletter_page_should_be_displayed_as_selected() {
        driver.findElement(By.xpath("//input[@name='newletter'][@value='1']")).click();
    }

    public static String generateEmailWithNanoTime() {
        long nanoTime = System.nanoTime();
        return "user_" + nanoTime + "@example.com";
    }

}
