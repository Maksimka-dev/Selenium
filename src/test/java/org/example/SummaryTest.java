package org.example;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import utils.Driver;
import utils.Log;


public class SummaryTest {
    public static WebDriver driver;
    public static SignInPage signInPage;
    public static WelcomePage welcomePage;
    public static AddressesPage addressesPage;
    public static NewAddress newAddressPage;
    public static CreateSuccessAddress createSuccessAddressPage;
    public static EditAddress editAddressPage;
    public static UpdateSuccessAddress updateSuccessAddressPage;

    @BeforeClass
    public static void setup() {
        driver = Driver.getChromeDriver();
        driver.get(ConfProperties.getProperty("sign_in_page"));
        signInPage = new SignInPage(driver);
        welcomePage = new WelcomePage(driver);
        addressesPage = new AddressesPage(driver);
        newAddressPage = new NewAddress(driver);
        createSuccessAddressPage = new CreateSuccessAddress(driver);
        editAddressPage = new EditAddress(driver);
        updateSuccessAddressPage = new UpdateSuccessAddress(driver);
    }

    @Test
    public void summaryTest(){
        Log.info("Начало теста");
        signInPage.initFieldsSignInPage();
        assertTrue(signInPage.isSignInPage());



        signInPage.setEmailField(ConfProperties.getProperty("email"));
        signInPage.setPassField(ConfProperties.getProperty("password"));
        signInPage.clickSignInBtn();


        welcomePage.initFieldsWelcomePage();
        assertTrue(welcomePage.isWelcomePage());
        Log.info("Вход в аккаунт выполнен");

        welcomePage.clickWelcomeBtn();

        addressesPage.initFieldAddressesPage();
        assertTrue(addressesPage.isAddressesPage());
        Log.info("Переход на страницу с таблицей адресов выполнен");

        addressesPage.clickNewAddressBtn();

        newAddressPage.initFieldNewAddressPage();
        assertTrue(newAddressPage.isNewAddressPage());
        Log.info("Переход на страницу создания нового адреса выполнен");

        newAddressPage.setFirstNameField(ConfProperties.getProperty("firstNameNewAddress"));
        newAddressPage.setLastNameField(ConfProperties.getProperty("lastNameNewAddress"));
        newAddressPage.setAddress1Field(ConfProperties.getProperty("address1NewAddress"));
        newAddressPage.setAddress2Field(ConfProperties.getProperty("address2NewAddress"));
        newAddressPage.setCityField(ConfProperties.getProperty("cityNewAddress"));
        newAddressPage.setStateSelect(ConfProperties.getProperty("stateValueNewAddress"));
        newAddressPage.setZipCodeField(ConfProperties.getProperty("zipCodeNewAddress"));
        newAddressPage.clickCountryUSRadioBtn();
        newAddressPage.setBirthdayCalendar(ConfProperties.getProperty("birthdayCalendarNewAddress"));
        newAddressPage.setAgeField(ConfProperties.getProperty("ageNewAddress"));
        newAddressPage.setWebsiteField(ConfProperties.getProperty("websiteNewAddress"));
        newAddressPage.setPhoneField(ConfProperties.getProperty("phoneNewAddress"));
        newAddressPage.clickInterestsDanceCheckBox();
        newAddressPage.setNoteFiled(ConfProperties.getProperty("noteNewAddress"));
        newAddressPage.clickCreateAddressBtn();


        createSuccessAddressPage.initFieldCreateSuccessAddress();
        assertTrue(createSuccessAddressPage.isCreateSuccessAddressPage());
        Log.info("Создание нового адреса выполнено");
        Log.info("Переход на страницу предварительного просмотра нового адреса выполнен");

        createSuccessAddressPage.clickAddressesBtn();

        addressesPage.initFieldAddressesPage();
        addressesPage.initFiledTableAddressesPage();
        assertTrue(addressesPage.isAddressesPage());
        Log.info("Переход на страницу с таблицей адресов выполнен");

        addressesPage.clickEditLastEntryAddressBtn();

        editAddressPage.initFieldCreateAddressPage();
        assertTrue(editAddressPage.isEditAddressPage());
        Log.info("Переход на страницу редактирования адреса выполнен");

        editAddressPage.clearFirstNameField();
        editAddressPage.setFirstNameField(ConfProperties.getProperty("firstNameEditAddress"));
        editAddressPage.clearLastNameField();
        editAddressPage.setLastNameField(ConfProperties.getProperty("lastNameEditAddress"));
        editAddressPage.clearAddress1Field();
        editAddressPage.setAddress1Field(ConfProperties.getProperty("address1EditAddress"));
        editAddressPage.clearAddress2Field();
        editAddressPage.setAddress2Field(ConfProperties.getProperty("address2EditAddress"));
        editAddressPage.clearCityField();
        editAddressPage.setCityField(ConfProperties.getProperty("cityEditAddress"));
        editAddressPage.clickUpdateAddressBtn();


        updateSuccessAddressPage.initFieldUpdateSuccessAddress();
        assertTrue(updateSuccessAddressPage.isUpdateSuccessAddressPage());
        Log.info("Редактирование адреса выполнено");
        Log.info("Переход на страницу предварительного просмотра отредактированного адреса выполнен");

        updateSuccessAddressPage.clickAddressesBtn();


        addressesPage.initFieldAddressesPage();
        addressesPage.initFiledTableAddressesPage();
        assertTrue(addressesPage.isAddressesPage());
        Log.info("Переход на страницу с таблицей адресов выполнен");

        addressesPage.clickDestroyLastEntryAddressBtn();
        Log.info("Удаление записи в талице адресов выполнено");

        driver.switchTo().alert().accept();

    }

    @AfterClass
    public static void tearDown(){
        addressesPage.initFieldAddressesPage();
        addressesPage.initFiledTableAddressesPage();
        addressesPage.clickSignOutBtn();
        Log.info("Выход из учетной записи выполнен");
        driver.quit();
    }
}
