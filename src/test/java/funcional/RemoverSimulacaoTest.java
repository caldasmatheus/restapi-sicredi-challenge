package funcional;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.Matchers.equalTo;

public class RemoverSimulacaoTest {

    @Test
    public void removerSimulacaoExistente() {
        given().
            baseUri("http://localhost:8080/api").
            basePath("/v1").
        when().
            delete("restricoes/12").
        then().
            statusCode(SC_NO_CONTENT);
    }

    @Test
    public void removerSimulacaoInexistente() {
        given().
            baseUri("http://localhost:8080/api").
            basePath("/v1").
        when().
            delete("restricoes/1000").
        then().
            statusCode(SC_NOT_FOUND).
            body("mensagem", equalTo("Simulação não encontrada"));
    }

}
