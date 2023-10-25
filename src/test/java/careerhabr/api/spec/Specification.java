package careerhabr.api.spec;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static careerhabr.helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.with;


public class Specification {
    public static RequestSpecification requestSpec = with()
            .log().uri()
            .log().method()
            .log().body()
            .filter(withCustomTemplates())
            .contentType(ContentType.JSON);

    public static ResponseSpecification getVacanciesListWithStatusCode200 = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectBody(matchesJsonSchemaInClasspath("schemas/front-end-api-vacancies-schema.json"))
            .build();
    public static ResponseSpecification getResumesListWithStatusCode200 = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .expectBody(matchesJsonSchemaInClasspath("schemas/front-end-api-resumes-response-schema.json"))
            .build();

    public static ResponseSpecification postVacanciesListWithStatusCode422 = new ResponseSpecBuilder()
            .expectStatusCode(422)
            .build();
}
