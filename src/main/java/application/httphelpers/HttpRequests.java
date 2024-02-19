package application.httphelpers;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static org.assertj.core.api.Assertions.assertThat;

public class HttpRequests {

    @Step("Отправляет http запрос с методом HEAD и проверяем код отета")
    public static void sendRequestWithHeadMethodAndCheckStatusCode(String link, int expectedStatusCode) {

        Response response = RestAssured.given()
                .relaxedHTTPSValidation()
                .head(link);

        checkStatusCodeFromResponse(response, expectedStatusCode);
    }

    private static void checkStatusCodeFromResponse(Response response, int expectedStatusCode) {
        assertThat(response.getStatusCode())
                .as("Код ответа не соответствует ожидаемому")
                .isEqualTo(expectedStatusCode);
    }
}
