package careerhabr.pages.components;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;

public class SpecializationPicker {
    private static final String specializationGroupList = ".specs-selector__groups div";
    private static final String specializationCategoryList = "div[class*=visible] .specs-selector__category";

    private static final String specializationFilterButtons = ".modal-window__box .button-group button";


    @Step("Select specialization group")
    public SpecializationPicker selectGroup(String groupName){
        $$(specializationGroupList)
                .find(text(groupName))
                .hover().click();
        return this;
    }

    @Step("Select specific specialization")
    public SpecializationPicker selectSpecificSpecialization(String specName){
        $$(specializationCategoryList)
                .find(text(specName))
                .hover().click();
        return this;
    }

    @Step("Submit specialization filter")
    public SpecializationPicker submit(){
        $$(specializationFilterButtons)
                .find(text("Применить"))
                .hover().click();
        return this;
    }
}
