package utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class Screenshots {
	//static AppiumDriver driver;
	public static String capturescreen(WebDriver driver, String screenshotName) {
	
		TakesScreenshot screens= ((TakesScreenshot) driver);
		File src= screens.getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir")+"/Screenshot/"+screenshotName+".png";
		File destination=new File(path);
		try {
			 FileUtils.copyFile(src, destination);
			System.out.println("Captured the screenshot");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return path;
		
		
		

}
}