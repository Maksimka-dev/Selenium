package org.example;

import PageElement.TopMenu;
import PageObject.*;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Driver;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import utils.ConfProperties;
import utils.Log;
//import utils.Driver;


public class SummaryTest {

    public static WebDriver driver;
    public static SignInPage signInPage;
    public static TopMenu topMenu;
    public static HomePage homePage;
    public static AddressesPage addressesPage;
    public static NewEditAddress newEditAddressPage;
    public static ShowAddress showAddressPage;
    public static NewEditAddress editCreateAddressPage;

    @BeforeClass
    public static void setup() {
        Configuration.baseUrl = "http://a.testaddressbook.com/sign_in";
        open(Configuration.baseUrl);
        driver = WebDriverRunner.getWebDriver();
        signInPage = new SignInPage();
        topMenu = new TopMenu();
        homePage = new HomePage();
        addressesPage = new AddressesPage();
        newEditAddressPage = new NewEditAddress();
        showAddressPage = new ShowAddress();
    }
    @AfterClass
    public static void tearDown(){
        topMenu.clickSignOutBtn();
        assertTrue(signInPage.isSignInPage());
        Log.info("Выход из учетной записи выполнен");
    }

    @Test
    public void summaryTest(){
        Log.info("Начало теста");
        assertTrue(signInPage.isSignInPage());


        signInPage.setEmailField(ConfProperties.getProperty("email"));
        signInPage.setPassField(ConfProperties.getProperty("password"));
        signInPage.clickSignInBtn();


        assertTrue(homePage.isHomePage());
        Log.info("Вход в аккаунт выполнен");

        topMenu.clickAddressBtn();

        assertTrue(addressesPage.isAddressesPage());
        Log.info("Переход на страницу с таблицей адресов выполнен");

        addressesPage.clickNewAddressBtn();

        assertTrue(newEditAddressPage.isNewAddressPage());
        Log.info("Переход на страницу создания нового адреса выполнен");

        newEditAddressPage.setFirstNameField(ConfProperties.getProperty("firstNameNewAddress"));
        newEditAddressPage.setLastNameField(ConfProperties.getProperty("lastNameNewAddress"));
        newEditAddressPage.setAddress1Field(ConfProperties.getProperty("address1NewAddress"));
        newEditAddressPage.setAddress2Field(ConfProperties.getProperty("address2NewAddress"));
        newEditAddressPage.setCityField(ConfProperties.getProperty("cityNewAddress"));
        newEditAddressPage.setStateSelect(ConfProperties.getProperty("stateValueNewAddress"));
        newEditAddressPage.setZipCodeField(ConfProperties.getProperty("zipCodeNewAddress"));
        newEditAddressPage.clickCountryUSRadioBtn();
        newEditAddressPage.setBirthdayCalendar(ConfProperties.getProperty("birthdayCalendarNewAddress"));
        newEditAddressPage.setAgeField(ConfProperties.getProperty("ageNewAddress"));
        newEditAddressPage.setWebsiteField(ConfProperties.getProperty("websiteNewAddress"));
        newEditAddressPage.setPhoneField(ConfProperties.getProperty("phoneNewAddress"));
        newEditAddressPage.clickInterestsDanceCheckBox();
        newEditAddressPage.setNoteFiled(ConfProperties.getProperty("noteNewAddress"));
        newEditAddressPage.clickSubmitAddressBtn();

        assertTrue(showAddressPage.isCreateSuccessAddressPage());
        Log.info("Создание нового адреса выполнено");
        Log.info("Переход на страницу предварительного просмотра нового адреса выполнен");

        topMenu.clickAddressBtn();

        assertTrue(addressesPage.isAddressesPage());
        Log.info("Переход на страницу с таблицей адресов выполнен");

        addressesPage.clickEditLastEntryAddressBtn();

        assertTrue(newEditAddressPage.isEditAddressPage());
        Log.info("Переход на страницу редактирования адреса выполнен");

        newEditAddressPage.clearFirstNameField();
        newEditAddressPage.setFirstNameField(ConfProperties.getProperty("firstNameEditAddress"));
        newEditAddressPage.clearLastNameField();
        newEditAddressPage.setLastNameField(ConfProperties.getProperty("lastNameEditAddress"));
        newEditAddressPage.clearAddress1Field();
        newEditAddressPage.setAddress1Field(ConfProperties.getProperty("address1EditAddress"));
        newEditAddressPage.clearAddress2Field();
        newEditAddressPage.setAddress2Field(ConfProperties.getProperty("address2EditAddress"));
        newEditAddressPage.clearCityField();
        newEditAddressPage.setCityField(ConfProperties.getProperty("cityEditAddress"));
        newEditAddressPage.clickSubmitAddressBtn();


        assertTrue(showAddressPage.isUpdateSuccessAddressPage());
        Log.info("Редактирование адреса выполнено");
        Log.info("Переход на страницу предварительного просмотра отредактированного адреса выполнен");

        topMenu.clickAddressBtn();


        assertTrue(addressesPage.isAddressesPage());
        Log.info("Переход на страницу с таблицей адресов выполнен");

        addressesPage.clickDestroyLastEntryAddressBtn();

        driver.switchTo().alert().accept();
        assertTrue(addressesPage.isAddressDestroy());
        Log.info("Удаление записи в талице адресов выполнено");

    }
}
