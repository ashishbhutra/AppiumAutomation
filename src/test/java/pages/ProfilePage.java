package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProfilePage extends BasePage {

	@AndroidFindBy(xpath = "//android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.TextView")
	private MobileElement myFriends;
	
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout/android.widget.LinearLayout[4]/android.widget.TextView")
	private MobileElement addFriends;
	
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout/android.widget.LinearLayout[5]/android.widget.TextView")
	private MobileElement addme;
	
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout/android.widget.LinearLayout[6]/android.widget.TextView")
	private MobileElement inviteFriends;
	
	@AndroidFindBy(id = "com.tubbr:id/network_home_img_settings")
	private MobileElement settingIcon;
	
	public ProfilePage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	public void getmyFriends(){
		myFriends.click();
	}
	
	public void getFriends(){
		addFriends.click();
	}
	
	public void getaddme(){
		addme.click();
	}
	
	public void getinviteFriends(){
		inviteFriends.click();
	}
	
	public String getinviteFriendTxt(){
		return inviteFriends.getText();
	}
	
	public void getsettings(){
		settingIcon.click();
	}
	
}
