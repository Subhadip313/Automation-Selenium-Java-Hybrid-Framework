package HospitalProject.testCases;


import HospitalProject.testComponenets.BaseTest;
import org.testng.annotations.Test;

public class HospitalRegisterNewUser extends BaseTest {
	
	@Test
	public void AbcdHospitalRegistration() throws InterruptedException{
		ABCD_LandingPage.regiterNewUser();
		
	}

}
