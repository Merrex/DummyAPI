import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestScenario_01 {
    //Arrange
    //Act
    //Assert
    @Test
    public void testCase_001() {

        given()
                .when()
                .get("https://dummyapi.io/data/v1/user?limit=10")
                .then()
                .statusCode(403)
                .log().body();

    }

}
