package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateSuccessAddress {
    private  WebDriver driver;
    private  WebElement markerCreateSuccessAddress;
    private  WebElement addressesBtn;

    public CreateSuccessAddress(WebDriver driver){ this.driver = driver; }

    public void initFieldCreateSuccessAddress(){
        markerCreateSuccessAddress = driver.findElement(By.xpath("//div[@data-test='notice']"));
        addressesBtn = driver.findElement(By.xpath("//a[@data-test='addresses']"));
    }

    public void clickAddressesBtn(){ addressesBtn.click(); }

    public boolean isCreateSuccessAddressPage(){
        boolean result = false;

        if(markerCreateSuccessAddress.getText().equals(ConfProperties.getProperty("create_success_address_marker"))){
            result = true;
        }

        return result;
    }
}
