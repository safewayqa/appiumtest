package com.qa.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SrolldownScreen {
	static WebDriver driver;

	
	public static void scrollToElement(By e, String direction) {
		for(int i=0; i<=3; i++) {
			if(isDisplayed(e)) {
				break;
			}else {
				if(direction.equalsIgnoreCase("up")) {
					
					Screenupdown(driver, "up");
				}else {
					Screenupdown(driver, "down");
				}
			}
			
		}
		
	}

	public static boolean isDisplayed(final By e) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			WebDriverWait wait = new WebDriverWait(driver, 2);
			return wait.until(new ExpectedCondition<Boolean>() {

				public Boolean apply(WebDriver driver) {
					if (driver.findElement(e).isDisplayed()) {
						return true;
					}
					return false;
				}
			});
		} catch (Exception ex) {
			return false;
		}

	}
	
	public static void Screenupdown(WebDriver driver,String direction) {

		Dimension dim = driver.manage().window().getSize();
		int x = dim.getWidth() / 2;
		int starty = 0;
		int endy = 0;

		switch (direction) {

		case "up":
			starty = (int) (dim.getHeight() * 0.8);
			endy = (int) (dim.getHeight() * 0.2);
			break;

		case "down":
			starty = (int) (dim.getHeight() * 0.2);
			endy = (int) (dim.getHeight() * 0.8);

			break;
		}
		new TouchAction((PerformsTouchActions) driver).press(PointOption.point(x, starty))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000))).moveTo(PointOption.point(x, endy))
				.release().perform();

	}

}

/*
 * outerloop: for (int i = 0; i <= 10; i++) { Thread.sleep(2000); if (!(i == 0))
 * new TouchAction((PerformsTouchActions) driver).press(PointOption.point(Width,
 * Startpoint)) .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
 * .moveTo(PointOption.point(Width, Endpoint)).release().perform();
 * 
 * List<MobileElement> Statedrop = driver.findElements(By.id("Element"));
 * 
 * for (MobileElement select_state : Statedrop) {
 * 
 * System.out.println(select_state.getAttribute("text")); if
 * (select_state.getAttribute("text").equals(texname)) { // texname=
 * select_state.getAttribute("text"); select_state.click(); break outerloop;
 * 
 * } } }
 */