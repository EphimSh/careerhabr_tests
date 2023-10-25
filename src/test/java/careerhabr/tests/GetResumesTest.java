package careerhabr.tests;

import careerhabr.api.models.ResumeResponseModel;
import careerhabr.pages.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static careerhabr.api.spec.Specification.getResumesListWithStatusCode200;
import static careerhabr.api.spec.Specification.requestSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@Owner("EphimSh")
@Feature("Frontend API")
public class GetResumesTest extends TestBase {

    MainPage mainPage = new MainPage();

    @Test
    @Tags({@Tag("api"), @Tag("ui")})
    @Story("Get resumes")
    @DisplayName("Verify that all IDs are unique")
    @Description("This test verifies that all the IDs in the list of resumes are unique.")
    void checkResumeIdUniqueness() {
        step("Open favicon", () -> mainPage.openFavicon());
        List<ResumeResponseModel> response = step("Get list of resumes", () -> given(requestSpec)
                .formParam("q", "QA")
                .when()
                .get("resumes")
                .then()
                .spec(getResumesListWithStatusCode200)
                .extract().jsonPath()
                .getList("list", ResumeResponseModel.class)
        );
        step("Check that each id is unique", () -> {
            Set<String> uniqueIds = response.stream()
                    .map(ResumeResponseModel::getId)
                    .collect(Collectors.toSet());
            assertEquals(response.size(), uniqueIds.size());
        });
    }

    @Test
    @Tags({@Tag("api"), @Tag("ui")})
    @Story("Get resumes")
    @DisplayName("Verify that all IDs are String type")
    @Description("This test verifies that all the IDs in the list of resumes are of type String.")
    void checkIdType() {
        step("Open favicon", () -> mainPage.openFavicon());
        List<ResumeResponseModel> response = step("Get list of resumes", () -> given(requestSpec)
                .formParam("q", "QA")
                .when()
                .get("resumes")
                .then()
                .spec(getResumesListWithStatusCode200)
                .extract().jsonPath()
                .getList("list", ResumeResponseModel.class)
        );
        step("Check that each id is unique and String type", () -> {
            Set<String> uniqueIds = response.stream()
                    .map(ResumeResponseModel::getId)
                    .collect(Collectors.toSet());

            assertTrue(uniqueIds.stream().allMatch(id -> id instanceof String));
        });
    }
}
