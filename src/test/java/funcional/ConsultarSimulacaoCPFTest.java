package funcional;

import org.testng.annotations.Test;
import util.TestRule;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasKey;
import static spec.RequestSpecification.getSpec;

public class ConsultarSimulacaoCPFTest extends TestRule {

    @Test
    public void consultarSimulacaoCPFValido() {
        String cpf = "66414919004";
        given().
            spec(getSpec()).
        when().
            get("simulacoes/" + cpf).
        then().
            statusCode(SC_OK).
            body("$", hasKey("nome")).
            body("$", hasKey("cpf")).
            body("$", hasKey("email")).
            body("$", hasKey("valor")).
            body("$", hasKey("parcelas")).
            body("$", hasKey("seguro"));
    }

    @Test
    public void consultarSimulacaoCPFInexistente() {
        String cpf = "12109723440";
        given().
            spec(getSpec()).
        when().
            get("simulacoes/" + cpf).
        then().
            statusCode(SC_NOT_FOUND).
            body("mensagem", equalTo("CPF " + cpf +" não encontrado"));
    }

}
