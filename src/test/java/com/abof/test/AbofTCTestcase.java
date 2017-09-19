package com.abof.test;

import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import appModules.TearmAndConditions_Action;

import com.abof.pages.AbofLandingpage;
import com.abof.utils.Utils;

public class AbofTCTestcase {
	
	public static DesiredCapabilities cap;
    @SuppressWarnings("rawtypes")
	public static AppiumDriver driver;
    
    @BeforeTest
    public void mobileSetup() throws Exception
    {
    	driver = Utils.mobileSetup();
    }

    
    @Test 
    public void main() throws Exception{    	   
		
    	AbofLandingpage abof = new AbofLandingpage(driver);
    	
    	TearmAndConditions_Action.Execute();
    	Utils.swipingVerticalBottomToTop();     	
    	
    }
    
    @AfterTest
    public void tearDown() throws Exception
    {
    	Thread.sleep(2000);
    	driver.quit();
    }
    
}

