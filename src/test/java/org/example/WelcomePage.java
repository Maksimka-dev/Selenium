package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WelcomePage {

    private WebDriver driver;
    private WebElement markerWelcomePage;
    private WebElement addressesBtn;

    public WelcomePage(WebDriver driver){
        this.driver = driver;
    }

    public void initFieldsWelcomePage()
    {
        markerWelcomePage = driver.findElement(By.xpath("//div[@class='text-center']/h1"));
        addressesBtn = driver.findElement(By.xpath("//a[@data-test='addresses']"));
    }

    public void clickWelcomeBtn(){ addressesBtn.click(); }

    public boolean isWelcomePage(){
        boolean result = false;

        if(markerWelcomePage.getText().equals(ConfProperties.getProperty("welcome_page_marker"))){

            result = true;
        }

        return result;
    }

}
