package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;
import lombok.Setter;
import org.json.JSONObject;

public class RequestManager {

    private static RequestManager sharedInstance;
    private RequestSpecification request;
    @Getter
    @Setter
    private Response response;
    @Getter
    @Setter
    private JSONObject payloadJson;

    private RequestManager() {

    }

    public static synchronized RequestManager shared() {
        if (sharedInstance == null) sharedInstance = new RequestManager();

        return sharedInstance;
    }

    public RequestSpecification getRequest() {
        if (request == null) request = new RequestSpecBuilder().build();

        return request;
    }

    public void setBaseURI(final String uri) {
        this.getRequest().baseUri(uri);
    }

    public void tearDownRequest() {
        this.request = null;
    }

    public void tearDownResponse() {
        this.response = null;
    }

}
