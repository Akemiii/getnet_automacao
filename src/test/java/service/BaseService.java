package service;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static base.RequestManager.shared;
import static io.restassured.RestAssured.given;

public class BaseService {
    protected static final String REQRES_URI = "https://reqres.in";

    public Response doPostRequestWithPayload(String payloadJson, String resource) {
        return given()
                .spec(shared()
                        .getRequest())
                .contentType(ContentType.JSON)
                .body(payloadJson)
                .when()
                .post(resource);
    }

}
