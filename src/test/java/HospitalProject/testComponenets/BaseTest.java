package HospitalProject.testComponenets;

import com.e_commerce.test.utils.BaseClass;
import com.hospital.test.pageObjects.frontend.ABCD_LandingPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Slf4j
public class BaseTest {
    protected static WebDriver driver;
    public static ABCD_LandingPage ABCD_LandingPage;

    @BeforeMethod(alwaysRun = true)
    public ABCD_LandingPage goToWebpage() throws IOException {
        log.info("Opening the Website!!!!");
        log.info("Webiste URL: "+ BaseClass.getConfigProperty("URL"));
        driver = BaseClass.openURL();
        ABCD_LandingPage = new ABCD_LandingPage(driver);
        return ABCD_LandingPage;

    }
    @AfterMethod(alwaysRun = true)
    public static void driverClose() {
        log.info("Closing the Browser");
        driver.close();
    }
    public static String getProperty(String key) throws IOException {
        String propFile = BaseClass.getConfigProperty("propFileName");
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/HospitalProjectData/"+propFile+".properties");
        prop.load(fis);
        return prop.getProperty(key);
    }
}
