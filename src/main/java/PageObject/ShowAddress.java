package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import utils.ConfProperties;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class ShowAddress {

    private  SelenideElement markerCreateUpdateSuccessAddress = $(byXpath("//div[@data-test='notice']"));

    public boolean isCreateSuccessAddressPage(){
        boolean result = false;
        markerCreateUpdateSuccessAddress.shouldHave(text(ConfProperties.getProperty("create_success_address_marker")));

        if(markerCreateUpdateSuccessAddress.text().equals(ConfProperties.getProperty("create_success_address_marker"))){
            result = true;
        }

        return result;
    }

    public boolean isUpdateSuccessAddressPage(){
        boolean result = false;
        markerCreateUpdateSuccessAddress.shouldHave(text(ConfProperties.getProperty("update_success_address_marker")));

        if(markerCreateUpdateSuccessAddress.text().equals(ConfProperties.getProperty("update_success_address_marker"))){
            result = true;
        }

        return result;
    }
}
