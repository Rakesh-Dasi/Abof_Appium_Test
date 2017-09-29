package com.sanalmarket.mobile.merve;

import java.io.File;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AbofTC {
	
	ExtentReports extent;
	ExtentTest logger;
	static DesiredCapabilities cap;
	@SuppressWarnings("rawtypes")
	static AppiumDriver driver;
  @SuppressWarnings("rawtypes")
 
  @BeforeTest
  public void beforeTest() throws Exception {
	  //Destination Folder for the Extent report.
	  extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/AppiumReport.html",true);
	  //To Give User Info
	  extent
	          .addSystemInfo("Host Name","Appium Test")
	          .addSystemInfo("Environment", "Automation Testing")
	          .addSystemInfo("User Name", "Rakesh");
	  //To load the configuration File
	  extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	  
	    cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.PLATFORM, "Android");
		cap.setCapability(CapabilityType.VERSION, "5.1.0"); 
		
		cap.setCapability("deviceName", "mygeny510");
		//Abof package Name
		cap.setCapability("appPackage", "com.abof.android");
		//Abof Activity name
		cap.setCapability("appActivity", "com.abof.android.landingpage.view.LandingPageView");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);		  
		
  }
  
  
  public static String getScreenhot(WebDriver driver, String screenshotName) throws Exception {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
              //after execution, you could see a folder "FailedTestsScreenshots" under src folder
		String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
  
  
  
  
  @Test
  public void f() throws Exception {
	System.out.println("Launch application");
	//Click on the menu button.
	Thread.sleep(3000);
	//To log the test case name in the Extent Report
	logger = extent.startTest("Abof Landing Page");
	driver.findElementByXPath("//android.widget.ImageButton[@index='0']").click();
	System.out.println("Clicked");
	//Click on Refer a friend
	Thread.sleep(3000);
	driver.findElementByXPath("//android.widget.LinearLayout[@index='8']").click();
	Thread.sleep(2000);
	driver.findElementByName("See How It Works").click();
	//Verify refer a Friend
	
	//To Verify
	Assert.assertTrue(true);
	
	logger.log(LogStatus.PASS, "Test Case Passed");
	
	String text = driver.findElementById("com.abof.android:id/text_title").getText();
	System.out.println(text);
	Assert.assertEquals(text, "Refer a Friend");
	
	
	
  }
  
  @AfterMethod
	public void getResult(ITestResult result) throws Exception{
		if(result.getStatus() == ITestResult.FAILURE){
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			logger.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
			//To capture screenshot path and store the path of the screenshot in the string "screenshotPath"
                      //We do pass the path captured by this method in to the extent reports using "logger.addScreenCapture" method. 			
                      String screenshotPath = AbofTC.getScreenshot(driver, result.getName());
			//To add it in the extent report 
			logger.log(LogStatus.FAIL, logger.addScreenCapture(screenshotPath));
		}else if(result.getStatus() == ITestResult.SKIP){
			logger.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}
		// ending test
		//endTest(logger) : It ends the current test and prepares to create HTML report
		extent.endTest(logger);
	}
  
  
 
  
  
  @AfterTest
  public void tearDown() throws Exception
  {
	// writing everything to document
			//flush() - to write or update test information to your report. 
	                extent.flush();
	                //Call close() at the very end of your session to clear all resources. 
	                //If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
	                //You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream. 
	                //Once this method is called, calling any Extent method will throw an error.
	                //close() - To close all the operation
	                extent.close();  
	  
	  Thread.sleep(3000);
	  driver.quit();
  }
  

	 public static void waitForElement(WebElement element)
	 {
		 
		 WebDriverWait wait = new WebDriverWait(driver, 20);
	     wait.until(ExpectedConditions.elementToBeClickable(element));
	 }
	 
	 
	 
	 public static String getScreenshot(WebDriver driver, String screenshotName) throws Exception {
	      //below line is just to append the date format with the screenshot name to avoid duplicate names		
	      String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	      //after execution, you could see a folder "FailedTestsScreenshots" under src folder
	String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/"+screenshotName+dateName+".png";
	File finalDestination = new File(destination);
	FileUtils.copyFile(source, finalDestination);
	      //Returns the captured file path
	return destination;
	}

}
