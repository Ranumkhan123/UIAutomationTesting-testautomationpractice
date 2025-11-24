package pages.form;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class FormSubmission {



    public WebDriver driver;
    public WebDriverWait wait;


    // Constructor
    public FormSubmission(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }


    // Locators
    By formHeading = By.cssSelector("#Blog1 > div.blog-posts.hfeed > div > div > div > div > h3 > a");
    By enterName = By.id("name");
    By enterEmail = By.id("email");
    By phoneNo = By.id("phone");
    By enterAddress = By.id("textarea");
    By genderRadioBtn = By.id("female");
    By dayCheckbox = By.cssSelector("label[for='days']");
    By selectDayCheckbox = By.id("monday");
    By selectCountryDropdown = By.id("country");
    By selectCountry = By.cssSelector("#country > option:nth-child(3)");
    By colorScrolls = By.id("colors");
    By selectColor = By.xpath("//*[@id=\"colors\"]/option[6]");
    By sortedeList = By.id("animals");
    By selectSortedListItem = By.xpath("//*[@id=\"animals\"]/option[7]");
    By clickDatePickerOne  = By.id("datepicker");
    By selectNextMonth = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/a[2]");
    By selectDate = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[3]/td[4]/a");
    By clickDatePickerTwo = By.id("txtDate");
    By selectMonth = By.className("ui-datepicker-month");
    By selectYear = By.className("ui-datepicker-year");
    By selectCalendarDate = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[3]/a");







    public void openBrowser(String url){

        driver.manage().window().maximize();
        driver.get(url);
        System.out.println("URL: " + driver.getCurrentUrl());
        System.out.println("Title: " + driver.getTitle());
        System.out.println();
    }


    public void formSubmit(String name, String email, String phone, String address) {

        //Scroll JS Executor
        JavascriptExecutor scrollJS = (JavascriptExecutor) driver;


        WebElement verifyFormHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(formHeading));


        //name
        WebElement enterNameText = wait.until(ExpectedConditions.visibilityOfElementLocated(enterName));
        enterNameText.sendKeys(name);
        System.out.println("Name Entered: " + name);

        //email
        WebElement enterEmailText = wait.until(ExpectedConditions.visibilityOfElementLocated(enterEmail));
        enterEmailText.sendKeys(email);
        System.out.println("Email Entered: " + email);

        //phoneno
        WebElement enterPhoneNo = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNo));
        enterPhoneNo.sendKeys(phone);
        System.out.println("Phone No Entered: " + phone);


        //address
        WebElement enterAddressText = wait.until(ExpectedConditions.visibilityOfElementLocated(enterAddress));
        enterAddressText.sendKeys(address);
        System.out.println("Address Entered: " + address);

        //gender
        WebElement selectGenderBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(genderRadioBtn));
        if (selectGenderBtn.isSelected()) {
            selectGenderBtn.click();
        }
        System.out.println("Gender Selected: " + selectGenderBtn.getAttribute("value"));


        //daycheckbox
        WebElement dayCheckboxesVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(dayCheckbox));

        WebElement selectDay = wait.until(ExpectedConditions.visibilityOfElementLocated(selectDayCheckbox));
        if (selectDay.isSelected()) {
            selectDay.click();
        }
        System.out.println("Days Selected: " + selectDay.getAttribute("value"));


        //countrydropdown
        WebElement countryDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(selectCountryDropdown));
        countryDropdown.click();
        WebElement selectCountryName = wait.until(ExpectedConditions.visibilityOfElementLocated(selectCountry));
        selectCountryName.click();
        System.out.println("Country Selected: " + selectCountryName.getAttribute("value"));


        //colorscrolls

        // Scroll the dropdown into view
        WebElement colorDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(colorScrolls));

        scrollJS.executeScript("arguments[0].scrollIntoView(true);", colorDropdown);

        // Now select the color option
        WebElement colorOption = wait.until(ExpectedConditions.visibilityOfElementLocated(selectColor));
        colorOption.click();
        System.out.println("Colors Selected: " + colorOption.getAttribute("value"));



        //sortedList

        // Scroll the dropdown into view
        WebElement sortedListVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(sortedeList));

        scrollJS.executeScript("arguments[0].scrollIntoView(true);", sortedListVisible);

        // Now select the color option
        WebElement selectSortedList = wait.until(ExpectedConditions.visibilityOfElementLocated(selectSortedListItem));
        selectSortedList.click();
        System.out.println("Sorted List Item Selected: " + selectSortedList.getAttribute("value"));

        //datepicker1
        WebElement selectDatePicker = wait.until(ExpectedConditions.visibilityOfElementLocated(clickDatePickerOne));
        selectDatePicker.click();
        WebElement nextMonth = wait.until(ExpectedConditions.visibilityOfElementLocated(selectNextMonth));
        nextMonth.click();
        WebElement dateSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(selectDate));
        dateSelect.click();
        System.out.println("Date One Selected: " + selectDatePicker.getAttribute("value"));


        //datepicker2
        WebElement selectDatePickerTwo = wait.until(ExpectedConditions.visibilityOfElementLocated(clickDatePickerTwo));
        selectDatePickerTwo.click();
        WebElement monthSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(selectMonth));
        monthSelect.sendKeys("Dec");
        WebElement calendarDateSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(selectCalendarDate));
        calendarDateSelect.click();

        //scroll back
        Actions actions = new Actions(driver);
        actions.moveToElement(sortedListVisible).perform();

        //SelectDatePickerTwo Value
        System.out.println("Date Two Selected: " + selectDatePickerTwo.getAttribute("value"));
























    }



}
