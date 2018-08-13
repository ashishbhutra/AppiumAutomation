package com.tubbrApp;

import java.util.concurrent.TimeUnit;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LaunchPage;

public class LaunchPageTest extends TestBase {

	private LaunchPage launchPageObj;
	
	@BeforeTest
    @Override
    public void setUpPage() {
		launchPageObj = new LaunchPage(driver);
    }
	
	@Override
    public String getName() {
        return "Alpha";
    }
	
	@Test
	public void checkLaunchPage(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		AssertJUnit.assertEquals(launchPageObj.getPageTitle(),"ALPHA");
	}
	
	@Test
	public void signupPage(){
		launchPageObj.gotoSignIn();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
}
