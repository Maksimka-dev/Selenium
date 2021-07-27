package PageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ConfProperties;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class AddressesPage {

    private SelenideElement newAddressBtn = $(byXpath("//a[@data-test='create']"));
    private SelenideElement markerAddressesPage = $(byXpath("//div[@class='container']/h2"));
    private SelenideElement editLastEntryAddress = $(byXpath("//tbody/tr[last()]/td[6]/a"));
    private SelenideElement destroyLastEntryAddress = $(byXpath("//tbody/tr[last()]/td[7]/a"));
    private SelenideElement signOutBtn = $(byXpath("//a[@data-test='sign-out']"));


    public void clickNewAddressBtn(){ newAddressBtn.click(); }

    public void clickSignOutBtn(){ signOutBtn.click(); }

    public void clickEditLastEntryAddressBtn(){ editLastEntryAddress.click(); }

    public void clickDestroyLastEntryAddressBtn(){ destroyLastEntryAddress.click(); }

    public boolean isAddressesPage(){
        boolean result = false;

        if(markerAddressesPage.text().equals(ConfProperties.getProperty("addresses_page_marker"))){
            result = true;
        }

        return result;
    }
}
