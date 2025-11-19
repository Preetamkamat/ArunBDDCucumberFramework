package com.qa.base;


import com.qa.pages.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base {

    public static Properties prop;
    public static WebDriver driver;
    public HomePage homePage;
    public LoginPage loginPage;
    public AccountSuccessPage accountSuccessPage;
    public MyAccountPage myAccountPage;
    public SearchPage searchPage;
    public RegisterPage registerPage;
    public LogOutPage logOutPage;

}

