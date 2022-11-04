package funcional;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.apache.http.HttpStatus.SC_NO_CONTENT;
import static org.apache.http.HttpStatus.SC_OK;
import static spec.RequestSpecification.getSpec;

public class RestricoesTest {

    @Test(dataProvider = "cpfComRestricao")
    public void consultarCPFSemRestricao(String cpfSemRestricao) {
        given().
            spec(getSpec()).
        when().
            get("restricoes/" + cpfSemRestricao).
        then().
        statusCode(SC_NO_CONTENT);
    }

    @Test(dataProvider = "cpfComRestricao")
    public void consultarCPFComRestricao(String cpfComRestricao) {
        given().
            spec(getSpec()).
        when().
            get("restricoes/" + cpfComRestricao).
        then().
            statusCode(SC_OK).
            body("mensagem", equalTo("O CPF " + cpfComRestricao+ " possui restrição"));
    }

    @DataProvider
    public static Object[][] cpfSemRestricao () {
        return new Object[][] {
                {"82298593027"},
                {"90144356066"},
                {"63160005020"},
                {"38850527098"},
                {"99972070093"},
                {"78545080034"},
                {"11130967050"},
                {"33336081033"},
                {"34511195013"},
                {"17070263007"}
        };
    }

    @DataProvider
    public static Object[][] cpfComRestricao () {
        return new Object[][] {
                {"97093236014"},
                {"60094146012"},
                {"84809766080"},
                {"62648716050"},
                {"26276298085"},
                {"01317496094"},
                {"55856777050"},
                {"19626829001"},
                {"24094592008"},
                {"58063164083"}
        };
    }

}
