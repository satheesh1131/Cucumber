package com.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoBlazePage {
		public DemoBlazePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		@FindBy(xpath="(//button[text()='Close'])[2]")
		private WebElement signupCloseButton;
		public WebElement getSignupCloseButton() {
			return signupCloseButton;
		}
		@FindBy(xpath="//div[@class='sweet-alert  showSweetAlert visible']//h2")
		private WebElement orderConfirmationMessage;
		@FindBy(xpath="//p[@class='lead text-muted ']")
		private WebElement orderID;
		@FindBy(xpath="//button[@class='confirm btn btn-lg btn-primary']")
		private WebElement orderConfirmAccept;
		@FindBy(css="a#signin2")
		private WebElement signupOption;
		@FindBy(css="input#sign-username")
		private WebElement usernameSignupInput;
		@FindBy(css="input#sign-password")
		private WebElement passwordSignupInput;
		@FindBy(xpath="//button[text()='Sign up']")
		private WebElement signupButton;
		@FindBy(css="input#loginusername")
		private WebElement usernameLoginInput;
		@FindBy(css="input#loginpassword")
		private WebElement passwordLoginInput;
		@FindBy(xpath="//button[text()='Log in']")
		private WebElement loginButton;
		public WebElement getUsernameSignupInput() {
			return usernameSignupInput;
		}
		public WebElement getPasswordSignupInput() {
			return passwordSignupInput;
		}
		public WebElement getSignupButton() {
			return signupButton;
		}
		public WebElement getUsernameLoginInput() {
			return usernameLoginInput;
		}
		public WebElement getPasswordLoginInput() {
			return passwordLoginInput;
		}
		public WebElement getLoginButton() {
			return loginButton;
		}
		@FindBy(css="a#login2")
		private WebElement loginOption;
		@FindBy(css="a#cartur")
		private WebElement cartOption;
		@FindBy(xpath="//a[text()='Monitors']")
		private WebElement monitorOption;
		@FindBy(xpath="//a[text()='Apple monitor 24']")
		private WebElement appleMonitorProduct;
		@FindBy(xpath="//a[text()='ASUS Full HD']")
		private WebElement asusMonitorProduct;
		@FindBy(xpath="//a[@onclick='addToCart(10)']")
		private WebElement appleMonitorAddCart;
		@FindBy(xpath="//a[@onclick='addToCart(14)']")
		private WebElement asusMonitorAddCart;
		@FindBy(css="button.btn.btn-success")
		private WebElement placeOrderButton;
		@FindBy(css="input#name")
		private WebElement nameInput;
		@FindBy(css="input#country")
		private WebElement countryInput;
		@FindBy(css="input#city")
		private WebElement cityInput;
		@FindBy(css="input#card")
		private WebElement creditCardInput;
		@FindBy(css="input#month")
		private WebElement monthInput;
		@FindBy(css="input#year")
		private WebElement yearInput;
		@FindBy(xpath="//button[text()='Purchase']")
		private WebElement purchaseButton;
		public WebElement getOrderConfirmationMessage() {
			return orderConfirmationMessage;
		}
		public WebElement getOrderID() {
			return orderID;
		}
		public WebElement getOrderConfirmAccept() {
			return orderConfirmAccept;
		}
		public WebElement getSignupOption() {
			return signupOption;
		}
		public WebElement getLoginOption() {
			return loginOption;
		}
		public WebElement getCartOption() {
			return cartOption;
		}
		public WebElement getMonitorOption() {
			return monitorOption;
		}
		public WebElement getAppleMonitorProduct() {
			return appleMonitorProduct;
		}
		public WebElement getAsusMonitorProduct() {
			return asusMonitorProduct;
		}
		public WebElement getAppleMonitorAddCart() {
			return appleMonitorAddCart;
		}
		public WebElement getAsusMonitorAddCart() {
			return asusMonitorAddCart;
		}
		public WebElement getPlaceOrderButton() {
			return placeOrderButton;
		}
		public WebElement getNameInput() {
			return nameInput;
		}
		public WebElement getCountryInput() {
			return countryInput;
		}
		public WebElement getCityInput() {
			return cityInput;
		}
		public WebElement getCreditCardInput() {
			return creditCardInput;
		}
		public WebElement getMonthInput() {
			return monthInput;
		}
		public WebElement getYearInput() {
			return yearInput;
		}
		public WebElement getPurchaseButton() {
			return purchaseButton;
		}


}
