package com.abof.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AbofLandingpage {
	
	 @SuppressWarnings("rawtypes")
	public AbofLandingpage(AppiumDriver driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@index='0']")
	public static WebElement navMenu;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='8']")
	public static WebElement whatsHot;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='8']")
	public WebElement shopMen;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='8']")
	public WebElement shopWomen;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='8']")
	public WebElement myOrder;
	
	
	
	public void referFriendTC() throws Exception{
		navMenu.click();
		Thread.sleep(2000);
		referFriend.click();
		
	}
	
	public boolean verifyText(String result){
		String text = referFriend.getText();
		System.out.println(text);
		if (referFriend.getText().equals(result))
			return true;
		else
			return false;
	}

}
