package e_commerce.testCases;

import e_commerce.testComponenets.BaseTest;
import org.testng.annotations.Test;

public class ABCD_Hospital_registerNewUser extends BaseTest {
	
	@Test
	public void AbcdHospitalRegistration() throws InterruptedException{
		ABCD_LandingPage.regiterNewUser();
		
	}

}
