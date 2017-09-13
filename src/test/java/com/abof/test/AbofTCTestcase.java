package com.abof.test;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
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
    	
    	@SuppressWarnings("unused")
		AbofLandingpage abof = new AbofLandingpage(driver);
    	TearmAndConditions_Action.Execute();
    	
    }
    
}

