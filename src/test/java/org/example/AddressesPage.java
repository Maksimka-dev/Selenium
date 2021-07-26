package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddressesPage {

    private WebDriver driver;
    private WebElement newAddressBtn;
    private WebElement markerAddressesPage;
    private WebElement editLastEntryAddress;
    private WebElement destroyLastEntryAddress;
    private WebElement signOutBtn;

    public AddressesPage (WebDriver driver){
        this.driver = driver;
    }

    public void initFieldAddressesPage(){
        newAddressBtn = driver.findElement(By.xpath("//a[@data-test='create']"));
        signOutBtn = driver.findElement(By.xpath("//a[@data-test='sign-out']"));
        markerAddressesPage = driver.findElement(By.xpath("//div[@class='container']/h2"));
    }

    public void initFiledTableAddressesPage(){
        editLastEntryAddress = driver.findElement(By.xpath("//tbody/tr[last()]/td[6]/a"));
        destroyLastEntryAddress = driver.findElement(By.xpath("//tbody/tr[last()]/td[7]/a"));
    }

    public void clickNewAddressBtn(){ newAddressBtn.click(); }

    public void clickSignOutBtn(){ signOutBtn.click(); }

    public void clickEditLastEntryAddressBtn(){ editLastEntryAddress.click(); }

    public void clickDestroyLastEntryAddressBtn(){ destroyLastEntryAddress.click(); }

    public boolean isAddressesPage(){
        boolean result = false;

        if(markerAddressesPage.getText().equals(ConfProperties.getProperty("addresses_page_marker"))){
            result = true;
        }

        return result;
    }
}
