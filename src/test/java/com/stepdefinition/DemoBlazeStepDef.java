package com.stepdefinition;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;

import com.page.objects.DemoBlazePage;
import com.resources.BaseClass;
import com.utilities.FileReaderManager;

import io.cucumber.datatable.*;

public class DemoBlazeStepDef extends BaseClass{
	public static DemoBlazePage dbElements= new DemoBlazePage(getDriver());
	@Given("User go to demoBlaze home page")
	public void userGoToDemoBlazeHomePage() throws IOException {
	    loadUrl(FileReaderManager.getInstance().getCrInstance().url());	    
	}
	@When("User click signup option")
	public void userClickSignupOption() {
	    click(dbElements.getSignupOption());	    
	}
	@When("User enters the signup credentials")
	public void userEntersTheSignupCredentials(DataTable dataTable) {
		List<String> li = dataTable.asList();
		sendText(dbElements.getUsernameSignupInput(), li.get(0));
	    sendText(dbElements.getPasswordSignupInput(), li.get(1));	    
	}
	@When("User enters the login credentials")
	public void userEntersTheLoginCredentials(DataTable dataTable) {
		List<String> li = dataTable.asList();
		sendText(dbElements.getUsernameLoginInput(), li.get(0));
		sendText(dbElements.getPasswordLoginInput(), li.get(1));
	}
	@Then("User click signup button")
	public void userClickSignupButton() {
	    click(dbElements.getSignupButton());
	}
	@Then("User accept alert")
	public void userAcceptAlert() {
	    waitForAlert();
	    alertAccept();
	}
	@When("User click login option")
	public void userClickLoginOption() {
	    click(dbElements.getLoginOption());	    
	}
	@Then("User click login button")
	public void userClickLoginButton() {
	    click(dbElements.getLoginButton());
	}
	@Given("User clicks monitor option")
	public void userClicksMonitorOption() {
		reload();
		jsScrollByElement(dbElements.getMonitorOption());
	    click(dbElements.getMonitorOption());	    
	}
	@When("User select apple monitor")
	public void userSelectAppleMonitor() {
		pageLoadTimeout();
		waitForElementVisible(dbElements.getAppleMonitorProduct());
	    click(dbElements.getAppleMonitorProduct());	    
	}
	@When("User adds apple monitor to cart")
	public void userAddsAppleMonitorToCart() {
	    click(dbElements.getAppleMonitorAddCart());	 
	    waitForAlert();
	    alertAccept();
	}
	@When("User clicks cart button")
	public void userClicksCartButton() {
	   click(dbElements.getCartOption());
	}
	@When("User clicks place order button")
	public void userClicksPlaceOrderButton() {
	    click(dbElements.getPlaceOrderButton());	    
	}
	@When("User enters personal details")
	public void userEntersPersonalDetails(DataTable dataTable) {
		List<String> li = dataTable.asList();
		sendText(dbElements.getNameInput(), li.get(0));
		sendText(dbElements.getCountryInput(), li.get(1));
		sendText(dbElements.getCityInput(),li.get(2));
		sendText(dbElements.getCreditCardInput(), li.get(3));
		sendText(dbElements.getMonthInput(), li.get(4));
	    sendText(dbElements.getYearInput(), li.get(5));
	}
	@Then("User clicks purchase button")
	public void userClicksPurchaseButton() {
	    click(dbElements.getPurchaseButton());	    
	}
	@When("User select asus monitor")
	public void userSelectAsusMonitor() {
		pageLoadTimeout();
		waitForElementVisible(dbElements.getAsusMonitorProduct());
		click(dbElements.getAsusMonitorProduct());	    	    
	}
	@When("User adds asus monitor to cart")
	public void userAddsAsusMonitorToCart() {
		click(dbElements.getAsusMonitorAddCart());
		waitForAlert();
	    alertAccept();
	}


}
