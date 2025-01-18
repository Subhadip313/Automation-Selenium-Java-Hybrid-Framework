package HospitalProject.testCases;

import HospitalProject.testComponenets.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class HospitalDoctorAvailCheck extends BaseTest {

@Test
public void UserDoctorCheck() throws IOException {
    String userName;
    ABCD_LandingPage.logintoWeb(getProperty("email"),getProperty("psw"));
    userName = ABCD_LandingPage.validateUserDetails();
    Assert.assertEquals(userName,getProperty("fullName"));


}

}
