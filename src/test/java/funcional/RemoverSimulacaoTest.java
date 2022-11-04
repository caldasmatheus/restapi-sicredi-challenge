package funcional;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.apache.http.HttpStatus.*;
import static org.hamcrest.Matchers.equalTo;
import static spec.RequestSpecification.getSpec;

public class RemoverSimulacaoTest {

    @Test
    public void removerSimulacaoExistente() {
        given().
            spec(getSpec()).
        when().
            delete("restricoes/12").
        then().
            statusCode(SC_NO_CONTENT);
    }

    @Test
    public void removerSimulacaoInexistente() {
        given().
            spec(getSpec()).
        when().
            delete("restricoes/1000").
        then().
            statusCode(SC_NOT_FOUND).
            body("mensagem", equalTo("Simulação não encontrada"));
    }

}