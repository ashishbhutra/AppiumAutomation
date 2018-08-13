package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LaunchPage extends BasePage {

	@AndroidFindBy(id="com.tubbr:id/pre_login_button_sign_in")
	private MobileElement signInBtn;
	
	@AndroidFindBy(id="com.tubbr:id/pre_login_button_sign_up")
	private MobileElement createActBtn;
	
	@AndroidFindBy(id="com.tubbr:id/alpha")
	private MobileElement pageTitle;
	
	public LaunchPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	public void gotoSignIn(){
		signInBtn.click();
	}
	
	public void gotocreateact(){
		createActBtn.click();
	}
	
	public String getPageTitle(){
		return pageTitle.getText();
	}
}
