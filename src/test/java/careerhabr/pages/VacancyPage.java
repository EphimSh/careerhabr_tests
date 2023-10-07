package careerhabr.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class VacancyPage {

    private static final SelenideElement companyTitle = $(".company_name a");
    private static final SelenideElement vacancyTitle = $(".vacancy-header__title");

    @Step("Open vacancy page by using it's id")
    public VacancyPage openVacancyById(String id){
        open("vacancies/" + id);
        return this;
    }

    @Step("Check company title")
    public VacancyPage checkCompanyTitle(String title){
        companyTitle.shouldHave(text(title));
        return this;
    }

    @Step("Check vacancy title")
    public VacancyPage checkVacancyTitle(String title){
        vacancyTitle.shouldHave(text(title));
        return this;
    }

    @Step("Check required skill")
    public VacancyPage checkRequiredSkill(String skill){
        vacancyTitle.sibling(0)
                .shouldHave(text(skill));
        return this;
    }

}
