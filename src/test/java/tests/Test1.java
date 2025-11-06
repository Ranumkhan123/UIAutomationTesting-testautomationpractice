package tests;

import baseTests.BaseClass;
import org.testng.annotations.Test;

public class Test1 extends BaseClass {




    @Test(priority = 1)
    public void formSubmission() {

        formsubmit.openBrowser("https://testautomationpractice.blogspot.com/");

    }









}
