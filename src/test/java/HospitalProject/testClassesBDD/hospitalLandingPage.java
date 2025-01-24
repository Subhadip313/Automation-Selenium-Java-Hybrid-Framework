package HospitalProject.testClassesBDD;

import HospitalProject.testComponenets.BaseTest;
import com.hospital.test.pageObjects.frontend.ABCD_LandingPage;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;

import java.io.IOException;

@Slf4j
public class hospitalLandingPage extends BaseTest {
    public static ABCD_LandingPage ABCD_LandingPage;
    public static void goToLandingpage() throws IOException {
        ABCD_LandingPage =  goToWebpage();

    }
    public static void enterCreds(String email, String psw) {
        ABCD_LandingPage.logintoWeb(email,psw);

    }

    public static void verifyLogin(String uName) {
       if(ABCD_LandingPage.checkIfUserLoggedIn(uName)){
           Assert.assertTrue(true);
              log.info("User Logged in Successfully");
       }else {
              log.error("User not Logged in Successfully");
           Assert.fail("The username does not match");
       }
    }
}
