package careerhabr.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private static SelenideElement
            searchInput = $("[name=q]");


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

    @Step("Open main page")
    public MainPage openFavicon(){
        open("https://career.habr.com/images/favicons/favicon-16.png");
        return this;
    }


}
