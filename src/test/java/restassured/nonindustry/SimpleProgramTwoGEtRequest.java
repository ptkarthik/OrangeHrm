package restassured.nonindustry;

import configuration.PropLoaderForRestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;
import org.testng.internal.Configuration;

import java.util.Properties;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;

public class SimpleProgramTwoGEtRequest {

    @Test
    public void simpleProgramOne() {
        Properties pr=PropLoaderForRestAssured.loadPropertyForApi();
        Response response = given().baseUri(pr.getProperty("baseUri")).log().all().
                when().log().all().get(pr.getProperty("endpoint")).then().
                statusCode(200).log().body().extract().response();
        JsonPath jsonPath = response.jsonPath();
        MatcherAssert.assertThat(jsonPath.get("status"), is(equalTo("success")));
    }
}