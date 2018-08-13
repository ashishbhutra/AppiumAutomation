package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class TubbrHome extends BasePage {

	@AndroidFindBy(id= "com.tubbr:id/tubbr_icon")
	private MobileElement tubbrHeader;
	
	@AndroidFindBy(id= "com.tubbr:id/img_create_wall")
	private MobileElement wallcreator;
	
	@AndroidFindBy(id= "com.tubbr:id/img_notfication_icon")
	private MobileElement notification;
	
	@AndroidFindBy(id = "com.tubbr:id/img_create_post")
	private MobileElement createStory;
	
	@AndroidFindBy(id = "com.tubbr:id/home_bottom_img_wall_messages")
	private MobileElement msgHome;
	
	@AndroidFindBy(id = "com.tubbr:id/home_bottom_img_my_wall")
	private MobileElement wallHome;
	
	
	public TubbrHome(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	public void gotoProfile(){
		tubbrHeader.click();
	}
	
	public void createwall(){
		wallcreator.click();
	}
	
	public void viewNotification(){
		notification.click();
	}

	public void startStoryCreation(){
		createStory.click();
	}
	
	public void openMsgHome(){
		msgHome.click();
	}
	
	public void openwallHome(){
		wallHome.click();
	}
}
