package careerhabr.tests;

import careerhabr.pages.MainPage;
import careerhabr.pages.VacanciesListPage;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

@Owner("EphimSh")
@Feature("Search")
@Tag("ui")
public class SearchTest extends TestBase {

    private static Properties loadProperties() {
        Properties properties = new Properties();
        try (InputStreamReader input = new InputStreamReader(SearchTest.class.getClassLoader().getResourceAsStream("config/search-testdata.properties"), StandardCharsets.UTF_8)) {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
    private static final Properties props = loadProperties();
    private static final Faker faker = new Faker();
    private static final MainPage mainPage = new MainPage();
    private static final VacanciesListPage vacanciesListPage = new VacanciesListPage();

    @Disabled
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
        mainPage.search(props.getProperty("company"));
        vacanciesListPage.checkResult(props.getProperty("company"));
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
    @Story("Filter side-bar")
    @DisplayName("Search with Filter")
    @Description("This test performs a filtered search and checks the results.")
    void searchWithFilter() {
        mainPage.openMainPage();
        mainPage.search(props.getProperty("vacancy"));

        vacanciesListPage.specPickerClick();
        vacanciesListPage.selectGroup(props.getProperty("specialization_group"));
        vacanciesListPage.selectSpecificSpecialization(props.getProperty("specialization"));
        vacanciesListPage.submit();
        vacanciesListPage.selectQualification();
        vacanciesListPage.selectSkill(props.getProperty("skill"));
        vacanciesListPage.selectLocation(props.getProperty("city"));
        vacanciesListPage.selectEmploymentType();
        vacanciesListPage.deListCompany(props.getProperty("de_list_company"));

        vacanciesListPage.checkResult(props.getProperty("vacancy"));
        vacanciesListPage.checkResult(props.getProperty("skill"));
        vacanciesListPage.checkResult(props.getProperty("city"));
    }

    @Test
    @Story("Filter side-bar")
    @DisplayName("Empty list message check")
    @Description("This test checks if a specific message appears when searching with an invalid skill.")
    void skillFilterCheck() {
        mainPage.openMainPage();
        mainPage.search(props.getProperty("vacancy"));
        vacanciesListPage.searchSkill("--");
        vacanciesListPage.checkSuggestionResultMessage("Ничего не найдено");

    }
}
