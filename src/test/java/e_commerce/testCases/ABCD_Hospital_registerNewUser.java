package test.java.e_commerce.testCases;

import org.testng.annotations.Test;
import test.java.e_commerce.testComponenets.BaseTest;

public class ABCD_Hospital_registerNewUser extends BaseTest {
	
	@Test
	public void AbcdHospitalRegistration() throws InterruptedException{
		ABCD_LandingPage.regiterNewUser();
		
	}

}
