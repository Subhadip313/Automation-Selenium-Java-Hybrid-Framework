package HospitalProject.StepDefinitions;

import HospitalProject.testComponenets.BaseTest;
import com.hospital.test.pageObjects.frontend.ABCD_LandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class loginOP {
    public static ABCD_LandingPage ABCD_LandingPage;

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        ABCD_LandingPage = BaseTest.goToWebpage();
        log.info("The User is on the Login Page");

    }
    @When("the user enters {string} and {string}")
    public void the_user_enters_and(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        ABCD_LandingPage.logintoWeb(string,string2);
        log.info("The User has entered the credentials");

    }
    @Then("the user {string} should be logged in")
    public void the_user_should_be_logged_in(String uName) {
        // Write code here that turns the phrase above into concrete actions
        String username = ABCD_LandingPage.getUserDetail();
        if (username.equals(uName)){
            log.info("The User is logged in successfully");
        }else{
            log.error("The User is not logged in successfully");
        }
    }
}
