package com.tubbrApp;

import io.appium.java_client.TouchAction;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.FourSliderPage;

public class FourSliderTest extends TestBase {

private FourSliderPage fourSliderObj;
	
	@BeforeTest
    @Override
    public void setUpPage() {
		fourSliderObj = new FourSliderPage(driver);
    }
	
	@Override
    public String getName() {
        return "Quick Start";
    }
	
	@Test
	public void checkfourSlider(){
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		AssertJUnit.assertEquals(fourSliderObj.getPageTitle(), "Quick Start");
	}
	
	@Test
	public void slideandAccept(){
		int swipe_count =3, i=0;
		for(i=0;i<swipe_count;i++){
			swipeLeft();
			System.out.println(i);		
		}
		fourSliderObj.clickokBtn();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	 public void swipeLeft () {
			// calculate the screen size and get the coordinates for the swipe'
	
			
			Dimension screenSize = driver.manage().window().getSize();
			System.out.println(screenSize);
			int sWidth = screenSize.getWidth();
			System.out.println(sWidth);
			int sHeight = screenSize.getHeight();
			System.out.println(sHeight);
			
			int sx = sWidth/2;
			int sy = sHeight/2;
			System.out.println(sx +"--"+ sy);
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			(new TouchAction(driver))
			  .press((sx+(sx/2)), (sy+(sy/2)))
			  .moveTo(-sx,0)
			  .release()
			  .perform();
	 }	

}
