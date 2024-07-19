package service;

import base.RequestManager;
import io.restassured.response.Response;
import org.json.JSONObject;

public class UserService extends BaseService{

    private static final String CREATE_USER_ENDPOINT = "/api/users";

    public UserService(){
        RequestManager.shared().setBaseURI(REQRES_URI);
    }

    public Response PostCreateUser(JSONObject payloadJson) {
        return doPostRequestWithPayload(payloadJson.toString(), CREATE_USER_ENDPOINT);
    }
}
