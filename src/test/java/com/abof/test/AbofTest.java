package com.abof.test;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.abof.pages.AbofLoginpage;
import com.abof.utils.ScreenshotUtility;
import com.abof.utils.Utils;

@Listeners({ScreenshotUtility.class})
public class AbofTest {
	
	static DesiredCapabilities cap;
	@SuppressWarnings("rawtypes")
	public static AppiumDriver driver;
  @BeforeTest
  public void beforeTest() throws Exception {
	  
	 driver = Utils.mobileSetup();
  }
  
  @Test
  public void main() throws Exception{
	  
	  //This should be reflected in Git hub..
	  //Should be reflected in Git
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
