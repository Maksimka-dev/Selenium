package PageObject;

import com.codeborne.selenide.SelenideElement;
import utils.ConfProperties;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class SignInPage {

    private SelenideElement emailField = $(byXpath("//input[@id='session_email']"));
    private SelenideElement passField = $(byXpath("//input[@id='session_password']"));
    private SelenideElement markerSignInPage = $(byXpath("//div[@id='clearance']/h2"));
    private SelenideElement signInBtn = $(byXpath("//input[@value='Sign in']"));

    public void clickSignInBtn(){ signInBtn.click(); }

    public void setEmailField(String text){
        emailField.sendKeys(text);
    }

    public void setPassField(String text){
        passField.sendKeys(text);
    }

    public boolean isSignInPage(){
        boolean result = false;

        markerSignInPage.shouldHave(text(ConfProperties.getProperty("sign_in_page_marker")));

        if(markerSignInPage.text().equals(ConfProperties.getProperty("sign_in_page_marker"))){
            result = true;
        }

        return result;
    }
}
