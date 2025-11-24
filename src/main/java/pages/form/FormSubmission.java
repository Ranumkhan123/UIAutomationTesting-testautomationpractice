package pages.form;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
    By colorsScrolls = By.id("colors");
    By selectColor = By.cssSelector("#colors > option:nth-child(7)");






    public void openBrowser(String url){

        driver.manage().window().maximize();
        driver.get(url);
        System.out.println("URL: " + driver.getCurrentUrl());
        System.out.println("Title: " + driver.getTitle());
        System.out.println();
    }


    public void formSubmit(String name, String email, String phone, String address){

        WebElement verifyFormHeading = wait.until(ExpectedConditions.visibilityOfElementLocated(formHeading));


        //name
        WebElement enterNameText = wait.until(ExpectedConditions.visibilityOfElementLocated(enterName));
        enterNameText.sendKeys(name);

        //email
        WebElement enterEmailText = wait.until(ExpectedConditions.visibilityOfElementLocated(enterEmail));
        enterEmailText.sendKeys(email);

        //phoneno
        WebElement enterPhoneNo = wait.until(ExpectedConditions.visibilityOfElementLocated(phoneNo));
        enterPhoneNo.sendKeys(phone);

        //address
        WebElement enterAddressText = wait.until(ExpectedConditions.visibilityOfElementLocated(enterAddress));
        enterAddressText.sendKeys(address);

        //gender
        WebElement selectGenderBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(genderRadioBtn));
        if (selectGenderBtn.isSelected()) {
            selectGenderBtn.click();
        }

        //daycheckbox
        WebElement dayCheckboxesVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(dayCheckbox));

        WebElement selectDay = wait.until(ExpectedConditions.visibilityOfElementLocated(selectDayCheckbox));
        if (selectDay.isSelected()) {
            selectDay.click();
        }

        //countrydropdown
        WebElement countryDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(selectCountryDropdown));
        countryDropdown.click();
        WebElement selectCountryName = wait.until(ExpectedConditions.visibilityOfElementLocated(selectCountry));
        selectCountryName.click();

        //colorscrolls
        WebElement colorsDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(colorsScrolls));
        colorsDropdown.click();
        WebElement selectColorName = wait.until(ExpectedConditions.visibilityOfElementLocated(selectColor));
        selectColorName.click();








    }


}
