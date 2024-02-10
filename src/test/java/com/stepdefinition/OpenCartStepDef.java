package com.stepdefinition;

import java.util.List;

import com.page.objects.PageObjectManager;
import com.resources.BaseClass;

import io.cucumber.datatable.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class OpenCartStepDef extends BaseClass{
	PageObjectManager pom=new PageObjectManager(getDriver());
	@Given("User go to opencart homepage")
	public void userGoToOpencartHomepage() {
	    loadUrl("https://demo.opencart.com/");	    
	}
	@Then("User click myAccount Option")
	public void userClickMyAccountOption() {
	    click(pom.getOpenCartRegisterPage().getMyAccountOption());	    
	}
	@Then("User click register option")
	public void userClickRegisterOption() {
	    click(pom.getOpenCartRegisterPage().getRegisterOption());	    
	}
	@Then("User gives registration credentials")
	public void userGivesRegistrationCredentials(DataTable dataTable) throws InterruptedException {
	   List<String> li = dataTable.asList();
	   sendText(pom.getOpenCartRegisterPage().getFirstNameInput(), li.get(0));
	   sendText(pom.getOpenCartRegisterPage().getLastNameInput(), li.get(1)); 
	   sendText(pom.getOpenCartRegisterPage().getMailNameInput(), li.get(2));
	   sendText(pom.getOpenCartRegisterPage().getPassWordInput(), li.get(3));
	   jsScrollByElement(pom.getOpenCartRegisterPage().getReadAgreementCheckBox());
	   Thread.sleep(1000);
	   click(pom.getOpenCartRegisterPage().getNewsLetterRadioButton());
	}
	@Then("User click read agreement checkbox")
	public void userClickReadAgreementCheckbox() {
		click(pom.getOpenCartRegisterPage().getReadAgreementCheckBox());   
	}
	@Then("User click continue button to register")
	public void userClickContinueButtonToRegister() {
	    click(pom.getOpenCartRegisterPage().getContinueButton());	    
	}


}
