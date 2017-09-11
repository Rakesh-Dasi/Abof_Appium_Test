package com.abof.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.abof.pages.AbofLoginpage;

public class AbofTest {
	
	static DesiredCapabilities cap;
	@SuppressWarnings("rawtypes")
	static AppiumDriver driver;
  @SuppressWarnings("rawtypes")
 
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
  public void main() throws Exception{
	  
	  //This should be reflected in Git hub..
	  AbofLoginpage abofPage = new AbofLoginpage(driver);
	  abofPage.setUserandPassword("abc@example.com", "abc@123");
	  
	  if(abofPage.VerifyResult("Login"))
		  System.out.println("Passed Test");
	  else
		  System.out.println("Failed Test");
	  
  }
  
  @AfterTest
  public void tearDown()
  {
	  driver.quit();
  }
  
  

}
