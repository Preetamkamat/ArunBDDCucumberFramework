package com.qa.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.List;

public class LoginTest {
    WebDriver driver = null;

    @Given("User navigates to Login page")
    public void user_navigates_to_login_page() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
        driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
        driver.findElement(By.linkText("Login")).click();
    }

    @When("User enters valid email and valid password into the fields")
    public void user_enters_valid_email_and_valid_password_into_the_fields() {
        driver.findElement(By.id("input-email")).sendKeys("shanbhag@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("test123");

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
        Assert.assertEquals("My Account", driver.getTitle());
        driver.quit();
    }


    @When("User enters invalid email and invalid password into the fields")
    public void user_enters_invalid_email_and_invalid_password_into_the_fields() {
        driver.findElement(By.id("input-email")).sendKeys("preetam@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("test2313123");
    }

    @Then("User should not get login")
    public void user_should_not_get_login() {
        List<WebElement> logoutTextNotAvailable = driver.findElements(By.xpath("//div[@class='list-group']/a["));
        for (int i = 0; i < logoutTextNotAvailable.size(); i++) {
            System.out.println(logoutTextNotAvailable.get(i).getText());
        }
    }

    @When("User enters invalid email and valid password into the fields")
    public void user_enters_invalid_email_and_valid_password_into_the_fields() {

    }

    @When("User enters valid email and invalid password into the fields")
    public void user_enters_valid_email_and_invalid_password_into_the_fields() {

    }

    @And("User should get a proper warning message")
    public void user_should_get_a_proper_warning_message() {
        String actualWarningMsg = driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText();
        Assert.assertEquals("Warning: No match for E-Mail Address and/or Password.", actualWarningMsg);
    }

    @When("User do not enter any credentials into the email and password fields")
    public void user_do_not_enter_any_credentials_into_the_email_and_password_fields() {

    }
}
