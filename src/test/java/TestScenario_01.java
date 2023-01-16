import io.restassured.http.ContentType;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestScenario_01 {
    //Arrange
    //Act
    //Assert
    @Test
    public void getUserList() {

        given()
                .header("app-id", "63c4ff107cc57e330fe64382")
                .contentType(ContentType.JSON)
        .when()
                .get("https://dummyapi.io/data/v1/user?limit=10")
        .then()
                .statusCode(200)
                .log().body()
                .body("data", Matchers.hasSize(10));
    }

    @Test
    public void createUser(){

        given()
                .header("app-id", "63c4ff107cc57e330fe64382")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"firstName\" : \"Mayur\",\n" +
                        "    \"lastName\" : \"Kumar\",\n" +
                        "    \"email\" : \"MayurKrms@marvello.com\" \n" +
                        "    }")
        .when()
                .post("https://dummyapi.io/data/v1/user/create")
        .then()
                .log().body()
                .statusCode(200)
                .body("id", Matchers.notNullValue())
                .body("email", Matchers.equalToIgnoringCase("MayurKrms@marvello.com"));


    }

}
