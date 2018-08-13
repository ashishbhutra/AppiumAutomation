package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class settingsPage extends BasePage {

	@AndroidFindBy(xpath = "//android.widget.FrameLayout/android.widget.RelativeLayout[1]/android.widget.TextView[1]")
	private MobileElement settingHeader;
	
	@AndroidFindBy(id = "com.tubbr:id/settings_container_logout")
	private MobileElement logoutBtn;
	
	
	public settingsPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	public void clickLogout(){
		logoutBtn.click();
	}
	
	public String getSettingPageHeader(){
		return settingHeader.getText();
	}
}
