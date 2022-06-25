package reqres

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import reqres.ValidationSteps.verifyResponseHasNoBody
import reqres.ValidationSteps.verifyResponseHasValidStringInside
import reqres.ValidationSteps.verifyStatusCode

class MainKtTest {
    @Test
    @DisplayName("Get List of Users")
    fun getListOfUsers() {
        val response = APISteps.getItemRequest(Constants.USERS.endpoint, null)
        verifyStatusCode(response, 200)
        verifyResponseHasValidStringInside(response, TestData.getValidationData("listOfUsers"))
        verifyResponseHasValidStringInside(response, TestData.getValidationData("listOfUsersStart"))
        verifyResponseHasValidStringInside(response, TestData.getValidationData("listOfUsersEnd"))
    }

    @Test
    @DisplayName("Get Single User")
    fun getSingleUser() {
        val response = APISteps.getItemRequest(Constants.USERS.endpoint, "/3")
        verifyStatusCode(response, 200);
        verifyResponseHasValidStringInside(response, TestData.getValidationData("singleUser"))
    }

    @Test
    @DisplayName("Single User not found")
    fun getSingleUserNotFound() {
        val response = APISteps.getItemRequest(Constants.USERS.endpoint, "/23")
        verifyStatusCode(response, 404)
        verifyResponseHasValidStringInside(response, TestData.getValidationData(""))
    }

    @Test
    @DisplayName("Get List of Resources")
    fun getListOfResources() {
        val response = APISteps.getRequestWithParameters(Constants.RESOURCE.endpoint, "2")
        verifyStatusCode(response, 200)
        verifyResponseHasValidStringInside(response, TestData.getValidationData("listOfResources"))
        verifyResponseHasValidStringInside(response, TestData.getValidationData("listOfResourcesStart"))
        verifyResponseHasValidStringInside(response, TestData.getValidationData("listOfResourcesEnd"))
    }

    @Test
    @DisplayName("Get Single Resource")
    fun getSingleResource() {
        val response = APISteps.getItemRequest(Constants.RESOURCE.endpoint, "2")
        verifyStatusCode(response, 200)
        verifyResponseHasValidStringInside(response, TestData.getValidationData("singleResource"))
    }

    @Test
    @DisplayName("Single Resource not found")
    fun getSingleResourceNotFound() {
        val response = APISteps.getItemRequest(Constants.RESOURCE.endpoint, "/23")
        verifyStatusCode(response, 404)
        verifyResponseHasValidStringInside(response, "")
    }

    @Test
    @DisplayName("Successful register")
    fun registerSuccessful() {
        var body = TestData.getBody("regSuccess")
        val response = APISteps.postRequestWithJsonBody(Constants.REGISTER.endpoint, body)
        verifyResponseHasValidStringInside(response, TestData.getValidationData("regSuccess"))
    }

    @Test
    @DisplayName("Unsuccessful register")
    fun registerUnsuccessful() {
        var body = TestData.getBody("regUnsuccess")
        val response = APISteps.postRequestWithJsonBody(Constants.REGISTER.endpoint, body)
        verifyStatusCode(response, 400);
        verifyResponseHasValidStringInside(response, TestData.getValidationData("regUnsuccess"))
    }

    @Test
    @DisplayName("Update User with PUT method")
    fun updateUserWithPUTMethod() {
        var body = TestData.getBody("update")
        val response = APISteps.putRequestToCertainAddress(Constants.USERS.endpoint, "/2", body);
        verifyStatusCode(response, 200);
        verifyResponseHasValidStringInside(response, TestData.getValidationData("update"));
    }

    @Test
    @DisplayName("Update User with PATCH Method")
    fun updateUserWithPATCHMethod() {
        var body = TestData.getBody("update")
        val response = APISteps.patchRequestToCertainAddress(Constants.USERS.endpoint, "/2", body);
        verifyStatusCode(response, 200);
        verifyResponseHasValidStringInside(response, TestData.getValidationData("update"));
    }

    @Test
    @DisplayName("Delete User")
    fun deleteSomeUser() {
        val response = APISteps.deleteRequestToCertainAddress(Constants.USERS.endpoint, "/2");
        verifyStatusCode(response, 204);
        verifyResponseHasNoBody(response);
    }

}