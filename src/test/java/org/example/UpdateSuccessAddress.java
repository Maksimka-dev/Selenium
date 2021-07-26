package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpdateSuccessAddress {
    private WebDriver driver;
    private WebElement markerUpdateSuccessAddress;
    private  WebElement addressesBtn;

    public UpdateSuccessAddress(WebDriver driver){ this.driver = driver; }

    public void initFieldUpdateSuccessAddress(){
        markerUpdateSuccessAddress = driver.findElement(By.xpath("//div[@data-test='notice']"));
        addressesBtn = driver.findElement(By.xpath("//a[@data-test='addresses']"));
    }

    public void clickAddressesBtn(){ addressesBtn.click(); }

    public boolean isUpdateSuccessAddressPage(){
        boolean result = false;

        if(markerUpdateSuccessAddress.getText().equals(ConfProperties.getProperty("update_success_address_marker"))){
            result = true;
        }

        return result;
    }
}
