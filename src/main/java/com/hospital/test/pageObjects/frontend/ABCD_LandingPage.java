package com.hospital.test.pageObjects.frontend;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.e_commerce.test.utils.BaseClass;

@Slf4j
public class ABCD_LandingPage extends BaseClass {
    WebDriver driver;
    public static ABCD_AppointmentPage ABCD_AppointmentPage;

    public ABCD_LandingPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a.para_1_register_button") WebElement registerButton;
    @FindBy(css = "form[name='myForm'] div.container h1") WebElement registerText;
    @FindBy(xpath = "(//form[@name='myForm']/div/input)[1]") WebElement fullNameField;
    @FindBy(xpath = "(//form[@name='myForm']/div/input)[2]") WebElement emailField;
    @FindBy(xpath = "(//form[@name='myForm']/div/input)[3]") WebElement passwordField;
    @FindBy(xpath = "(//form[@name='myForm']/div/input)[4]") WebElement repPswField;
    @FindBy(xpath = "//input[@value='Sign Up']") WebElement signUpBTN;
    @FindBy(css = "div.Welcome_text") WebElement welcomeText;
    @FindBy(css = "a.welcome-home-header-button") WebElement homeBTN;
    @FindBy(xpath = "//a[@id='user_profile']") WebElement userProfile;
    @FindBy(xpath = "(//div[@class='profile_data']//following::span)[1]") WebElement userName;
    @FindBy(css = "a#session_login") WebElement loginBTN;
    @FindBy(xpath = "//form[@id='login_myForm']/div") WebElement loginModal;
    @FindBy(css = "input#login_email") WebElement loginEmail;
    @FindBy(css = "input#login_psw") WebElement loginPSW;
    @FindBy(xpath = "//input[@value='Sign In']") WebElement signInBTN;
    @FindBy(xpath = "(//*[contains(text(),'Appointment')])[1]") WebElement appointmentBTN;

    public void logintoWeb(String email, String psw){
        waitForPageToLoad();
        elementClick(loginBTN);
        waitForTheElementWebElement(loginModal);
        clearAndKeyIn(loginEmail,email);
        clearAndKeyIn(loginPSW,psw);
        elementClick(signInBTN);
        refreshThePage();

    }
    public void regiterNewUser(String fname, String email, String psw, String repPsw) throws InterruptedException {
        waitForPageToLoad();
        scrolldowntoElement(registerButton);
        waitFortheElementToBeClickable(registerButton);
        registerButton.click();
        waitForTheElementWebElement(registerText);
        log.info("The Model has opened");
        log.info(registerText.getText());
        waitFortheElementToBeClickable(fullNameField);
        fullNameField.clear();
        fullNameField.sendKeys(fname);
        waitFortheElementToBeClickable(emailField);
        emailField.clear();
        emailField.sendKeys(email);
        waitFortheElementToBeClickable(passwordField);
        passwordField.clear();
        passwordField.sendKeys(psw);
        waitFortheElementToBeClickable(repPswField);
        repPswField.clear();
        repPswField.sendKeys(repPsw);
        waitFortheElementToBeClickable(signUpBTN);
        signUpBTN.click();
        waitForPageToLoad();
        waitForTheElementWebElement(welcomeText);
        log.info("Sign in Confirmed!!! {}", welcomeText.getText());
    }
    public String getUserDetail(){
        refreshThePage();
        waitFortheElementToBeClickable(userProfile);
        userProfile.click();
        waitForTheElementWebElement(userName);
        return userName.getText();

    }
    public boolean checkIfUserLoggedIn(String uName){
        String userName = getUserDetail();
        if(userName.equalsIgnoreCase(uName)){
            return true;

        }else {
            return false;
        }
    }
    public void goToHomePage(){
        waitForPageToLoad();
        waitFortheElementToBeClickable(homeBTN);
        homeBTN.click();
    }
    public boolean checkIfHomeBTNthere(){
        waitForPageToLoad();
        return homeBTN.isDisplayed();
    }
    public ABCD_AppointmentPage goToAppointmentPage(){
        waitForPageToLoad();
        refreshThePage();
        elementClick(appointmentBTN);
        ABCD_AppointmentPage = new ABCD_AppointmentPage(driver);
        return ABCD_AppointmentPage;
    }
}
