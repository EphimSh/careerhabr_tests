package careerhabr.tests;

import careerhabr.pages.MainPage;
import careerhabr.pages.VacanciesListPage;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Owner("EphimSh")
@Feature("Search")
@Tag("ui")
public class SearchTest extends TestBase {

    private static final Faker faker = new Faker();
    private static final String VACANCY = "QA";
    private static final String SPECIZLIZATION_CATEGORY = "Тестирование";
    private static final String SPECIZLIZATION_GROUP = "Инженер по автоматизации тестирования";
    private static final String DE_LIST_COMPANY = "Aston (ex. Andersen)";
    private static final String CITY = "Санкт-Петербург";
    private static final String SKILL = "Java";
    private static final String COMPANY = "VK";
    private static final MainPage mainPage = new MainPage();
    private static final VacanciesListPage vacanciesListPage = new VacanciesListPage();

    @ParameterizedTest(name = "{0}")
    @ValueSource(strings = {"QA", "Frontend", "Backend", "DevOps"})
    @Story("Parametrized test: Simple search")
    @DisplayName("Search for Specific Vacancy:")
    @Description("This test searches for a specific vacancy.")
    void searchForSpecificVacancy(String specific) {
        mainPage.openMainPage();
        mainPage.search(specific);
        vacanciesListPage.checkResult(specific);
    }

    @Test
    @Story("Simple search")
    @DisplayName("Search by Company")
    @Description("This test searches for vacancies by a specific company.")
    void searchByCompany() {
        mainPage.openMainPage();
        mainPage.search(COMPANY);
        vacanciesListPage.checkResult(COMPANY);
    }

    @Test
    @Story("Searched item not found")
    @DisplayName("Failed Search")
    @Description("This test performs a search that is expected to fail and checks the result.")
    void failedSearch() {
        mainPage.openMainPage();
        mainPage.search(faker.lorem().characters());
        vacanciesListPage.checkResult("Поиск не дал результатов");
    }

    @Test
    @Story("Using filter side-bar")
    @DisplayName("Search with Filter")
    @Description("This test performs a filtered search and checks the results.")
    void searchWithFilter() {
        mainPage.openMainPage();
        mainPage.search(VACANCY);

        vacanciesListPage.specPickerClick();
        vacanciesListPage.selectGroup(SPECIZLIZATION_CATEGORY);
        vacanciesListPage.selectSpecificSpecialization(SPECIZLIZATION_GROUP);
        vacanciesListPage.submit();
        vacanciesListPage.selectQualification();
        vacanciesListPage.selectSkill(SKILL);
        vacanciesListPage.selectLocation(CITY);
        vacanciesListPage.selectEmploymentType();
        vacanciesListPage.deListCompany(DE_LIST_COMPANY);

        vacanciesListPage.checkResult(VACANCY);
        vacanciesListPage.checkResult(SKILL);
        vacanciesListPage.checkResult(CITY);
    }
}
