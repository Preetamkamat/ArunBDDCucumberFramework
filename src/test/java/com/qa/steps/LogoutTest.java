package com.qa.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import static com.qa.hooks.Hooks.driver;

public class LogoutTest {
    @Given("User is logged in")
    public void user_is_logged_in() {
        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.id("input-email")).sendKeys("shanbhag@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("test123");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    @When("User clicks on My Account drop menu")
    public void user_clicks_on_my_account_drop_menu() {
        driver.findElement(By.xpath("//span[text()='My Account']")).click();

    }

    @And("User clicks on Logout option")
    public void user_clicks_on_logout_option() {
        driver.findElement(By.linkText("Logout")).click();

    }

    @Then("User should get logged out")
    public void user_should_get_logged_out() {
        Assert.assertEquals("Account Logout", driver.getTitle());
    }


    @When("User clicks on Logout option from Right Column options")
    public void user_clicks_on_logout_option_from_right_column_options() {
        driver.findElement(By.xpath("//div[@class='list-group']/a[text()='Logout']")).click();
    }

}
