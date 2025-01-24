package HospitalProject.StepDefinitions;

import HospitalProject.testClassesBDD.hospitalLandingPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class loginOP {


    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        hospitalLandingPage.goToLandingpage();
        log.info("The User is on the Login Page");

    }
    @When("the user enters {string} and {string}")
    public void the_user_enters_and(String email, String psw) {
        // Write code here that turns the phrase above into concrete actions
        hospitalLandingPage.enterCreds(email,psw);
        log.info("The User has entered the credentials");

    }
    @Then("the user {string} should be logged in")
    public void the_user_should_be_logged_in(String uName) {
        // Write code here that turns the phrase above into concrete actions
        hospitalLandingPage.verifyLogin(uName);

    }
}
