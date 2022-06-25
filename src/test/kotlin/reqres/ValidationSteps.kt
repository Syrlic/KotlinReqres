package reqres

import io.qameta.allure.Step
import khttp.responses.Response
import org.junit.jupiter.api.Assertions

object ValidationSteps {
    @Step("Verify status code {expectedStatusCode}")
    fun verifyStatusCode(response: Response, expectedStatusCode: Int) {
        Assertions.assertEquals(expectedStatusCode, response.statusCode)
    }

    @Step("Verify response body contains following string {validationString}")
    fun verifyResponseHasValidStringInside(response: Response, validationString: String) {
        Assertions.assertTrue(response.text.contains(validationString))
    }

    @Step("Verify response body is empty")
    fun verifyResponseHasNoBody(response: Response) {
        Assertions.assertTrue(response.text.isEmpty())
    }
}