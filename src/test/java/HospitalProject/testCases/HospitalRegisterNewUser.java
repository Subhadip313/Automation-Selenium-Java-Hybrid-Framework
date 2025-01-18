package HospitalProject.testCases;


import HospitalProject.testComponenets.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class HospitalRegisterNewUser extends BaseTest {

	
	@Test
	public static void AbcdHospitalRegistration() throws InterruptedException, IOException {
		String userName;
		ABCD_LandingPage.regiterNewUser(getProperty("fullName"),getProperty("email"),getProperty("psw"),getProperty("repPsw"));
		if(ABCD_LandingPage.checkIfHomeBTNthere()){
			ABCD_LandingPage.goToHomePage();
		}
		userName= ABCD_LandingPage.validateUserDetails();
		Assert.assertEquals(userName,getProperty("fullName"));
	}

}
