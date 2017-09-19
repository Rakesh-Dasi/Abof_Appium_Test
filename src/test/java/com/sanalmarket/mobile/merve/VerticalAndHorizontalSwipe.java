package com.sanalmarket.mobile.merve;



import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class VerticalAndHorizontalSwipe 
{
	static DesiredCapabilities cap;
	@SuppressWarnings("rawtypes")
	static AppiumDriver driver;
    Dimension size; 
    
  @SuppressWarnings("rawtypes")//Suppressing the Java generics
  @BeforeTest
  public void beforeTest() throws Exception {
	  
	    cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.PLATFORM, "Android");
		cap.setCapability(CapabilityType.VERSION, "5.1.0"); 
		
		cap.setCapability("deviceName", "mygeny510");
		//Abof package Name
		cap.setCapability("appPackage", "com.abof.android");
		//Abof Activity name
		cap.setCapability("appActivity", "com.abof.android.landingpage.view.LandingPageView");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);			
  }
    
    @Test
    public void main() throws Exception
    {
    	Thread.sleep(3000);
    	driver.findElementByXPath("//android.widget.ImageButton[@index='0']").click();
    	Thread.sleep(3000);
    	//To swipe Vertically
    	//Get the size of screen
    	size = driver.manage().window().getSize();
    	System.out.println("The size of the screen: " + size);
    	
    	//Find swipe start and end point from screen's with and height.
    	  //Find starty point which is at bottom side of screen.
    	  int starty = (int) (size.height * 0.80);
    	  //Find endy point which is at top side of screen.
    	  int endy = (int) (size.height * 0.20);
    	  //Find horizontal point where you wants to swipe. It is in middle of screen width.
    	  int startx = size.width / 2;
    	  System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);

    	  //Swipe from Bottom to Top.
    	  driver.swipe(startx, starty, startx, endy, 3000);
    	  Thread.sleep(2000);
    	  //Swipe from Top to Bottom.
    	  driver.swipe(startx, endy, startx, starty, 3000);
    	  Thread.sleep(2000);
    	
    }

}
