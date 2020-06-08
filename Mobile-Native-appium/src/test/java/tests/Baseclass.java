package tests;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import utils.Reportsutil;
import utils.Screenshots;

public class Baseclass<Itestresult> extends Reportsutil {
	
	//AppiumDriver<MobileElement> driver;
	AndroidDriver<MobileElement> driver;
	static  ExtentTest test;
	@BeforeClass
	public void setup() throws InterruptedException, IOException {
		
			DesiredCapabilities cap= new DesiredCapabilities();
			cap.setCapability("deviceName", "Redmi");
			cap.setCapability("udid", "5cdaec1e");
			cap.setCapability("platformName", "Android");
			cap.setCapability("platformVersion", "9.0");
		/*
		 * cap.setCapability("appPackage", "com.google.android.apps.fitness");
		 * cap.setCapability("appActivity",
		 * "com.google.android.apps.fitness.welcome.WelcomeActivity");
		 */
			 cap.setCapability("appPackage", "com.usablenet.mobile.walgreen");
			 cap.setCapability("appActivity","com.usablenet.mobile.walgreen.AppStart");
			  
			
			URL url=new URL("http://127.0.0.1:4723/wd/hub");
		//	driver= new AppiumDriver<MobileElement>(url, cap);
			driver=new AndroidDriver<MobileElement>(url, cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("Application stated now...........");
			Thread.sleep(4000);
			
		}
	
	@AfterClass
	public void teardown() {
		driver.quit();
		
	}

}
