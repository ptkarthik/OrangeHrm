package restassured.nonindustry;

import configuration.PropLoaderForRestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import java.util.Properties;
import java.util.logging.Logger;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.is;

public class SimpleProgramXMLValidation {

    @Test
    public void simpleProgramOne() {
        Properties pr=PropLoaderForRestAssured.loadPropertyForApi();
        String response = given().baseUri(pr.getProperty("baseUri")).log().all().
                contentType(pr.getProperty("header")).log().all().
                when().log().all().post(pr.getProperty("endpoint")).then().
                statusCode(200).log().body().extract().asString();
        XmlPath xmlPath= new XmlPath(response);
        MatcherAssert.assertThat(xmlPath.get("store.book[0].author"),equalTo("Nigel Rees"));
//        JsonPath jsonPath = response.jsonPath();
//        MatcherAssert.assertThat(jsonPath.get("status"), is(equalTo("success")));
    }
}