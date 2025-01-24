package HospitalProject.testComponenets;

import com.e_commerce.test.utils.Config;
import com.hospital.test.pageObjects.frontend.ABCD_LandingPage;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Slf4j
public class BaseTest {
    protected static WebDriver driver;
    public static ABCD_LandingPage ABCD_LandingPage;

    //@BeforeMethod(alwaysRun = true)
    public static ABCD_LandingPage goToWebpage(WebDriver driver) throws IOException {

        BaseTest.driver = driver;
        ABCD_LandingPage = new ABCD_LandingPage(driver);
        return ABCD_LandingPage;

    }
    //@AfterMethod(alwaysRun = true)
    public static void driverClose() {
        log.info("After Hook triggered");
        log.info("Closing the Browser");
        log.info("*********************************Test End*****************************************");
        driver.close();
        driver.quit();
    }
    public static String getDataProperty(String key) throws IOException {
        String propFile = Config.getConfigProperty("propFileName");
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/HospitalProjectData/"+propFile+".properties");
        prop.load(fis);
        return prop.getProperty(key);
    }
    @BeforeSuite
    public void deleteLogFile() {
        String logFilePath = "logs/application.log";
        File logFile = new File(logFilePath);
        // Shutdown Log4j to release the file lock
        LogManager.shutdown();
        if (logFile.exists()) {
            if (logFile.delete()) {
                System.out.println("Old log file deleted successfully.");
            } else {
               System.err.println("Failed to delete old log file.");
            }
        } else {
            System.out.println("Log file does not exist, no need to delete.");
        }
        org.apache.log4j.PropertyConfigurator.configure("src/main/resources/log4j.properties");
    }
}
