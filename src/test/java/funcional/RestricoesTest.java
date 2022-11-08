package funcional;

import dataprovider.RestricoesDataProvider;
import org.testng.annotations.Test;
import util.TestRule;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.apache.http.HttpStatus.SC_NO_CONTENT;
import static org.apache.http.HttpStatus.SC_OK;
import static spec.RequestSpecification.getSpec;

public class RestricoesTest extends TestRule {

    @Test(dataProvider = "cpfComRestricao", dataProviderClass = RestricoesDataProvider.class)
    public void consultarCPFSemRestricao(String cpfSemRestricao) {
        given().
            spec(getSpec()).
        when().
            get("restricoes/" + cpfSemRestricao).
        then().
        statusCode(SC_NO_CONTENT);
    }

    @Test(dataProvider = "cpfComRestricao", dataProviderClass = RestricoesDataProvider.class)
    public void consultarCPFComRestricao(String cpfComRestricao) {
        given().
            spec(getSpec()).
        when().
            get("restricoes/" + cpfComRestricao).
        then().
            statusCode(SC_OK).
            body("mensagem", equalTo("O CPF " + cpfComRestricao+ " possui restrição"));
    }

}
