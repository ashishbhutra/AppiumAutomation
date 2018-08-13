package com.tubbrApp;

import java.util.concurrent.TimeUnit;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;

public class LoginTest extends TestBase {

private LoginPage loginPageObj;
	
	@BeforeTest
    @Override
    public void setUpPage() {
		loginPageObj = new LoginPage(driver);
    }
	
	@Override
    public String getName() {
        return "Alpha";
    }
	
	@Test(priority =0)
	public void checkLoginPage(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		AssertJUnit.assertEquals(loginPageObj.getPageTitle(), "Access Your Account");
	}
	@Test(priority =1)
	public void LoginViaUsername(){
		String uname = "ashish";
		String pass = "ashish123";
		loginPageObj.setusername(uname);
		loginPageObj.setpass(pass);
		loginPageObj.clickLogin();
		
	}
}
