package com.qa.pages;

import com.qa.BaseTest;
import com.qa.utils.SrolldownScreen;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class AccountLoginPage extends BaseTest{

	@AndroidFindBy(xpath="//android.widget.ImageView[@content-desc='Walgreens logo']")
	public MobileElement Logo;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@content-desc=\"Prescriptions\"]")
	public MobileElement prescription;
	
	@AndroidFindBy(accessibility="Find Care")
	public MobileElement findstore;
	
	@AndroidFindBy(id="com.usablenet.mobile.walgreen:id/btnHomShoPro")
	public MobileElement shopproduct;

	@AndroidFindBy(xpath="//android.widget.LinearLayout[@content-desc=\"Photo\"]")
	public MobileElement photos;
	
	@AndroidFindBy(id="com.usablenet.mobile.walgreen:id/btnHomWeeAds")
	public MobileElement weekly;
	
	@AndroidFindBy(id="com.usablenet.mobile.walgreen:id/lblWidPosCta")
	public MobileElement Addpreference;
	
	@AndroidFindBy(id="com.usablenet.mobile.walgreen:id/btnPhaLanConLen")
	public MobileElement contact;
	
	public AccountLoginPage logocheck() {
		Logo.isDisplayed();
		return this;
	}
	
	public prescripdetailspage preciption() {
		
		click(prescription);
		return new prescripdetailspage();
	}

	public prescripdetailspage shopprod() {
		
	//	SrolldownScreen.Screenupdown(driver,"up");
		scrollToElement(shopproduct, "up");
		click(shopproduct);
		return new prescripdetailspage();
	}
	
	public prescripdetailspage photoss() {
	//	SrolldownScreen.Screenupdown(driver,"up");
		scrollToElement(photos, "up");
		click(photos);
		return new prescripdetailspage();
	}
	public prescripdetailspage findstoreclick() {
		click(findstore);
		return new prescripdetailspage();
	}
	public prescripdetailspage weeklys() {
		SrolldownScreen.Screenupdown(driver,"up");
		click(weekly);
		return new prescripdetailspage();
	}
	public prescripdetailspage contacts() {
		scrollToElmentss();
		click(contact);
		return new prescripdetailspage();
	}
	public AccountLoginPage Addpref() {
		click(Addpreference);
		return this;
	}
	public  AccountLoginPage weeklss() {
		scrollToElement(weekly, "up");
		click(weekly);
		return this;
	}
	
}
