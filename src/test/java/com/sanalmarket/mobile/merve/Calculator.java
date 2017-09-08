package com.sanalmarket.mobile.merve;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Calculator
{
	WebDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException
	{
	/*About Desired Capabilites Class.
	 *  
	 * The testing environment can be a web browser, mobile device, mobile emulator, mobile simulator, etc.
	 * The desired capability is a series of key/value pairs that stores the browser properties like browsername, browser version, the path of the browser driver in the system, etc. 
	 * to determine the behaviour of the browser at run time.
	 */
		//Set up desired capabilities and pass the Android app-activity and app-package to Appium
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//capabilities.setCapability("BROWSER_NAME", "Chrome");
		
		/*
		 * The setCapability() method of the Desired Capabilities class can be used to set the 
		 * 1.Device name
		 * 2.Platform version
		 * 3.Platform name
		 * 4.Absolute path of the app under test (the .apk file of the app(Android) under test)
		 * 5.App Activity (in Android) and appPackage(java).
		 * To understand more on the Desired Capability Class URL: http://www.guru99.com/desired-capabilities-selenium.html 
		 */
		capabilities.setCapability("VERSION", "4.4.4"); 
		capabilities.setCapability("deviceName","Android");
		capabilities.setCapability("platformName","Android");
	 
	   
	   capabilities.setCapability("appPackage", "com.android.calculator2");
	// This package name of your app (you can get it from apk info app)
		capabilities.setCapability("appActivity","com.android.calculator2.Calculator"); // This is Launcher activity of your app (you can get it from apk info app)
	//Create RemoteWebDriver instance and connect to the Appium server
	 //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
	   driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	   
	   /*
	    * RemoteWebDriver: This driver class comes directly from the upstream Selenium project. 
	    * This is a pretty generic driver where initializing the driver means making network requests to a Selenium hub to start a driver session.
	    * Since Appium operates on the client-server model, Appium uses this to initialize a driver session. 
	    * However, directly using the RemoteWebDriver is not recommended since there are other drivers available that offer additional features or convenience functions.

        * AppiumDriver: This driver class inherits from the RemoteWebDriver class, but it adds in additional functions that are useful in the context of a mobile automation test through the Appium server.

        * AndroidDriver: This driver class inherits from AppiumDriver, but it adds in additional functions that are useful in the context of a mobile automation test on Android devices through Appium. Only use this driver class if you want to start a test on an Android device or Android emulator.

        * IOSDriver: This driver class inherits from AppiumDriver, but it adds in additional functions that are useful in the context of a mobile automation test on iOS devices through Appium. Only use this driver class if you want to start a test on an iOS device or iOS emulator.
	    */
	}

	@Test
	public void testCal() throws Exception 
	{
	   //locate the Text on the calculator by using By.name()
	   WebElement two=driver.findElement(By.name("2"));
	   two.click();
	   WebElement plus=driver.findElement(By.name("+"));
	   plus.click();
	   WebElement four=driver.findElement(By.name("4"));
	   four.click();
	   WebElement equalTo=driver.findElement(By.name("="));
	   equalTo.click();
	   //locate the edit box of the calculator by using By.tagName()
	   WebElement results=driver.findElement(By.id("com.android.calculator2:id/formula"));
		//Check the calculated value on the edit box
	assert results.getText().equals("6"):"Actual value is : "+results.getText()+" did not match with expected value: 6";

	}

	@AfterClass
	public void teardown()
	{
		//close the app
		driver.quit();
	}


}
