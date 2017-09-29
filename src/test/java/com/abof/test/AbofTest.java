package com.abof.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.abof.pages.AbofLoginpage;
import com.abof.utils.Constant;
import com.abof.utils.ExcelUtils;
import com.abof.utils.ScreenshotUtility;
import com.abof.utils.Utils;

@Listeners({ScreenshotUtility.class})
public class AbofTest {
	
	static DesiredCapabilities cap;
	@SuppressWarnings("rawtypes")
	public static AppiumDriver driver;
	private int iTestCaseRow;
	
  @BeforeTest
  public void beforeTest() throws Exception {
	  
	 driver = Utils.mobileSetup();
  }
  
  @Test
  public void main() throws Exception{
	  
	  //This should be reflected in Git hub..
	  //Should be reflected in Git
	  AbofLoginpage abofPage = new AbofLoginpage(driver);
	  
	  ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");
	  
	  String eMail = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_UserName );
	  System.out.println(eMail);
	  
	  abofPage.setUserandPassword(eMail, "abc@123");
	  
	  if(abofPage.VerifyResult("Login"))
		  System.out.println("Passed Test");
	  else
		  System.out.println("Failed Test");
	  
  }
  
  @AfterMethod
@AfterTest
  public void tearDown()
  {
	  driver.quit();
  }
  
  

}
