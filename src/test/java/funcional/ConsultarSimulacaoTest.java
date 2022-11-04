package funcional;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.SC_NO_CONTENT;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.*;

public class ConsultarSimulacaoTest {

    @Test
    public void consultarSimulacoes() {
        given().
            baseUri("http://localhost:8080/api").
            basePath("/v1").
        when().
            get("simulacoes").
        then().
            statusCode(SC_OK).
            body("[0]", hasKey("nome")).
            body("[0]", hasKey("cpf")).
            body("[0]", hasKey("email")).
            body("[0]", hasKey("valor")).
            body("[0]", hasKey("parcelas")).
            body("[0]", hasKey("seguro"));
    }

}
