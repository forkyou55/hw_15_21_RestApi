package specs;

import api.AuthorizationApi;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import static api.AuthorizationApi.ALLURE_TESTOPS_SESSION;
import static helpers.CustomApiListener.withCustomTemplates;
import static tests.TestBase.testOpsConfig;

public class LoginSpecs {

    public final static String username = testOpsConfig.username();
    public final static String password = testOpsConfig.password();
    public final static String token = testOpsConfig.token();

    public static RequestSpecification getRequestSpec() {

        AuthorizationApi authorizationApi = new AuthorizationApi();
        String xsrfToken = authorizationApi.getXsrfToken(token);
        String authorizationCookie = authorizationApi
                .getAuthorizationCookie(token, username, password);

        return RestAssured
                .given()
                .log().all()
                .filter(withCustomTemplates())
                .header("X-XSRF-TOKEN", xsrfToken)
                .cookies("XSRF-TOKEN", xsrfToken,
                        ALLURE_TESTOPS_SESSION, authorizationCookie)
                .contentType(ContentType.JSON);

    }

}
