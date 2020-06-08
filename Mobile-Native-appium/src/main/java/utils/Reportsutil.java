package utils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Reportsutil {
	
	public ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
public static 	ExtentTest logger;

//	AppiumDriver<MobileElement> driver;
	//WebDriver driver;
	static WebDriver driver;

	@BeforeTest
	public void setup() throws InterruptedException, IOException {
			ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Reports/WalGreens_Reports.html");
		
			extent = new ExtentReports();
	    
			extent.attachReporter(reporter);
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
	  
	}

	
@Test(priority=1)
public void second() throws Exception {
	
	  logger=extent.createTest("Second test");
	System.out.println("");
	driver.get("https://google.com");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div[1]/div[1]/div/div[2]/input")).sendKeys("Rafi");
//	Screenshots.capturescreen(driver, "Google");
	Thread.sleep(1000);
	Assert.assertEquals(20, 30);
	
}
@Test (priority=2)
public static void Thrid() {
	logger=extent.createTest("Third test");
	Assert.assertEquals(20, 20);
	System.out.println("Firs is passed");
}
	
	  @AfterMethod 
	  public void resultss(ITestResult result) throws IOException {
	  
	  if(ITestResult.FAILURE==result.getStatus()) { 
		  
		String temp=  Screenshots.capturescreen(driver, result.getMethod().getMethodName());
		logger.fail(result.getThrowable().getMessage(),
				  MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
	  }
	  extent.flush();
	  driver.close();
	  
	  
	  System.out.println("WElcome");
	  
	  }
	  
	 
}


