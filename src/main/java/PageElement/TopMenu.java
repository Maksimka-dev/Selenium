package PageElement;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class TopMenu {
    private SelenideElement homeBtn = $(byXpath("//a[@data-test='home']"));
    private SelenideElement addressesBtn = $(byXpath("//a[@data-test='addresses']"));
    private SelenideElement signOutBtn = $(byXpath("//a[@data-test='sign-out']"));

    public void clickHomeBtn(){ homeBtn.click(); }
    public void clickAddressBtn(){ addressesBtn.click(); }
    public void clickSignOutBtn(){ signOutBtn.click(); }
}
