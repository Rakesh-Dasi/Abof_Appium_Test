package com.abof.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;

public class Utils {
	

	@SuppressWarnings("rawtypes")
	public static AppiumDriver driver=null;

	 public static void waitForElement(WebElement element)
	 {
		 
		 WebDriverWait wait = new WebDriverWait(driver, 20);
	     wait.until(ExpectedConditions.elementToBeClickable(element));
	 }

}
