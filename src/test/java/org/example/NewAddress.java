package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class NewAddress {

    private WebDriver driver;
    private WebElement markerNewAddressPage;
    private WebElement firstNameField;
    private WebElement lastNameField;
    private WebElement address1Field;
    private WebElement address2Field;
    private WebElement cityField;
    private WebElement stateSelect;
    private WebElement zipCodeField;
    private WebElement countryUSRadioBtn;
    private WebElement countryCanadaRadioBtn;
    private WebElement birthdayCalendar;
    private WebElement ageField;
    private WebElement websiteField;
    private WebElement phoneField;
    private WebElement interestsClimbCheckBox;
    private WebElement interestsReadCheckBox;
    private WebElement interestsDanceCheckBox;
    private WebElement noteFiled;
    private WebElement createAddressBtn;

    public NewAddress (WebDriver driver){
        this.driver = driver;
    }

    public void initFieldNewAddressPage(){
        firstNameField = driver.findElement(By.xpath("//input[@id='address_first_name']"));
        lastNameField = driver.findElement(By.xpath("//input[@id='address_last_name']"));
        address1Field = driver.findElement(By.xpath("//input[@id='address_street_address']"));
        address2Field = driver.findElement(By.xpath("//input[@id='address_secondary_address']"));
        cityField = driver.findElement(By.xpath("//input[@id='address_city']"));
        stateSelect = driver.findElement(By.xpath("//select[@id='address_state']"));
        zipCodeField = driver.findElement(By.xpath("//input[@id='address_zip_code']"));
        countryUSRadioBtn = driver.findElement(By.xpath("//input[@id='address_country_us']"));
        countryCanadaRadioBtn = driver.findElement(By.xpath("//input[@id='address_country_canada']"));
        birthdayCalendar = driver.findElement(By.xpath("//input[@id='address_birthday']"));
        ageField = driver.findElement(By.xpath("//input[@id='address_age']"));
        websiteField = driver.findElement(By.xpath("//input[@id='address_website']"));
        phoneField = driver.findElement(By.xpath("//input[@id='address_phone']"));
        interestsClimbCheckBox = driver.findElement(By.xpath("//input[@id='address_interest_climb']"));
        interestsDanceCheckBox = driver.findElement(By.xpath("//input[@id='address_interest_dance']"));
        interestsReadCheckBox = driver.findElement(By.xpath("//input[@id='address_interest_read']"));
        noteFiled = driver.findElement(By.xpath("//textarea[@id='address_note']"));
        createAddressBtn = driver.findElement(By.xpath("//input[@data-test='submit']"));
        markerNewAddressPage = driver.findElement(By.xpath("//div[@class='container']/h2"));
    }

    public void clickCountryUSRadioBtn() { countryUSRadioBtn.click(); }

    public void clickCountryCanadaRadioBtn() { countryCanadaRadioBtn.click(); }

    public void setBirthdayCalendar(String dd_mm_yyyy) { birthdayCalendar.sendKeys(dd_mm_yyyy); }

    public void setWebsiteField(String website) { websiteField.sendKeys(website); }

    public void setPhoneField(String phone) { phoneField.sendKeys(phone); }

    public void clickInterestsClimbCheckBox() { interestsClimbCheckBox.click(); }

    public void clickInterestsReadCheckBox() { interestsReadCheckBox.click(); }

    public void clickInterestsDanceCheckBox() { interestsDanceCheckBox.click(); }

    public void setNoteFiled(String note) { noteFiled.sendKeys(note); }

    public void setAgeField(String age) { ageField.sendKeys(age); }

    public void setFirstNameField(String firstName) { firstNameField.sendKeys(firstName); }

    public void setLastNameField(String lastName) { lastNameField.sendKeys(lastName); }

    public void setAddress1Field(String address1) { address1Field.sendKeys(address1); }

    public void setAddress2Field(String address2) { address2Field.sendKeys(address2); }

    public void setCityField(String city) { cityField.sendKeys(city); }

    public void clickCreateAddressBtn(){ createAddressBtn.click(); }

    public void setStateSelect(String value) {
        Select select = new Select(stateSelect);
        select.selectByValue(value);
    }

    public void setZipCodeField(String zipCode) { zipCodeField.sendKeys(zipCode); }

    public boolean isNewAddressPage(){
        boolean result = false;

        if(markerNewAddressPage.getText().equals(ConfProperties.getProperty("new_address_page_marker"))){
            result = true;
        }

        return result;
    }
}
