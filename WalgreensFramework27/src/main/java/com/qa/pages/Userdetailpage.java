package com.qa.pages;
import java.util.List;

import org.openqa.selenium.Keys;


import com.qa.BaseTest;
import com.qa.utils.SrolldownScreen;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;




public class Userdetailpage extends BaseTest {
	
	
	@AndroidFindBy(id="com.usablenet.mobile.walgreen:id/input_field")
	public MobileElement fnametxt;
	
	
	
	@AndroidFindBy(id="com.usablenet.mobile.walgreen:id/loyalty_lastname")
	public MobileElement lnametxt;
	
	@AndroidFindBy(id="com.usablenet.mobile.walgreen:id/lblPharRegPhNo")
	public MobileElement Phone;
	
	@AndroidFindBy(id="com.usablenet.mobile.walgreen:id/lblPharRegEmail")
	public MobileElement Email;	
	
	@AndroidFindBy(id="com.usablenet.mobile.walgreen:id/lblPharRegDob")
	public MobileElement date;	
	
	@AndroidFindBy(xpath="//android.widget.EditText[@index='1']")
	public MobileElement day;
	
	@AndroidFindBy(xpath="//android.widget.EditText[@index='1']")
	public MobileElement month;
	
	@AndroidFindBy(id="android:id/button1")
	public MobileElement clickok;
	
	@AndroidFindBy(xpath="//*[@resource-id='com.usablenet.mobile.walgreen:id/err_field']")
	public MobileElement ferror;
	
	@AndroidFindBy(xpath="//*[@resource-id='com.usablenet.mobile.walgreen:id/err_field']")
	public List<MobileElement> Lerror;
	
	@AndroidFindBy(xpath="//*[@resource-id='com.usablenet.mobile.walgreen:id/err_field']")
	public List<MobileElement> DOB;
	

	@AndroidFindBy(xpath="//*[@resource-id='com.usablenet.mobile.walgreen:id/err_field']")
	public List<MobileElement> phone;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='DONE']")
	public MobileElement Done;
		
	
public Userdetailpage fname(String fname) {
	
	sendkeys(fnametxt,fname);
	
	return this;
}
public Userdetailpage lname(String lname) {
	sendkeys(lnametxt,lname);
	return this;
}

public Userdetailpage lphone(String phone) {
	sendkeys(Phone,phone);
	return this;
}

public Userdetailpage email(String email) {
	sendkeys(Email,email);
	return this;
}

public Userdetailpage date() {
	click(date);
	return this;
}

public Userdetailpage months(String monthh) {
	click(month);
	month.sendKeys(Keys.DELETE);
	sendkeys(month,monthh);
	return this;
}
public Userdetailpage days_years(String dayss) {
//	click(day);
//	day.sendKeys(Keys.DELETE);
	sendkeys(day,dayss);
	return this;
}

public Userdetailpage confirmok() {

	click(clickok);
	return this;
}

public Userdetailpage scroldoneclick() {
	scrollToElement(Done,"up");
	click(Done);
	SrolldownScreen.Screenupdown(driver, "down");
		return this;
}
public String fnamerror() {
	return getAttribute(ferror, "text");
	
}
public String Lnamerror() {
return getAttribute(Lerror.get(1), "text");
	
}
public String dob() {
return getAttribute(DOB.get(2), "text");
}
public String phonenum() {
return getAttribute(phone.get(3), "text");
}

}
