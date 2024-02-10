package com.stepdefinition;

import com.page.objects.PageObjectManager;
import com.resources.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FbLoginStepDef extends BaseClass{
	PageObjectManager pom=new PageObjectManager(getDriver());
	@Given("User opens facebook page")
	public void goToFbLoginPage() {
		loadUrl("https://www.facebook.com/");
	}
	@When("User click the login button")
	public void loginButtonClick() {
		click(pom.getFbLoginPage().getLoginButton());
	}
	@Then("User directed to their homepage")
	public void verifyHomePage() {
		pageLoadTimeout();
		if(getPageTitle().equals("Facebook")) {
			System.out.println("Expected result of the scenario is achieved.");
		}else {
			System.out.println("Check the given credentials.");
		}
	}
	@Then("User closes the browser")
	public void tearDown() {
		closeBrowser();
	}
	@When("User enters {string} username input field")
	public void userEntersUsernameInputField(String string) {
	    sendText(pom.getFbLoginPage().getUsernameInputField(), string);
	}
	@When("User enters {string} password input field")
	public void userEntersPasswordInputField(String string) {
	    sendText(pom.getFbLoginPage().getPasswordInputField(), string);
	}

}
