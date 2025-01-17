package test.java.e_commerce.testCases;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class SampleTestClass {
	
	 //ExtentSparkReporter report;
	 ExtentReports test;
	
	 @BeforeTest 
	public void extentReport(){
		String Path= System.getProperty("user.dir")+"\\src\\test\\java\\e_commerce\\testReports\\index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(Path);
		report.config().setDocumentTitle("E-Commerce Automation");
		report.config().setReportName("Test Results");
		test = new ExtentReports();
		test.attachReporter(report);
		test.setSystemInfo("tester", "Subhadip Dutta");
	}
	
	
	@Test
	public void method() throws InterruptedException{
		test.createTest("method");
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://sitbquk-afa.aws.ghanp.kfplc.com/agent-front/");
		driver.manage().window().maximize();
		
		//make a implicit wait command
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		SoftAssert assertA = new SoftAssert();
		
		
		
		driver.findElement(By.xpath("//input[@name='user']")).click();
		driver.findElement(By.xpath("//input[@name='user']")).sendKeys("service");
		
		driver.findElement(By.xpath("//input[@name='pwd']")).click();
		driver.findElement(By.xpath("//input[@name='pwd']")).sendKeys("Service123");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.cssSelector("h2.field")).getText());
		
		driver.findElement(By.xpath("//input[@name='location']")).click();
		driver.findElement(By.xpath("//input[@name='location']")).sendKeys("1162");
		driver.findElement(By.xpath("//*[@id='confirmLocation']")).click();
		
		//if(driver.findElement(By.xpath("(//input[@type='submit'])[2]")).isEnabled()){
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//input[@type='submit'])[2]"))));
		driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
		//}
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.xpath("//div[@class='message warning-message hidden']//following::h1")).getText());
		
		driver.findElement(By.cssSelector("input[name='customernumber']")).click();
		driver.findElement(By.cssSelector("input[name='customernumber']")).sendKeys("2000002154");
		driver.findElement(By.cssSelector("input[data-title='Customer']")).click();
		String customerName = driver.findElement(By.xpath("(//div[@class='accord-content']//following::dd)[1] ")).getText();
		String customerNumber = driver.findElement(By.xpath("(//div[@class='accord-content']//following::dd)[2] ")).getText();
		assertA.assertEquals(customerName, "Mr Subhadip Kumar Dutta");
		assertA.assertEquals(customerNumber, "2000002154");
		
		
		driver.findElement(By.cssSelector("ul.nav-primary a[data-title='Products']")).click();
		driver.findElement(By.xpath("//label[@for='ean1']//following::input[1]")).click();
		driver.findElement(By.xpath("//label[@for='ean1']//following::input[1]")).sendKeys("3663602638797");
		driver.findElement(By.xpath("//label[@for='ean1']//following::input[2]")).click();
		driver.findElement(By.xpath("//label[@for='ean1']//following::input[2]")).sendKeys("1");
		
		driver.findElement(By.cssSelector("div.product-quick-buy-form")).click();
		driver.findElement(By.xpath("//input[@type='submit' and @value='Add to basket']")).click();
		
		assertA.assertEquals(driver.findElement(By.cssSelector("h2.modal-header-underline")).getText(), "Product added to basket ");
		driver.findElement(By.cssSelector("div.field.buttons input")).click();
		
		
		assertA.assertEquals(driver.findElement(By.xpath("//dt[contains(text(),'EAN')]//following::dd[1]")).getText(), "3663602638797");
		driver.findElement(By.cssSelector("td.td-spin input")).click();
		assertA.assertEquals(driver.findElement(By.cssSelector("td.td-spin input")).getAttribute("value"), "1");
		assertA.assertEquals(driver.findElement(By.cssSelector("div.table:nth-child(3) td:nth-child(7)")).getText(), "HD");
		driver.findElement(By.cssSelector("input[value='Proceed to checkout']")).click();
		
		//WebElement paymentpage = driver.findElement(By.xpath("//h3[contains(text(),'Customer payment details')]"));
		wait.ignoring(NoSuchElementException.class) .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[contains(text(),'Customer payment details')]")));
				//(driver.findElement(By.xpath("//h3[contains(text(),'Customer payment details')]"))));
		
		String date;
		date = driver.findElement(By.xpath("//label[contains(text(),'Delivery date - ')]//following::input[1]")).getAttribute("value");
		System.out.println(date);
		
		driver.findElement(By.cssSelector("div.action-bar:nth-child(2) a:nth-child(1)")).click();
		assertA.assertEquals(driver.findElement(By.cssSelector("div.modal-container h2")).getText(), "Gift card payments");
		
		driver.findElement(By.cssSelector("input[name='gift-modal-cardnum']")).click();
		driver.findElement(By.cssSelector("input[name='gift-modal-cardnum']")).sendKeys("5045075668999903853");
		driver.findElement(By.cssSelector("input[name='gift-modal-pin']")).click();
		driver.findElement(By.cssSelector("input[name='gift-modal-pin']")).sendKeys("1951");
		
		driver.findElement(By.cssSelector("input[value='Check balance']")).click();
		/*System.out.println(driver.findElement(By.cssSelector("input[value='Apply gift cards to balance and continue']")).isEnabled());*/
		
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("input[value='Apply gift cards to balance and continue']"))));
			driver.findElement(By.xpath("(//div[@class='field buttons'])[2]//following::input[2]")).click();
			
			//new WebDriverWait(driver, Duration.ofSeconds(10))
			wait.ignoring(StaleElementReferenceException.class)
			.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@data-action='payAndPlaceOrder'])[1]")));
			driver.findElement(By.xpath("(//input[@data-action='payAndPlaceOrder'])[1]")).click();

		        
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("div.modal-container"))));
		
		LinkedHashMap<String,String> newmap = new LinkedHashMap<String,String>();
		
		List <WebElement> orderDetails = driver.findElements(By.cssSelector("div.modal-container div.field dt"));
		int index=1;
		
		for(WebElement options: orderDetails){
			
				newmap.put(options.getText(), driver.findElement(By.xpath("(//div[@class='field']//following::dd)["+index+"]")).getText());
				
			index++;
		}
		
		System.out.println(newmap);
		String orderNumber = driver.findElement(By.cssSelector("div.modal-content.confirmation dd:nth-child(2)")).getText();
		System.out.println("The order number is: " + orderNumber);
		driver.findElement(By.xpath("//input[@value='Finish with customer']")).click();
		
		
		new WebDriverWait(driver, Duration.ofSeconds(10))
		.ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='orderNumber']")));
		
		driver.findElement(By.xpath("//input[@name='orderNumber']")).click();
		driver.findElement(By.xpath("//input[@name='orderNumber']")).sendKeys(orderNumber);
		driver.findElement(By.xpath("//input[@name='orderNumber']")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//a[contains(text(),'Payment details')]")).click();
		WebElement paymentXpath = driver.findElement(By.xpath("(//table[@class='payment-table payment-table-desc']//following::td)[6]"));
		wait.until(ExpectedConditions.visibilityOf(paymentXpath));
		
		String paymentStatus=paymentXpath.getText();
		System.out.println("Payment Status= " + paymentStatus);
		assertA.assertAll();
		driver.close();
		test.flush();
	}

}
