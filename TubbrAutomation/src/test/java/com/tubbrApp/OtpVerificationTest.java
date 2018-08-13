package com.tubbrApp;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.PhoneNumberLogin;
import pages.OtpVerification;
import pages.LoginPage;
import utility.ParseSMS;
import utility.ExtractCode;


public class OtpVerificationTest extends TestBase {

	private LoginPage LoginpageObj;
	private PhoneNumberLogin phoneLoginObj;
	private OtpVerification OtpVerifyObj;
	public String country = "india";
	public String mySMS = null;
	
	@Override
	public String getName() {
		return "Tubbr";
	}

	@BeforeTest
	@Override
	public void setUpPage() {
		// TODO Auto-generated method stub
		LoginpageObj = new LoginPage(driver);
		phoneLoginObj = new PhoneNumberLogin(driver);
		OtpVerifyObj = new OtpVerification(driver);
	}
	
	@Test
	@Parameters({"udid"})
	public void loginByPhoneno(@Optional String udid){
		//driver.hideKeyboard();
		LoginpageObj.clickphone();
		phoneLoginObj.openCountrylist();
		phoneLoginObj.searchCountry(country);
		phoneLoginObj.selectsearchCountry();
		phoneLoginObj.enterPhoneno("9644777722");
	
	
		ExtractCode eCode = new ExtractCode(driver);
		
		try {
			eCode.installSMSAPK(udid);
			eCode.configureSMSAPK(udid);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		phoneLoginObj.proceed();
		
		try {
		
		 mySMS = eCode.returnSMS(udid);
		 System.out.println(mySMS);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String otpfull = ParseSMS.getSMS(mySMS);
		String [] otp = otpfull.split("");
		System.out.println(otp[0]);
		System.out.println(otp[1]);
		OtpVerifyObj.entertext1(otp[0]);
		OtpVerifyObj.entertext2(otp[1]);
		OtpVerifyObj.entertext3(otp[2]);
		OtpVerifyObj.entertext4(otp[3]);
		OtpVerifyObj.entertext5(otp[4]);
		OtpVerifyObj.proceed();
		try {
			
				eCode.uninstallSMSAPK(udid);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	

}
