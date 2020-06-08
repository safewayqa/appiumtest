package Gittesting.testgit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class first {

	
	@Test
	public void team() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rehan\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.shopjustice.com/");
		System.out.println("Nargees");
		System.out.println("Rehan");
		System.out.println("Ridhu sanuu");
		System.out.println("Razaq");
	

	}
}
