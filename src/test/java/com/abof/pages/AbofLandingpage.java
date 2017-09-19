package com.abof.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AbofLandingpage {
	
	 @SuppressWarnings("rawtypes")
	public AbofLandingpage(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@CacheLookup //Stores the element for further reference and does not look for the element in the webpage.
	@AndroidFindBy(xpath="//android.widget.ImageButton[@index='0']")
	public static WebElement navMenu;
	
	@CacheLookup
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='8']")
	public static WebElement whatsHot;
	
	@CacheLookup
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='8']")
	public WebElement shopMen;
	
	@CacheLookup
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='8']")
	public WebElement shopWomen;
	
	@CacheLookup
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='8']")
	public WebElement myOrder;
	
	
	
	public void referFriendTC() throws Exception{
		navMenu.click();
		Thread.sleep(2000);
		whatsHot.click();
		
	}
	
	public boolean verifyText(String result){
		String text = whatsHot.getText();
		System.out.println(text);
		if (whatsHot.getText().equals(result))
			return true;
		else
			return false;
	}

}
