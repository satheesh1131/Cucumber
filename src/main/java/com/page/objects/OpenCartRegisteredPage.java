package com.page.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenCartRegisteredPage {

	public OpenCartRegisteredPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountOption;
	@FindBy(xpath="//a[text()='Register']")
	private WebElement registerOption;
	@FindBy(css="input#input-firstname")
	private WebElement firstNameInput;
	@FindBy(id="input-lastname")
	private WebElement lastNameInput;
	@FindBy(id="input-email")
	private WebElement mailNameInput;
	@FindBy(id="input-password")
	private WebElement passWordInput;
	@FindBy(xpath="//input[@id='input-newsletter-yes']")
	private WebElement newsLetterRadioButton;
	@FindBy(xpath="//input[@name='agree']")
	private WebElement readAgreementCheckBox;
	@FindBy(xpath="//button[text()='Continue']")
	private WebElement continueButton;
	public WebElement getMyAccountOption() {
		return myAccountOption;
	}
	public WebElement getRegisterOption() {
		return registerOption;
	}
	public WebElement getFirstNameInput() {
		return firstNameInput;
	}
	public WebElement getLastNameInput() {
		return lastNameInput;
	}
	public WebElement getMailNameInput() {
		return mailNameInput;
	}
	public WebElement getPassWordInput() {
		return passWordInput;
	}
	public WebElement getNewsLetterRadioButton() {
		return newsLetterRadioButton;
	}
	public WebElement getReadAgreementCheckBox() {
		return readAgreementCheckBox;
	}
	public WebElement getContinueButton() {
		return continueButton;
	}	

}
