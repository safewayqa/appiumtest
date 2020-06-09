package Gittesting.testgit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class first {

	public 	WebDriver driver;
	
	@Parameters("browsers")
	@Test
	public void team(String browsers) {
		
		
		
	if(browsers.equalsIgnoreCase("chrome")) {
		
		
		
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\rehan\\git\\RehanRidhu\\testgit\\browsers\\chromedriver.exe");
		   driver=new ChromeDriver();
	} else if(browsers.equalsIgnoreCase("firefox")) {
		  
			System.setProperty("webdriver.gecko.driver","C:\\Users\\rehan\\git\\RehanRidhu\\testgit\\browsers\\geckodriver.exe");
			driver=new FirefoxDriver();
	}
		/*
		 * System.setProperty("webdriver.ie.driver",
		 * "C:\\Users\\rehan\\git\\RehanRidhu\\testgit\\browsers\\IEDriverServer.exe");
		 * WebDriver driver=new InternetExplorerDriver();
		 * 
		 * 
		 */
		
			driver.get("https://www.shopjustice.com/");
		System.out.println("Nargees");
		System.out.println("Rehan");
		System.out.println("Ridhu sanuu");
		System.out.println("Razaq");
	

	}
}
