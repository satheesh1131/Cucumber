package com.stepdefinition;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

import com.page.objects.SauceDemoPage;
import com.resources.BaseClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SauceDemoStepDef extends BaseClass{
	SauceDemoPage sdElements;
	@Given("User launch the {string} browser")
	public void userLaunchTheBrowser(String browserName) {
	    openBrowser(browserName);
	}
	@Given("User goto Saucedemo login page by {string}")
	public void userGotoSaucedemoLoginPageBy(String url) {
		loadUrl(url);
	}
	@When("User login with valid username and password")
	public void userLoginWithValidUsernameAndPassword(DataTable dataTable) {
		sdElements=new SauceDemoPage(getDriver());
		List<String> li = dataTable.asList();
		Assert.assertEquals(getPageUrl(), "https://www.saucedemo.com/");
		sendText(sdElements.getUsernameTextBox(),li.get(0));
	    sendText(sdElements.getPasswordTextBox(), li.get(1));
	    click(sdElements.getLoginButton());	 
	}
	@When("User login with username {string} and password {string}")
	public void userLoginWithUsernameAndPassword(String userName, String passWord) {
		Assert.assertEquals(getPageUrl(), "https://www.saucedemo.com/");
		sendText(sdElements.getUsernameTextBox(),userName);
	    sendText(sdElements.getPasswordTextBox(), passWord);
	    click(sdElements.getLoginButton());
	}
	@When("User directed to the inventory page")
	public void userDirectedToTheInventoryPage() {
		Assert.assertEquals(getPageUrl(), "https://www.saucedemo.com/inventory.html");
		for(int i=0;i<sdElements.getAddCartButton().size();i++) {
			Assert.assertEquals(checkSelected(sdElements.getAddCartButton().get(i)), false);
			Assert.assertNotEquals(getAttributeValue(sdElements.getProductImage().get(i),"src"), "https://www.saucedemo.com/static/media/sl-404.168b1cce.jpg");
		}
	}
	@When("User add the SauceLabs Backpack to the cart")
	public void userAddTheSauceLabsBackpackToTheCart() {
		click(sdElements.getAddCartButton().get(0));
	}
	@When("User adds the Sauce Labs Backpack and SauceLabs Boult Tshirt to the cart")
	public void userAddsTheSauceLabsBackpackAndSauceLabsBoultTshirtToTheCart() {
		click(sdElements.getAddCartButton().get(0));
		click(sdElements.getAddCartButton().get(1));
	}
	@When("User adds all the products to the cart")
	public void userAddsAllTheProductsToTheCart() {
		int noOfProducts=sdElements.getAddCartButton().size();
		for(int i=0;i<noOfProducts;i++) {
			click(sdElements.getAddCartButton().get(0));
		}
	}
	@When("User add the high value product to the cart")
	public void userAddTheHighValueProductToTheCart() {
		ArrayList<String> priceString= new ArrayList<>();
		ArrayList<Float> priceFloat=new ArrayList<>();
		List<WebElement> addCartButton = sdElements.getAddCartButton();
		List<WebElement> priceOfAllProducts = sdElements.getPriceOfAllProducts();
		for(int i=0;i<priceOfAllProducts.size();i++) {
			priceString.add(i, priceOfAllProducts.get(i).getText());
			String temp=priceString.get(i).substring(1);
			priceFloat.add(i, Float.parseFloat(temp));
		}
		float max=0.0f;
		for(float x:priceFloat) {
			if(x>=max) {
				max=x;
			}
		}
		int maxPriceIndex = priceFloat.indexOf(max);
		click(addCartButton.get(maxPriceIndex));
	}
	@When("User add the low value product to the cart")
	public void userAddTheLowValueProductToTheCart() {
		ArrayList<String> priceString= new ArrayList<>();
		ArrayList<Float> priceFloat=new ArrayList<>();
		List<WebElement> addCartButton = sdElements.getAddCartButton();
		List<WebElement> priceOfAllProducts = sdElements.getPriceOfAllProducts();
		for(int i=0;i<priceOfAllProducts.size();i++) {
			priceString.add(i, priceOfAllProducts.get(i).getText());
			String temp=priceString.get(i).substring(1);
			priceFloat.add(i, Float.parseFloat(temp));
		}
		float max=0.0f;
		for(float x:priceFloat) {
			if(x>=max) {
				max=x;
			}
		}
		float min=max;
		for(float x:priceFloat) {
			if(x<=min) {
				min=x;
			}
		}
		int minPriceIndex = priceFloat.indexOf(min);
		click(addCartButton.get(minPriceIndex));
	}
	@When("User click the cart button")
	public void userClickTheCartButton() {
		click(sdElements.getShopCartButton());
	}
	@When("User click checkout option")
	public void userClickCheckoutOption() {
	    Assert.assertEquals(getPageUrl(),"https://www.saucedemo.com/cart.html");
	    click(sdElements.getCheckoutButton());
	}
	@When("User gives details as {string} {string} {string}")
	public void userGivesDetailsAs(String firstName, String lastName, String pinCode) {
		Assert.assertEquals(getPageUrl(),"https://www.saucedemo.com/checkout-step-one.html");
		sendText(sdElements.getFirstNameTextbox(),firstName);
	    sendText(sdElements.getLastNameTextbox(),lastName); 
	    sendText(sdElements.getPincodeTextbox(),pinCode);
	}
	@When("User click continue button")
	public void userClickContinueButton() {
		click(sdElements.getContinueToOrder());
	    System.out.println("The order value : "+getText(sdElements.getTotalPrice()));
	    
	}
	@When("User click finish button")
	public void userClickFinishButton() {
		Assert.assertEquals(getPageUrl(), "https://www.saucedemo.com/checkout-step-two.html");
		click(sdElements.getFinishOrderButton());
	    
	}
	@Then("Verify the order confirmation")
	public void verifyTheOrderConfirmation() {
		Assert.assertEquals(getPageUrl(), "https://www.saucedemo.com/checkout-complete.html");
		Assert.assertEquals(getText(sdElements.getOrderConfirmMessage()), "Thank you for your order!");
	}
	@Then("User close the browser")
	public void userCloseTheBrowser() {
		closeBrowser();
	}
}
