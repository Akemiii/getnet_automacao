package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import org.json.JSONObject;
import service.UserService;

import static base.RequestManager.*;

public class CreateUserSteps {

    private final UserService userService;

    public CreateUserSteps(){
        userService = new UserService();
    }

    @Dado("que desejo criar usuario com name {string} e job {string}")
    public void queDesejoCriarUsuarioComNomeEJob(String name, String job) {
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("job", job);

        shared().setPayloadJson(payload);
    }

    @Quando("executo a requisicao para criar um usuario")
    public void executoARequisicaoParaCriarUmUsuario() {
        shared().setResponse(userService.PostCreateUser(shared().getPayloadJson()));
    }
}
