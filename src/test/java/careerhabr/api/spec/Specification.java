package careerhabr.api.spec;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static careerhabr.helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;


public class Specification {
    public static RequestSpecification requestSpec = with()
            .log().uri()
            .log().method()
            .log().body()
            .filter(withCustomTemplates())
            .contentType(ContentType.JSON);

    public static ResponseSpecification getVacanciesListWithStatusCode200 = new ResponseSpecBuilder()
            .log(LogDetail.STATUS)
            .expectStatusCode(200)
            .build();
}
