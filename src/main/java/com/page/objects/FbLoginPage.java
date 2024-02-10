package com.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FbLoginPage {
	public FbLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="email")
	private WebElement usernameInputField;
	@FindBy(id="pass")
	private WebElement passwordInputField;
	@FindBy(name="login")
	private WebElement loginButton;
	public WebElement getUsernameInputField() {
		return usernameInputField;
	}
	public WebElement getPasswordInputField() {
		return passwordInputField;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}	

}
