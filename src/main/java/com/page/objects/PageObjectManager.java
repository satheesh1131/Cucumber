package com.page.objects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	WebDriver driver;
	public PageObjectManager(WebDriver driver1) {
		this.driver=driver1;
	}
	public FbLoginPage getFbLoginPage() {
		return new FbLoginPage(driver);
	}
	public SauceDemoPage getSauceDemoPage() {
		return new SauceDemoPage(driver);
	}
	public DemoBlazePage getDemoBlazePage() {
		return new DemoBlazePage(driver);
	}
	public OpenCartRegisteredPage getOpenCartRegisterPage() {
		return new OpenCartRegisteredPage(driver);
	}
	
}
