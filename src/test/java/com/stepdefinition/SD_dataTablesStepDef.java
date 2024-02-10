package com.stepdefinition;

import java.util.List;

import org.junit.Assert;

import com.page.objects.SauceDemoPage;
import com.resources.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.datatable.DataTable;

public class SD_dataTablesStepDef extends BaseClass{
	SauceDemoPage sdElements;
	@Given("User launch the browser")
	public void userLaunchTheBrowser(DataTable dataTable) {
	    List<String> browserName = dataTable.asList();
	    openBrowser(browserName.get(0));	    
	}
	@Given("User goto Saucedemo login page")
	public void userGotoSaucedemoLoginPage(DataTable dataTable) {
		sdElements=new SauceDemoPage(getDriver());
		List<String> url = dataTable.asList();
	    loadUrl(url.get(0));	    
	}
	@When("User login with {string} username and {string} password")
	public void userLoginWithUsernameAndPassword(String username, String password) {
		sendText(sdElements.getUsernameTextBox(),username);
	    sendText(sdElements.getPasswordTextBox(), password);
	    click(sdElements.getLoginButton());  
	}
	@When("User directed to the inventoryPage")
	public void userDirectedToTheInventoryPage() {
		Assert.assertEquals(getPageUrl(), "https://www.saucedemo.com/inventory.html");	 
		for(int i=0;i<sdElements.getAddCartButton().size();i++) {
			Assert.assertEquals(checkSelected(sdElements.getAddCartButton().get(i)), false);
			Assert.assertNotEquals(getAttributeValue(sdElements.getProductImage().get(i),"src"), "https://www.saucedemo.com/static/media/sl-404.168b1cce.jpg");
		}
	}
	@When("User adds the Sauce Labs Backpack and SauceLabsBoult Tshirt to the cart")
	public void userAddsTheSauceLabsBackpackAndSauceLabsBoultTshirtToTheCart() {
		click(sdElements.getAddCartButton().get(0));
		click(sdElements.getAddCartButton().get(1));	    
	}
	@When("User click the shopping cart button")
	public void userClickTheShoppingCartButton() {
		click(sdElements.getShopCartButton());	    
	}
	@When("User click order checkout option")
	public void userClickOrderCheckoutOption() {
		click(sdElements.getCheckoutButton());	    
	}
	@When("User gives details")
	public void userGivesDetails(DataTable dataTable) {
		List<String> userDetails = dataTable.asList();
		sendText(sdElements.getFirstNameTextbox(),userDetails.get(0));
	    sendText(sdElements.getLastNameTextbox(),userDetails.get(1)); 
	    sendText(sdElements.getPincodeTextbox(),userDetails.get(2));    
	}
	@When("User click continue to order button")
	public void userClickContinueToOrderButton() {
	    click(sdElements.getContinueToOrder());
	    
	}
	@When("User click finish order button")
	public void userClickFinishOrderButton() {
	    click(sdElements.getFinishOrderButton());
	    
	}
	@Then("Verify the order is confirmation")
	public void verifyTheOrderIsConfirmation() {
		Assert.assertEquals(getText(sdElements.getOrderConfirmMessage()), "Thank you for your order!");	    
	}
	@Then("User close browser")
	public void userCloseBrowser() {
	    closeBrowser();
	}

}
