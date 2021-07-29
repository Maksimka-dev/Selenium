package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.ui.Select;
import utils.ConfProperties;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class NewEditAddressPage {

    private SelenideElement markerNewEditAddressPage = $(byXpath("//div[@class='container']/h2"));
    private SelenideElement firstNameField = $(byXpath("//input[@id='address_first_name']"));
    private SelenideElement lastNameField = $(byXpath("//input[@id='address_last_name']"));
    private SelenideElement address1Field = $(byXpath("//input[@id='address_street_address']"));
    private SelenideElement address2Field = $(byXpath("//input[@id='address_secondary_address']"));
    private SelenideElement cityField = $(byXpath("//input[@id='address_city']"));
    private SelenideElement stateSelect = $(byXpath("//select[@id='address_state']"));
    private SelenideElement zipCodeField = $(byXpath("//input[@id='address_zip_code']"));
    private SelenideElement countryUSRadioBtn = $(byXpath("//input[@id='address_country_us']"));
    private SelenideElement countryCanadaRadioBtn = $(byXpath("//input[@id='address_country_canada']"));
    private SelenideElement birthdayCalendar = $(byXpath("//input[@id='address_birthday']"));
    private SelenideElement ageField = $(byXpath("//input[@id='address_age']"));
    private SelenideElement websiteField = $(byXpath("//input[@id='address_website']"));
    private SelenideElement phoneField = $(byXpath("//input[@id='address_phone']"));
    private SelenideElement interestsClimbCheckBox = $(byXpath("//input[@id='address_interest_climb']"));
    private SelenideElement interestsReadCheckBox = $(byXpath("//input[@id='address_interest_read']"));
    private SelenideElement interestsDanceCheckBox = $(byXpath("//input[@id='address_interest_dance']"));
    private SelenideElement noteFiled = $(byXpath("//textarea[@id='address_note']"));
    private SelenideElement submitAddressBtn = $(byXpath("//input[@data-test='submit']"));

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

    public void clearFirstNameField(){ firstNameField.clear(); }

    public void setLastNameField(String lastName) { lastNameField.sendKeys(lastName); }

    public void clearLastNameField() { lastNameField.clear(); }

    public void setAddress1Field(String address1) { address1Field.sendKeys(address1); }

    public void clearAddress1Field() { address1Field.clear(); }

    public void setAddress2Field(String address2) { address2Field.sendKeys(address2); }

    public void clearAddress2Field() { address2Field.clear(); }

    public void setCityField(String city) { cityField.sendKeys(city); }

    public void clearCityField() { cityField.clear(); }

    public void clickSubmitAddressBtn(){ submitAddressBtn.click(); }

    public void setStateSelect(String value) {
        Select select = new Select(stateSelect);
        select.selectByValue(value);
    }

    public void setZipCodeField(String zipCode) { zipCodeField.sendKeys(zipCode); }

    public boolean isEditAddressPage(){
        boolean result = false;
        markerNewEditAddressPage.shouldHave(text(ConfProperties.getProperty("edit_address_page_marker")));

        if(markerNewEditAddressPage.text().equals(ConfProperties.getProperty("edit_address_page_marker"))){
            result = true;
        }

        return result;
    }

    public boolean isNewAddressPage(){
        boolean result = false;
        markerNewEditAddressPage.shouldHave(text(ConfProperties.getProperty("new_address_page_marker")));

        if(markerNewEditAddressPage.text().equals(ConfProperties.getProperty("new_address_page_marker"))){
            result = true;
        }

        return result;
    }
}
