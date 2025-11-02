package com.qa.testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/com/qa/feature/"}, glue = "com.qa.steps", dryRun = false)

public class TestRun {
}
