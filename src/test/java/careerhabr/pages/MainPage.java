package careerhabr.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private static SelenideElement
            searchInput = $("[name=q]"),
            switchButton = $("a[class*=switch-button]");


    @Step("Open main page")
    public MainPage openMainPage(){
        open("");
        return this;
    }

    @Step("Search for a specific vacancy")
    public MainPage search(String text){
        searchInput.hover().sendKeys(text);
        searchInput.pressEnter();
        return this;
    }

}
