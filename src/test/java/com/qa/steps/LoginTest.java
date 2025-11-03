package com.qa.steps;

import com.qa.base.Base;
import com.qa.hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import static com.qa.hooks.Hooks.driver;
import static com.qa.hooks.Hooks.prop;

public class LoginTest {


    @Given("User navigates to Login page")
    public void user_navigates_to_login_page() {
        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
    }

    @When("User enters valid email and valid password into the fields")
    public void user_enters_valid_email_and_valid_password_into_the_fields() {
        driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmailId"));
        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPwd"));

    }

    @And("User clicks on Login button")
    public void user_clicks_on_login_button() {
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    @Then("User should get logged in successfully")
    public void user_should_get_logged_in_successfully() {
        Assert.assertTrue(driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).isDisplayed());
    }

    @And("User should be taken to My Account page")
    public void user_should_be_taken_to_my_account_page() {
        System.out.println(driver.getTitle());
        Assert.assertEquals("My Account", driver.getTitle());
//        driver.quit();
    }


    @When("User enters invalid email and invalid password into the fields")
    public void user_enters_invalid_email_and_invalid_password_into_the_fields() {
        driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("invalidEmailId"));
        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("invalidPwd"));
    }

    @Then("User should not get login")
    public void user_should_not_get_login() {
        List<WebElement> logoutTextNotAvailable = driver.findElements(By.xpath("//div[@class='list-group']/a"));

        for (WebElement webElement : logoutTextNotAvailable) {
            if (webElement.getText().equals("Logout")) {
                System.out.println("Testcase is failed");
            }
        }
    }

    @When("User enters invalid email and valid password into the fields")
    public void user_enters_invalid_email_and_valid_password_into_the_fields() {
        driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("invalidEmailId"));
        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPwd"));
    }

    @When("User enters valid email and invalid password into the fields")
    public void user_enters_valid_email_and_invalid_password_into_the_fields() {
        driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmailId"));
        driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("invalidPwd"));
    }

    @And("User should get a proper warning message")
    public void user_should_get_a_proper_warning_message() throws InterruptedException {
        String actualWarningMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
        if ("Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.".equals(actualWarningMsg)) {
            Assert.assertEquals("Warning: Your account has exceeded allowed number of login attempts. Please try again in 1 hour.", actualWarningMsg);
        } else {
            Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", actualWarningMsg);
        }
        Thread.sleep(1000);
//        driver.quit();
    }

    @When("User do not enter any credentials into the email and password fields")
    public void user_do_not_enter_any_credentials_into_the_email_and_password_fields() {

    }


}
