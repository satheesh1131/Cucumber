package com.page.objects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoPage {
	public SauceDemoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a/img")
	private List<WebElement> productImage;
	public List<WebElement> getProductImage() {
		return productImage;
	}
	@FindBy(id="user-name")
	private WebElement usernameTextBox;
	@FindBy(id="password")
	private WebElement passwordTextBox;
	@FindBy(id="login-button")
	private WebElement loginButton;
	@FindBy(id="react-burger-menu-btn")
	private WebElement optionsButton;
	@FindBy(id="about_sidebar_link")
	private WebElement aboutLink;
	@FindBy(id="react-burger-cross-btn")
	private WebElement closeOptionsButton;
	@FindBy(css="div.inventory_item_price")
	private List<WebElement> priceOfAllProducts;
	@FindBy(xpath="//button[@class='btn btn_primary btn_small btn_inventory']")
	private List<WebElement> addCartButton;
	@FindBy(css="a.shopping_cart_link")
	private WebElement shopCartButton;
	@FindBy(id="checkout")
	private WebElement checkoutButton;
	@FindBy(id="first-name")
	private WebElement firstNameTextbox;
	@FindBy(id="last-name")
	private WebElement lastNameTextbox;
	@FindBy(id="postal-code")
	private WebElement pincodeTextbox;
	@FindBy(id="continue")
	private WebElement continueToOrder;
	@FindBy(xpath="//div[@class='summary_info_label summary_total_label']")
	private WebElement totalPrice;
	@FindBy(id="finish")
	private WebElement finishOrderButton;
	@FindBy(xpath="//h2[@class='complete-header']")
	private WebElement orderConfirmMessage;
	@FindBy(id="back-to-products")
	private WebElement backHomeButton;
	public WebElement getUsernameTextBox() {
		return usernameTextBox;
	}
	public WebElement getPasswordTextBox() {
		return passwordTextBox;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
	public WebElement getOptionsButton() {
		return optionsButton;
	}
	public WebElement getAboutLink() {
		return aboutLink;
	}
	public WebElement getCloseOptionsButton() {
		return closeOptionsButton;
	}
	public List<WebElement> getPriceOfAllProducts() {
		return priceOfAllProducts;
	}
	public List<WebElement> getAddCartButton() {
		return addCartButton;
	}
	public WebElement getShopCartButton() {
		return shopCartButton;
	}
	public WebElement getCheckoutButton() {
		return checkoutButton;
	}
	public WebElement getFirstNameTextbox() {
		return firstNameTextbox;
	}
	public WebElement getLastNameTextbox() {
		return lastNameTextbox;
	}
	public WebElement getPincodeTextbox() {
		return pincodeTextbox;
	}
	public WebElement getContinueToOrder() {
		return continueToOrder;
	}
	public WebElement getTotalPrice() {
		return totalPrice;
	}
	public WebElement getFinishOrderButton() {
		return finishOrderButton;
	}
	public WebElement getOrderConfirmMessage() {
		return orderConfirmMessage;
	}
	public WebElement getBackHomeButton() {
		return backHomeButton;
	}

}
