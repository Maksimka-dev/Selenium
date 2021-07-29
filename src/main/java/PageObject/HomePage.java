package PageObject;

import com.codeborne.selenide.SelenideElement;
import utils.ConfProperties;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    private SelenideElement markerHomePage = $(byXpath("//div[@class='text-center']/h1"));

    public boolean isHomePage(){
        boolean result = false;

        markerHomePage.shouldHave(text(ConfProperties.getProperty("welcome_page_marker")));

        if(markerHomePage.text().equals(ConfProperties.getProperty("welcome_page_marker"))){

            result = true;
        }

        return result;
    }

}
