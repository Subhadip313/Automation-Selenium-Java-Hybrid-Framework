package test.java.e_commerce.testComponenets;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hospital.test.pageObjects.frontend.ABCD_LandingPage;

public class BaseTest {
public static WebDriver driver;
public ABCD_LandingPage ABCD_LandingPage;

	public WebDriver initializeDriver() throws IOException{
		
		Properties propertiesController = new Properties();
		//System.getProperty("user.dir")+
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\environment\\properties\\globalData.properties");
		propertiesController.load(file);
		String browserName = propertiesController.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")){
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("edge")){
			System.setProperty("webdriver.edge.driver", "C:\\");
			driver = new EdgeDriver();
		}
		else if (browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "C:\\");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	@BeforeMethod(alwaysRun=true)
	public ABCD_LandingPage ABCDloginPageURL() throws IOException {
		driver = initializeDriver();
		driver.get("http://localhost/ABCD%20Hospital/");
		ABCD_LandingPage = new ABCD_LandingPage(driver);
		return ABCD_LandingPage;
	}
	
	
	@AfterMethod(alwaysRun=true)
	public static void driverClose(){
		driver.close();
	}
	
	public List<HashMap<String, String>> getJsonData(String Location) throws IOException{
		String JsonContent = FileUtils.readFileToString(new File (Location),"UTF-8");
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(JsonContent, new TypeReference <List<HashMap<String, String>>>(){});
		return data;
	}
	public String takeScreenshot(String TestCaseName, WebDriver driver) throws IOException{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File location = new File(System.getProperty("user.dir")+"\\src\\test\\java\\e_commerce\\testScreenshots\\failedTests\\"+TestCaseName+".png");
		//src\test\java\e_commerce\testScreenshots\failedTests
		FileUtils.copyFile(src, location);
		return (System.getProperty("user.dir")+"\\src\\test\\java\\e_commerce\\testScreenshots\\failedTests\\"+TestCaseName+".png");
	}
	
	
}
