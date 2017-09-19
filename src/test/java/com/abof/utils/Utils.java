package com.abof.utils;

import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Utils {
	
    public static Dimension size;
	@SuppressWarnings("rawtypes")
	public static AppiumDriver driver=null;
	public static DesiredCapabilities cap;

	 public static void waitForElement(WebElement element)
	 {
		 
		 WebDriverWait wait = new WebDriverWait(driver, 20);
	     wait.until(ExpectedConditions.elementToBeClickable(element));
	 }
	 
	 @SuppressWarnings("rawtypes")
	public static AppiumDriver mobileSetup() throws Exception
	 {
		 cap = new DesiredCapabilities();
		 cap.setCapability(CapabilityType.PLATFORM, "Android");
		 cap.setCapability(CapabilityType.VERSION, "5.1.0"); 
			
		 cap.setCapability("deviceName", "mygeny510");
			//Abof package Name
		 cap.setCapability("appPackage", "com.abof.android");
			//Abof Activity name
		 cap.setCapability("appActivity", "com.abof.android.landingpage.view.LandingPageView");
		 driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);	   
		 return driver;
		 
	 }
	 
	 public static void swipingVerticalBottomToTop() throws Exception
	 {
		 Thread.sleep(2000);
		 //Get the size of screen.
		  size = driver.manage().window().getSize();
		  System.out.println(size);
		   
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
		  
	 }
	 
	 public static void swipingVerticalTopToBottom() throws Exception
	 {
		 Thread.sleep(2000);
		//Get the size of screen.
		  size = driver.manage().window().getSize();
		  System.out.println(size);
		   
		  //Find swipe start and end point from screen's with and height.
		  //Find starty point which is at bottom side of screen.
		  int starty = (int) (size.height * 0.80);
		  //Find endy point which is at top side of screen.
		  int endy = (int) (size.height * 0.20);
		  //Find horizontal point where you wants to swipe. It is in middle of screen width.
		  int startx = size.width / 2;
		  System.out.println("starty = " + starty + " ,endy = " + endy + " , startx = " + startx);
		  
		//Swipe from Top to Bottom.
		  driver.swipe(startx, endy, startx, starty, 3000);
		  Thread.sleep(2000);
	 }
	 
	 public static void swipingHorizontalRightToLeft() throws Exception
	 {
		 Thread.sleep(2000);
		//Get the size of screen.
		  size = driver.manage().window().getSize();
		  System.out.println(size);
		  
		  //Find swipe start and end point from screen's with and height.
		  //Find startx point which is at right side of screen.
		  int startx = (int) (size.width * 0.70);
		  //Find endx point which is at left side of screen.
		  int endx = (int) (size.width * 0.30);
		  //Find vertical point where you wants to swipe. It is in middle of screen height.
		  int starty = size.height / 2;
		  System.out.println("startx = " + startx + " ,endx = " + endx + " , starty = " + starty);

		  //Swipe from Right to Left.
		  driver.swipe(startx, starty, endx, starty, 3000);
		  Thread.sleep(2000);
	 }
	 
	 public static void swipingHorizontalLeftToRight() throws Exception
	 {
		  Thread.sleep(2000);
		 //Get the size of screen.
		  size = driver.manage().window().getSize();
		  System.out.println(size);
		  
		  //Find swipe start and end point from screen's with and height.
		  //Find startx point which is at right side of screen.
		  int startx = (int) (size.width * 0.70);
		  //Find endx point which is at left side of screen.
		  int endx = (int) (size.width * 0.30);
		  //Find vertical point where you wants to swipe. It is in middle of screen height.
		  int starty = size.height / 2;
		  System.out.println("startx = " + startx + " ,endx = " + endx + " , starty = " + starty);

		  //Swipe from Left to Right.
		  driver.swipe(endx, starty, startx, starty, 3000);
		  Thread.sleep(2000);
     }
	

}
