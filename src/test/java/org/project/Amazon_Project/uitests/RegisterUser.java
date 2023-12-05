package org.project.Amazon_Project.uitests;

import java.io.IOException;

import org.project.Amazon_Project.pageobjects.ActionClass;
import org.project.Amazon_Project.pageobjects.ReadData;
import org.project.Amazon_Project.pageutils.HomePage;
import org.project.Amazon_Project.pageutils.RegistrationPage;
import org.project.Amazon_Project.base.BaseClass;
import org.testng.annotations.Test;

public class RegisterUser extends BaseClass {
	@Test
	public void NewRegistration() throws IOException, InterruptedException {
		HomePage home = new HomePage(driver);
		RegistrationPage register = new RegistrationPage(driver);
		ReadData data = new ReadData();
		ActionClass action = new ActionClass(driver);
		home.OpenHomePage();
		// Applying wait to manually enter captcha value
		action.ImplicitWait(10);
		action.DoubleClick(home.OpenMyAccount());
		home.OpenRegistration();
		register.EnterName(data.GetName());
		register.EnterEmail(data.GetEmail());
		register.EnterPassword(data.GetPassword());
		register.Submit();
		register.AuthenticationCheck("Authentication required");
	}

}
