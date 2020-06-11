package com.qa;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import com.qa.listeners.TestListener;
import com.qa.utils.SrolldownScreen;
import com.qa.utils.TestUtils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	public static AppiumDriver<MobileElement> driver;
	public static Properties pros;
	InputStream inputstream;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static HashMap<String, String> stringss = new HashMap<String, String>();
	InputStream stringis;
	TestUtils utilss;
	public static ExtentTest test;
	
	public BaseTest() {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@Parameters({ "deviceName", "udid", "platformName", "platformVersion" })
	@BeforeMethod
	public void beforeTest(String deviceName, String udid, String platformName, String platformVersion)
			throws Exception {
		try {
			pros = new Properties();
			String propFilename = "config.properties";
			inputstream = getClass().getClassLoader().getResourceAsStream(propFilename);
			pros.load(inputstream);

			String filexml = "Strings/strings.xml";
			stringis = getClass().getClassLoader().getResourceAsStream(filexml);
			utilss = new TestUtils();
			stringss = utilss.parseStringXML(stringis);

			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("deviceName", deviceName);
			cap.setCapability("udid", udid);
			cap.setCapability("platformName", platformName);
			cap.setCapability("platformVersion", platformVersion);
			cap.setCapability("appPackage", pros.getProperty("appPackage"));
			cap.setCapability("appActivity", pros.getProperty("appActivity"));

			URL url = new URL(pros.getProperty("appiumurl"));
			// driver= new AppiumDriver<MobileElement>(url, cap);
			driver = new AndroidDriver<MobileElement>(url, cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("Application stated now...........");
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (inputstream != null) {
				inputstream.close();
			}
			if (stringis != null) {
				stringis.close();
			}
		}
	}

	public void waitforvisibility(MobileElement e) {

		WebDriverWait wait = new WebDriverWait(driver, TestUtils.wait);
		wait.until(ExpectedConditions.visibilityOf(e));
	}

	public void click(MobileElement e) {
		waitforvisibility(e);
		e.click();
	}

	public void sendkeys(MobileElement e, String text) {
		waitforvisibility(e);
		e.sendKeys(text);
	}

	public String getAttribute(MobileElement e, String attribute) {
		waitforvisibility(e);
		return e.getAttribute(attribute);

	}

	public MobileElement scrollToElmentss() {
		return (MobileElement) ((FindsByAndroidUIAutomator) driver).findElementByAndroidUIAutomator(

				"new UiScrollable(new UiSelector()" + ".scrollable(true).scrollIntoView("
						+ "new UiSelector().description(\"Contact Lenses\"));");
	}

//** Finding the element and scrolling "UP and DOWN" ***//

	public static void scrollToElement(MobileElement e, String direction) {
		for (int i = 0; i <= 3; i++) {
			if (isDisplayed(e)) {
				break;
			} else {
				if (direction.equalsIgnoreCase("up")) {

					SrolldownScreen.Screenupdown(driver, "up");

				} else {
					SrolldownScreen.Screenupdown(driver, "down");

				}
			}
		}

	}

	public static boolean isDisplayed(final MobileElement e) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			WebDriverWait wait = new WebDriverWait(driver, 2);
			return wait.until(new ExpectedCondition<Boolean>() {

				public Boolean apply(WebDriver driver) {

					if (e.isDisplayed()) {
						return true;
					} else {
						return false;
					}
				}

			});
		} catch (Exception ex) {
			return false;
		}
	}
//******* Scrolling element is End***********

	public void backpage() {
		driver.navigate().back();
	}

	

	
	@AfterMethod
	public void Failure(ITestResult iTestResult ) {
		
		driver.quit();    
   }
	    

		
	

	@BeforeSuite
	public void ExtentReportss() {
		htmlReporter = new ExtentHtmlReporter("./Reports/extent.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}

	@AfterSuite
	public void reportTeardown() {

		extent.flush();
	}
	
	
}
