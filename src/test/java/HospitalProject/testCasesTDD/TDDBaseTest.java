package HospitalProject.testCasesTDD;

import com.hospital.test.pageObjects.frontend.ABCD_LandingPage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static com.e_commerce.test.utils.Config.*;

@Slf4j
public class TDDBaseTest {
    public static WebDriver driver;
    public static ABCD_LandingPage ABCD_LandingPage;

    @BeforeMethod(alwaysRun = true)
    public static void goToWebpageTDD() throws IOException {
        log.info("BeforeMethod Hook triggered");
        driver = initializeDriver();
        driver.get(getConfigProperty("URL"));
        ABCD_LandingPage = new ABCD_LandingPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        log.info("AfterMethod Hook triggered");
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
    public static String getDataProperty(String key) throws IOException {
        String propFile = getConfigProperty("propFileName");
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/HospitalProjectData/"+propFile+".properties");
        prop.load(fis);
        return prop.getProperty(key);
    }
}
