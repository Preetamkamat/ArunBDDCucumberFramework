package com.qa.hooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Hooks {
    public static WebDriver driver;
    public static Properties prop;

    @Before
    public void setUp() throws IOException {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resource/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (prop.getProperty("browser").equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (prop.getProperty("browser").equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get(prop.getProperty("url"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}

