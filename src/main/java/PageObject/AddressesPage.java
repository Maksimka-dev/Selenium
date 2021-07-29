package PageObject;

import com.codeborne.selenide.SelenideElement;
import utils.ConfProperties;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class AddressesPage {

    private SelenideElement newAddressBtn = $(byXpath("//a[@data-test='create']"));
    private SelenideElement markerAddressesPage = $(byXpath("//div[@class='container']/h2"));
    private SelenideElement markerDestroyAddress = $(byXpath("//div[@data-test='notice']"));
    private SelenideElement editLastEntryAddress = $(byXpath("//tr[last()]//a[text()='Edit']"));
    private SelenideElement destroyLastEntryAddress = $(byXpath("//tr[last()]//a[text()='Destroy']"));

    public void clickNewAddressBtn(){ newAddressBtn.click(); }

    public void clickEditLastEntryAddressBtn(){ editLastEntryAddress.click(); }

    public void clickDestroyLastEntryAddressBtn(){ destroyLastEntryAddress.click(); }

    public boolean isAddressDestroy(){
        boolean result = false;

        markerDestroyAddress.shouldHave(text(ConfProperties.getProperty("destroy_address_marker")));

        if(markerDestroyAddress.text().equals(ConfProperties.getProperty("destroy_address_marker"))){
            result = true;
        }

        return result;
    }

    public boolean isAddressesPage(){
        boolean result = false;

        markerAddressesPage.shouldHave(text(ConfProperties.getProperty("addresses_page_marker")));

        if(markerAddressesPage.text().equals(ConfProperties.getProperty("addresses_page_marker"))){
            result = true;
        }

        return result;
    }
}
