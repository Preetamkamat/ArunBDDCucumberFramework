package com.qa.pages;

import com.qa.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage extends Base {
    WebDriver driver;

    public LogOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
