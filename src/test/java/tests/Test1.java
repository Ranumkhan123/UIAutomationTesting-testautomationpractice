package tests;

import baseTests.BaseClass;
import org.testng.annotations.Test;

public class Test1 extends BaseClass {




    @Test(priority = 1)
    public void formSubmission() {

        formsubmit.openBrowser("https://testautomationpractice.blogspot.com/");
        formsubmit.formSubmit("Ranum Khan", "abc@gmail.com", "09876543212", "abc street-block 11, xyz");

    }









}
