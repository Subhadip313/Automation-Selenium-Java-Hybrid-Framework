package e_commerce.testCases;

import java.time.Duration;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

@Slf4j
public class ABCD_Hospital_Base{
//http://localhost/ABCD%20Hospital/
	public WebDriver driver;
	
	@Test
	public void login() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://localhost/ABCD%20Hospital/");
		driver.manage().window().maximize();
		
		//make a implicit wait command
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		
		driver.findElement(By.id("session_login")).click();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//form[@id='login_myForm']/div"))));
		driver.findElement(By.id("login_email")).click();
		driver.findElement(By.id("login_email")).sendKeys("subhadipdutta180@gmail.com");
		driver.findElement(By.id("login_psw")).click();
		driver.findElement(By.id("login_psw")).sendKeys("12345678");
		driver.findElement(By.xpath("//input[@value='Sign In']")).click();
		driver.navigate().refresh();
		driver.findElement(By.xpath("//a[@id='user_profile']")).click();
		Assert.assertEquals(driver.findElement(By.xpath("(//div[@class='profile_data']//following::span)[1]")).getText(), "Subhadip Dutta");
		Thread.sleep(5000);
		log.info("Performing an action.");
		log.debug("Debugging action details.");
		log.error("An error occurred.");
		driver.close();
		
	}
	
	public void regiterNewUser() {
		
	}
}
