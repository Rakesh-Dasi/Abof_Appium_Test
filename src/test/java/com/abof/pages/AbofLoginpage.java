package com.abof.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class AbofLoginpage {
 
	@SuppressWarnings("rawtypes")
	public AbofLoginpage(AppiumDriver driver){
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id="com.abof.android:id/email_login_btn")
	public WebElement loginBtn;
	
	@AndroidFindBy(id="com.abof.android:id/login_email_edt")
	public WebElement username;
	
	@AndroidFindBy(id="com.abof.android:id/login_password_edt_edt")
	public WebElement password;
	
	@AndroidFindBy(id="com.abof.android:id/signin_register1")
	public WebElement txtResult;
	
	public void setUserandPassword(String uName, String uPassword) throws Exception{
		
	    Thread.sleep(2000);  
		loginBtn.click();
		
		username.sendKeys(uName);
		password.sendKeys(uPassword);
		
	}
	
	public boolean VerifyResult(String result){
		String text = txtResult.getText();
		System.out.println(text);
		if (txtResult.getText().equals(result))           			
			
			return true;
		else 
			return false;
			
	}

	
	
	

}
