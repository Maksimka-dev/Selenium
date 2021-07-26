package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInPage {

    private WebDriver driver;
    private WebElement emailField;
    private WebElement passField;
    private WebElement markerSignInPage;
    private WebElement signInBtn;

    public SignInPage (WebDriver driver){
        this.driver = driver;
    }

    public void initFieldsSignInPage(){
        markerSignInPage = driver.findElement(By.xpath("//div[@id='clearance']/h2"));
        emailField = driver.findElement(By.xpath("//input[@id='session_email']"));
        passField = driver.findElement(By.xpath("//input[@id='session_password']"));
        signInBtn = driver.findElement(By.xpath("//input[@value='Sign in']"));
    }

    public void clickSignInBtn(){ signInBtn.click(); }

    public void setEmailField(String text){
        emailField.sendKeys(text);
    }

    public void setPassField(String text){
        passField.sendKeys(text);
    }

    public boolean isSignInPage(){
        boolean result = false;

        if(markerSignInPage.getText().equals(ConfProperties.getProperty("sign_in_page_marker"))){
            result = true;
        }

        return result;
    }
}
