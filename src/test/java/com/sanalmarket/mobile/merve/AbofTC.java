package com.sanalmarket.mobile.merve;

import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

public class AbofTC {
	

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
  public void f() throws Exception {
	System.out.println("Launch application");
	//Click on the menu button.
	Thread.sleep(3000);
	
	driver.findElementByXPath("//android.widget.ImageButton[@index='0']").click();
	System.out.println("Clicked");
	//Click on Refer a friend
	Thread.sleep(3000);
	driver.findElementByXPath("//android.widget.LinearLayout[@index='8']").click();
	Thread.sleep(2000);
	driver.findElementByName("See How It Works").click();
	//Verify refer a Friend
	
	String text = driver.findElementById("com.abof.android:id/text_title").getText();
	System.out.println(text);
	Assert.assertEquals(text, "Refer a Friend");
	
	
	
  }
  
  @AfterTest
  public void tearDown() throws Exception
  {
	  Thread.sleep(3000);
	  driver.quit();
  }
  

	 public static void waitForElement(WebElement element)
	 {
		 
		 WebDriverWait wait = new WebDriverWait(driver, 20);
	     wait.until(ExpectedConditions.elementToBeClickable(element));
	 }

}
