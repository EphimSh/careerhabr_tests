package careerhabr.pages;

import careerhabr.pages.components.SpecializationPicker;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class VacanciesListPage extends SpecializationPicker {
    private static final SelenideElement
            searchResult = $(".section-group"),
            specializationPicker = $(".specs-picker__specs");
    String sideBarFilterList = ".list-page-sidebar__filters";
    String suggestionList = ".suggestion-items div";

    @Step("Check searched result")
    public VacanciesListPage checkResult(String text) {
        searchResult.shouldHave(text(text));
        return this;
    }

    @Step("Click on specialization picker")
    public VacanciesListPage specPickerClick() {
        specializationPicker.hover().click();
        return this;
    }

    @Step("Select qualification")
    public VacanciesListPage selectQualification() {
        $$(sideBarFilterList)
                .find(exist)
                .find(byText("Квалификация"))
                .parent().sibling(0)
                .find("select")
                .selectOption("Средний (Middle)");
        return this;
    }

    @Step("Select skill")
    public VacanciesListPage selectSkill(String skill) {
        $$(sideBarFilterList)
                .find(exist)
                .find(byAttribute("placeholder", "Выберите навык"))
                .hover().sendKeys(skill);
        $$(suggestionList)
                .find(text(skill))
                .hover()
                .click();
        return this;
    }

    @Step("Select location")
    public VacanciesListPage selectLocation(String location) {
        $$(sideBarFilterList)
                .find(exist)
                .find(byAttribute("placeholder", "Введите город, область или страну"))
                .hover().sendKeys(location);
        $$(suggestionList)
                .find(text(location))
                .hover()
                .click();
        return this;
    }

    @Step("Select employment type")
    public VacanciesListPage selectEmploymentType() {
        $$(sideBarFilterList)
                .find(exist)
                .find(byText("Тип занятости"))
                .parent().sibling(0)
                .find("select")
                .selectOption("Полный рабочий день");
        System.out.println();
        return this;
    }

    @Step("Select company to de-list")
    public VacanciesListPage deListCompany(String companyName) {
        $$(sideBarFilterList)
                .find(exist)
                .find(byAttribute("placeholder", "Выберите компанию"))
                .hover().sendKeys(companyName);
        $$(suggestionList)
                .find(text(companyName))
                .hover()
                .click();

        $$(sideBarFilterList)
                .find(exist)
                .find(byText("Компания")).parent()
                .sibling(0).find(byText("Исключить из поиска"))
                .hover().click();
        return this;
    }

}
