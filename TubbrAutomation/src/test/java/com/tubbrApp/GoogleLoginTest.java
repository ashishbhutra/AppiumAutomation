package com.tubbrApp;

import io.appium.java_client.MobileElement;

import java.awt.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.GoogleAcSelectPage;
//import pages.AddyourAccount;

public class GoogleLoginTest extends TestBase{

	private LoginPage GoogleLoginObj;
	private GoogleAcSelectPage selectaccObj;
	
	@Override
	public String getName() {
		return "googleTest";
	}

	@BeforeTest
	@Override
	public void setUpPage() {
		GoogleLoginObj = new LoginPage(driver);
	}
	
	@Test
	public void selectaddedacc(){
		String email = "ashishbhutra88@gmail.com";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		GoogleLoginObj.clickgoogle();
		WebDriverWait driverwait = new WebDriverWait(driver,10);
		driverwait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout")));
		MobileElement me =  driver.findElement(By.xpath("//android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout"));
		me.click();
		/*Set<String> contextHandles = driver.getContextHandles();
		
		for(String s : contextHandles){
			System.out.println("Context : "+ s);
			
			if(s.contains("WEBViEW")){
				driver.context(s);
			}
		}*/
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//selectaccObj.clickEmail(email);
			
	}
	

}
