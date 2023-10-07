package careerhabr.tests;

import careerhabr.api.models.VacancyResponseModel;
import careerhabr.pages.VacancyPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import java.util.List;

import static careerhabr.api.spec.Specification.getVacanciesListWithStatusCode200;
import static careerhabr.api.spec.Specification.requestSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

@Owner("EphimSh")
@Feature("Frontend API")
public class GetVacancies extends TestBase {

    private static final VacancyPage vacancyPage = new VacancyPage();

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

}

