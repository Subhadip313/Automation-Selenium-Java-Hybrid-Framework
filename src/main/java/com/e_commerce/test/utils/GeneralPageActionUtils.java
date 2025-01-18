package com.e_commerce.test.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralPageActionUtils {
	  static WebDriver driver;
	
	public GeneralPageActionUtils(WebDriver driver){
		super();
		GeneralPageActionUtils.driver=driver;
	}
	
	
	public static void waitForPageToLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(60))
        .until(ExpectedConditions.jsReturnsValue("return (document.readyState==\"complete\") && ((typeof jQuery != 'undefined') ? jQuery.active == 0 : true)"));
    }
	
	public static void waitFortheElementToBeClickable(String locator){
		new WebDriverWait(driver,Duration.ofSeconds(30))
		.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(locator))));
	}
	public static void waitFortheElementToBeClickable(WebElement locator){
		new WebDriverWait(driver,Duration.ofSeconds(30))
		.until(ExpectedConditions.elementToBeClickable(locator));
	}
	public static void waitForTheElement(String element){
		new WebDriverWait(driver,Duration.ofSeconds(30))
		.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(element))));
	}
	public static void waitForTheElementWebElement(WebElement element){
		new WebDriverWait(driver,Duration.ofSeconds(30))
		.until(ExpectedConditions.visibilityOf(element));
	}
	public static void scrolldowntoElement(WebElement element) {
		JavascriptExecutor  js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	public static void refreshThePage(){
		driver.navigate().refresh();
	}
	public void clearAndKeyIn(WebElement element, String key){
		waitForTheElementWebElement(element);
		element.clear();
		element.sendKeys(key);
	}
	public void elementClick(WebElement element){
		waitFortheElementToBeClickable(element);
		element.click();
	}
	public void selectOptionFromDropdown(WebElement element, String optionText){
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(optionText);
	}
	

}
