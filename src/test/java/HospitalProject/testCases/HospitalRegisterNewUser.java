package HospitalProject.testCases;


import HospitalProject.testComponenets.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class HospitalRegisterNewUser extends BaseTest {

	
	@Test
	public static void AbcdHospitalRegistration() throws InterruptedException, IOException {
		String userName;
		ABCD_LandingPage.regiterNewUser(getDataProperty("fullName"),getDataProperty("email"),getDataProperty("psw"),getDataProperty("repPsw"));
		if(ABCD_LandingPage.checkIfHomeBTNthere()){
			ABCD_LandingPage.goToHomePage();
		}
		userName= ABCD_LandingPage.getUserDetail();
		Assert.assertEquals(userName,getDataProperty("fullName"));
	}

}
