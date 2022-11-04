package spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

import static util.CommonUtils.retornarValorArquivoConfiguracao;

public class RequestSpecification {

    private static String BASEURI = retornarValorArquivoConfiguracao("baseUri");
    private static String BASEPATH = retornarValorArquivoConfiguracao("basePath");

    public static io.restassured.specification.RequestSpecification getSpec() {
        return new RequestSpecBuilder()
                .setConfig(
                        new RestAssuredConfig()
                                .sslConfig(
                                        new SSLConfig().relaxedHTTPSValidation()
                                )
                )
                .setContentType(ContentType.JSON)
                .setBaseUri(BASEURI)
                .setBasePath(BASEPATH)
                .log(LogDetail.ALL)
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

}
