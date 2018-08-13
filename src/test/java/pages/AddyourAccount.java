package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class AddyourAccount extends BasePage{

	@FindBy(id= "identifierId")
	WebElement newemail;
	
	@FindBy(id = "password")
	WebElement pass;
	
	@FindBy(id = "next")
	WebElement nextbtn;
	
	protected AddyourAccount(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void setnewemail(String nemail){
		newemail.sendKeys(nemail);
	}
	
	public void setpass(String password){
		pass.sendKeys(password);
	}
	
	public void clicknextbtn(){
		nextbtn.click();
	}
	

}
