package com.abof;

import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

public class ABOF {
	

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
		cap.setCapability("appPackage", "com.miui.calculator");
		cap.setCapability("appActivity", "com.miui.calculator.cal.NormalCalculatorActivity");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);	
	  
  }
  
  
  @Test
  public void f() throws Exception {
	  
	 driver.findElementById("com.miui.calculator:id/btn_3").click();
	 Thread.sleep(2000);
  }
  
  @AfterTest
  public void tearDown()
  {
	  driver.quit();
  }

}
