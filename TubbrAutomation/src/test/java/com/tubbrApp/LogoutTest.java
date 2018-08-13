package com.tubbrApp;

import java.util.concurrent.TimeUnit;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.TubbrHome;
import pages.ProfilePage;
import pages.settingsPage;
import pages.LoginPage;

public class LogoutTest extends TestBase {
	
	private TubbrHome TubbrHomeObj;
	private ProfilePage profilepageObj;
	private settingsPage settingPageObj;
	private LoginPage LoginPageObj;
	
	@Override
	public String getName() {
		return "Tubbr";
	}

	@BeforeTest
	@Override
	public void setUpPage() {
		TubbrHomeObj = new TubbrHome(driver);
		profilepageObj = new ProfilePage(driver);
		settingPageObj = new settingsPage(driver);
		LoginPageObj = new LoginPage(driver);
	}
	
	@Test
	public void logoutTubbr(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TubbrHomeObj.gotoProfile();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		profilepageObj.getsettings();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		settingPageObj.clickLogout();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		AssertJUnit.assertEquals(LoginPageObj.getPageTitle(), "Access Your Account");
	}

}
