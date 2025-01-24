package HospitalProject.testCases;

import HospitalProject.testComponenets.BaseTest;
import com.hospital.test.pageObjects.frontend.ABCD_AppointmentPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class HospitalDoctorAvailCheck extends BaseTest {

@Test
public void UserDoctorCheck() throws IOException, InterruptedException {
    String userName;
    ABCD_AppointmentPage ABCD_AppointmentPage;
    String email = getDataProperty("email");
    String psw = getDataProperty("psw");
    String actualName = getDataProperty("fullName");
    String department = getDataProperty("dep");
    String doctorName = getDataProperty("doctorName");


    ABCD_LandingPage.logintoWeb(email,psw);
    userName = ABCD_LandingPage.getUserDetail();
    Assert.assertEquals(userName,actualName);

    ABCD_AppointmentPage = ABCD_LandingPage.goToAppointmentPage();
    ABCD_AppointmentPage.searchForDoctor(department,doctorName);

}

}
