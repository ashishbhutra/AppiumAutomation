package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PhoneNumberLogin extends BasePage {

	@AndroidFindBy(id= "com.tubbr:id/country_name")
	MobileElement countrySelect;
	
	@AndroidFindBy(id= "com.tubbr:id/country_code_picker_search")
	MobileElement countrysearchbox;
	
	@AndroidFindBy(id= "com.tubbr:id/row_title")
	MobileElement selectSearchCountry;
	
	@AndroidFindBy(id= "com.tubbr:id/sign_in_phone_phone_number")
	MobileElement phoneNumber;
	
	@AndroidFindBy(id= "com.tubbr:id/btn_sign_in")
	MobileElement singInphoneNumber;
	
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.TextView")
	MobileElement pageTitle;
	
	
	public PhoneNumberLogin(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void openCountrylist(){
		countrySelect.click();
	}
	
	public void searchCountry(String country){
		countrysearchbox.sendKeys(country);
	}
	
	public void selectsearchCountry(){
		selectSearchCountry.click();
	}
	
	public void enterPhoneno(String phnNo){
		phoneNumber.sendKeys(phnNo);
	}
	
	public void proceed(){
		singInphoneNumber.click();
	}
	
	public String getPageTitle(){
		return pageTitle.getText();
	}

}
