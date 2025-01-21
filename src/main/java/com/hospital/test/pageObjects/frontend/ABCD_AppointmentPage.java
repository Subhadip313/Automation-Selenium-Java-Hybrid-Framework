package com.hospital.test.pageObjects.frontend;

import com.e_commerce.test.utils.BaseClass;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class ABCD_AppointmentPage  extends BaseClass {
    WebDriver driver;

    public ABCD_AppointmentPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "select[name='Department']") WebElement selectDepartment;
    @FindBy(xpath = "(//*[contains(text(),'Search for a doctor')])//parent::div") WebElement searchForDoctorBTN;

    public void searchForDoctor(String dep, String doctorName) throws InterruptedException {
        waitForPageToLoad();
        elementClick(searchForDoctorBTN);
        waitFortheElementToBeClickable(selectDepartment);
        selectOptionFromDropdown(selectDepartment,dep);
        Thread.sleep(5000);
    }




}
