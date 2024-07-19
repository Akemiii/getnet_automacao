package steps;

import base.ProjectSettings;
import org.junit.Assert;

import static base.RequestManager.shared;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class CommonSteps {

    @Entao("deve retornar o status code {int}")
    public void deveRetornarOStatusCode(final int statusCode) {
        shared().getResponse().then().statusCode(statusCode);
    }

    @Entao("valido que o campo {string} retornou {string}")
    public void validoQueOCampoRetornou(final String field, final String value) {
        Assert.assertEquals(value, shared().getResponse().jsonPath().get(field).toString());
    }

    @E("valido o contrato {string}")
    public void validoOContrato(String path) {
        shared().getResponse().then()
                .body(matchesJsonSchemaInClasspath(ProjectSettings.API_CONTRACT_PATH + path));
    }

}
