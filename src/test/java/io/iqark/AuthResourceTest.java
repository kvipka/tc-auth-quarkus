package io.iqark;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class AuthResourceTest {

    @Test
    public void testGetAccountEndpoint() {
        given()
          .when().get("/auth/getAccount/1")
          .then()
             .statusCode(200);
    }

    @Test
    public void testVerifyAccountEndpoint() {
        given()
                .when().post("/auth/verifyAccount")
                .then()
                .statusCode(415);
    }

    @Test
    public void testCreateAccountEndpoint() {
        given()
                .when().post("/auth/createAccount")
                .then()
                .statusCode(415);
    }

}