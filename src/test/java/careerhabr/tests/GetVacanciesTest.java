package careerhabr.tests;

import careerhabr.api.models.ResumeResponseModel;
import careerhabr.api.models.VacancyResponseModel;
import careerhabr.pages.MainPage;
import careerhabr.pages.VacancyPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.restassured.response.ExtractableResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static careerhabr.api.spec.Specification.*;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Owner("EphimSh")
@Feature("Frontend API")
public class GetVacanciesTest extends TestBase {

    private static final VacancyPage vacancyPage = new VacancyPage();
    private static final MainPage mainPage = new MainPage();

    @Test
    @Tags({@Tag("api"), @Tag("ui")})
    @Story("Get vacancy by ID")
    @DisplayName("Verify Vacancy Information")
    @Description("This test verifies the information of a specific vacancy.")
    void getVacancyById() {
        List<VacancyResponseModel> response = step("Make response to get vacancies list", () -> given(requestSpec)
                .formParam("q", "QA")
                .formParam("sort", "relevance")
                .formParam("type", "all")
                .formParam("exclude_company", true)
                .formParam("qid", 4)
                .formParam("skills[]", 1012)
                .formParam("locations[]", "c_678")
                .formParam("locations[]", "c_679")
                .formParam("company_id", 1000051415)
                .formParam("currency", "RUR")
                .formParam("s[]", 10)
                .when()
                .get("vacancies")
                .then()
                .spec(getVacanciesListWithStatusCode200)
                .extract().jsonPath()
                .getList("list", VacancyResponseModel.class));

        String specificVacancyId = String.valueOf(response.get(0).getId());
        String companyTitle = response.get(0).getCompany().getTitle();
        String vacancyRequiredSkill = response.get(0).getSkills().get(1).getTitle();
        String vacancyTitle = response.get(0).getTitle();

        vacancyPage.openVacancyById(specificVacancyId);
        vacancyPage.checkCompanyTitle(companyTitle);
        vacancyPage.checkVacancyTitle(vacancyTitle);
        vacancyPage.checkRequiredSkill(vacancyRequiredSkill);

    }

    @Test
    @Tags({@Tag("api"), @Tag("ui")})
    @Story("Get vacancy by ID")
    @DisplayName("Ensure Vacancy IDs are Unique")
    @Description("This test verifies that each Vacancy ID is unique in the response.")
    void vacancyIdsAreUnique() {
        mainPage.openFavicon();
        List<VacancyResponseModel> response = step("Make response to get vacancies list", () -> given(requestSpec)
                .formParam("q", "QA")
                .when()
                .get("vacancies")
                .then()
                .spec(getVacanciesListWithStatusCode200)
                .extract().jsonPath()
                .getList("list", VacancyResponseModel.class));
        step("Check taht each id is unique", () -> {
            Set<Long> uniqueIds = response.stream()
                    .map(VacancyResponseModel::getId)
                    .collect(Collectors.toSet());
            assertEquals(response.size(), uniqueIds.size());
        });
    }

    @Test
    @Tags({@Tag("api"), @Tag("ui")})
    @Story("Get vacancy by ID")
    @DisplayName("Ensure Vacancy IDs are Unique")
    @Description("This test verifies that the POST request for vacancies returns a 422 status code with a specific error message.")
    void postVacancies() {
        mainPage.openFavicon();
        ExtractableResponse response = (ExtractableResponse) step("Make post request", () -> given(requestSpec)
                .when()
                .post("vacancies")
                .then()
                .spec(postVacanciesListWithStatusCode422)
                .extract().response());
        step("Check body", () -> {
            String body = response.body().asString();
            assertTrue(body.contains("The change you wanted was rejected (422)"));
        });
    }

}

