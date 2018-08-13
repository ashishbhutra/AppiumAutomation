package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class OtpVerification extends BasePage {

	@AndroidFindBy(id= "com.tubbr:id/otp_edit_text_one")
	MobileElement text1;
	
	@AndroidFindBy(id= "com.tubbr:id/otp_edit_text_two")
	MobileElement text2;
	
	@AndroidFindBy(id= "com.tubbr:id/otp_edit_text_three")
	MobileElement text3;
	
	@AndroidFindBy(id= "com.tubbr:id/otp_edit_text_four")
	MobileElement text4;
	
	@AndroidFindBy(id= "com.tubbr:id/otp_edit_text_five")
	MobileElement text5;
	
	@AndroidFindBy(xpath ="//android.widget.FrameLayout/android.widget.RelativeLayout[2]/android.widget.LinearLayout[2]/android.widget.Button")
	MobileElement proceedBtn;
	
	public OtpVerification(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void entertext1(String otp){
		text1.sendKeys(otp);
	}
	
	public void entertext2(String otp){
		text2.sendKeys(otp);
	}
	
	public void entertext3(String otp){
		text3.sendKeys(otp);
	}
	
	public void entertext4(String otp){
		text4.sendKeys(otp);
	}
	
	public void entertext5(String otp){
		text5.sendKeys(otp);
	}
	
	public void proceed(){
		proceedBtn.click();
	}
}
