package com.hospital.test.pageObjects.frontend;

import com.e_commerce.test.utils.GeneralPageActionUtils;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

@Slf4j
public class ABCD_AppointmentPage  extends GeneralPageActionUtils {
    WebDriver driver;

    public ABCD_AppointmentPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



}
