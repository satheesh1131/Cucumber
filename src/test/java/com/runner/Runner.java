package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/com/feature/FbLogin.feature"},
				 glue = {"com/stepdefinition","com/hooks"},
				 dryRun =!true,
				 stepNotifications = true,
				 snippets = SnippetType.CAMELCASE,
				 plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"} )
public class Runner {

}
