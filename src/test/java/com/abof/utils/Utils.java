package com.abof.utils;

import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Utils {
	

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
	 
	 

}
