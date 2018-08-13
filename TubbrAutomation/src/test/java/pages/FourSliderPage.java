package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class FourSliderPage extends BasePage {

	@AndroidFindBy(id ="com.tubbr:id/four_slide_activity_title_top_header")
	private MobileElement fourSlidePageTitle;
	
	@AndroidFindBy(id="com.tubbr:id/img_proceed")
	private MobileElement okBtn;
	
	public FourSliderPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	public String getPageTitle(){
		return fourSlidePageTitle.getText();
	}
	
	public void clickokBtn(){
		okBtn.click();
	}
	
	
}
