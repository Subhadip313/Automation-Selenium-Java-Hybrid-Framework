package com.hospital.test.pageObjects.frontend;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.e_commerce.test.utils.GeneralPageActionUtils;

public class ABCD_LandingPage extends GeneralPageActionUtils {
	
WebDriver driver;

public ABCD_LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

@FindBy(css="a.para_1_register_button") WebElement registerButton;

public void regiterNewUser() throws InterruptedException {
	waitForPageToLoad();
	scrolldowntoElement(registerButton);
	Thread.sleep(4000);
	}
}
