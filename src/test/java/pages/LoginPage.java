package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class LoginPage extends BasePage {

	
	@AndroidFindBy(id= "com.tubbr:id/sign_in_username")
	private MobileElement username;
	
	@AndroidFindBy(id= "com.tubbr:id/sign_in_password")
	private MobileElement password;
	
	@AndroidFindBy(id= "com.tubbr:id/btn_sign_in")
	private MobileElement loginBtn;
	
	@AndroidFindBy(xpath = "//android.widget.ScrollView/android.widget.LinearLayout/android.widget.TextView[1]")
	private MobileElement pageTitle;
	
	@AndroidFindBy(id="com.tubbr:id/sign_in_via_google")
	private MobileElement googleBtn;
	
	@AndroidFindBy(id="com.tubbr:id/sign_in_via_phone")
	private MobileElement phoneBtn;
	
	
	public LoginPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	public void setusername(String uname){
		username.sendKeys(uname);
	}
	
	public void setpass(String pass){
		password.sendKeys(pass);
	}
	
	public void clickLogin(){
		loginBtn.click();
	}
	
	public void clickgoogle(){
		driver.hideKeyboard();
		googleBtn.click();
	}
	
	public void clickphone(){
		phoneBtn.click();
	}
	
	public String getPageTitle(){
		return pageTitle.getText();
	}

}
