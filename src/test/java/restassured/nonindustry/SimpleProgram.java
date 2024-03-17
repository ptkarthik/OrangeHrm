package restassured.nonindustry;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class SimpleProgram {

    @Test
    public void simpleProgramOne() {
      given().baseUri("https://rahulshettyacademy.com").queryParam("key","qaclick123").body("{\n" +
              "  \"location\": {\n" +
              "    \"lat\": -38.383494,\n" +
              "    \"lng\": 33.427362\n" +
              "  },\n" +
              "  \"accuracy\": 50,\n" +
              "  \"name\": \"Frontline house\",\n" +
              "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
              "  \"address\": \"29, side layout, cohen 09\",\n" +
              "  \"types\": [\n" +
              "    \"shoe park\",\n" +
              "    \"shop\"\n" +
              "  ],\n" +
              "  \"website\": \"http://google.com\",\n" +
              "  \"language\": \"French-IN\"\n" +
              "}").log().all().
              when().log().all().post("/maps/api/place/add/json").then().assertThat().statusCode(200).log().all();
    }


}
