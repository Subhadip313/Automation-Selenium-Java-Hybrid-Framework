package hooks;

import HospitalProject.testComponenets.BaseTest;
import com.e_commerce.test.utils.Config;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

import static com.e_commerce.test.utils.Config.openURL;


@Slf4j
public class hooks {

    public static WebDriver driver;

    @Before
    public void startDriver() throws IOException {
        // Code to setup web driver
        log.info("Before Hook triggered");
        log.info("====================================================================================");
        log.info("*********************************Test Start*****************************************");
        log.info("Opening the Website!!!!");
        log.info("Webiste URL: "+ Config.getConfigProperty("URL"));
        try {
            driver = openURL();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @After
    public void tearDown() {
        // Code to close web driver
        log.info("*********************************Test End*****************************************");
        log.info("Closing the WebDriver");
        driver.quit();
    }

}
