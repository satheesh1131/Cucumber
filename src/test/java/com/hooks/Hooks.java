package com.hooks;

import java.io.IOException;

import com.resources.BaseClass;
import com.stepdefinition.DemoBlazeStepDef;
import com.utilities.FileReaderManager;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
 import io.cucumber.java.Scenario;

public class Hooks {
	@Before("@signup or @faceBook or @openCart")
	public void browserSetup() throws IOException {
		BaseClass.openBrowser(FileReaderManager.getInstance().getCrInstance().browserName1());
		BaseClass.implicityWait();
	}
	@After("@order")
	public void orderVerification() {
		System.out.println(BaseClass.getText(DemoBlazeStepDef.dbElements.getOrderConfirmationMessage()));
		System.out.println(BaseClass.getText(DemoBlazeStepDef.dbElements.getOrderID()));
		BaseClass.click(DemoBlazeStepDef.dbElements.getOrderConfirmAccept());
	}
	@After("@asus or @openCart")
	public void tearDown() {
		BaseClass.closeBrowser();
	}
	@AfterStep
	public void screenshotStep(Scenario s) {
		s.attach(BaseClass.screenShot(), "image/png",s.getName());
	}
	@After
	public void screenShotScenario(Scenario s) {
		if(s.isFailed()) {
			s.attach(BaseClass.screenShot(), "image/png", s.getName());
		}
	}
}
