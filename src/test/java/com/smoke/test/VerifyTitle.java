package com.smoke.test;

import library.Utility;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class VerifyTitle 
{
	ExtentReports report;
	ExtentTest logger;
	WebDriver driver;
	
	@Test 
	public void verifyBlogTitle()
	{
		report=new ExtentReports("D:\\Rakesh\\Extent Report\\result.html");
		 
		logger=report.startTest("VerifyBlogTitle");
		
		 System.setProperty("webdriver.chrome.driver","D:\\Rakesh\\Chrome Driver 2.21\\chromedriver.exe");
		 
		driver=new ChromeDriver();
	
		driver.manage().window().maximize();
		 
		logger.log(LogStatus.INFO, "Browser started ");
		 
		driver.get("http://learn-automation.com/use-firefox-selenium-using-geckodriver-selenium-3/");
		 
		logger.log(LogStatus.INFO, "Application is up and running");
		 
		String title=driver.getTitle();
		 
		Assert.assertTrue(title.contains("Google")); 
		 
		logger.log(LogStatus.PASS, "Title verified");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{if(result.getStatus()==ITestResult.FAILURE)
	{
		 
		String screenshot_path=Utility.captureScreenshot(driver, result.getName());
		String image= logger.addScreenCapture(screenshot_path);
		logger.log(LogStatus.FAIL, "Title verification", image);
		 
		 
		}
		 
		report.endTest(logger);
		report.flush();
		 
		driver.get("D:\\Rakesh\\Extent Report\\result.html");
	}
	
	

}
