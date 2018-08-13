package pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class GoogleAcSelectPage extends BasePage {

	@AndroidFindBy(id = "com.google.android.gms:id/title")
	private MobileElement googleAcpageTitle;
	
	//@AndroidFindBy(id="android:id/list")
	@FindBy(xpath = "//android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout")
	private List<WebElement> userAccEmailid;
	
	@AndroidFindBy(id ="android:id/button2")
	private MobileElement addAnotherAcc;
	
	public GoogleAcSelectPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}
	
	public void clickEmail(String email){
		
		WebDriverWait driverwait = new WebDriverWait(driver,10);
		driverwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout")));
		
		System.out.println(userAccEmailid.size());
		Iterator<WebElement> iter = userAccEmailid.iterator();
	
		while(iter.hasNext()) {
			WebElement mele = iter.next();
		    System.out.println(mele.getText());
		    if (mele.getText().equals(email)) {
		    	mele.click();
		    // do something in else perhaps
		    }
		}
	}
	
	public void addaccount(){
		addAnotherAcc.click();
	}
}
