package reqres

import io.qameta.allure.Step
import khttp.*
import khttp.responses.Response

object APISteps {
    @Step("GET request to {uri} of item {item}")
    fun getItemRequest(uri: String, item: String?): Response {
        val response = item?.let {get(Constants.BASE_URI.endpoint + uri + item)} ?: get(Constants.BASE_URI.endpoint + uri)
        return response
    }

    @Step("GET request to {uri} with parameters {param}")
    fun getRequestWithParameters(uri: String, param: String): Response {
        val response = get(
            url = Constants.BASE_URI.endpoint + uri,
            headers = mapOf(),
            params = mapOf("page" to param) )
        println(response.url)
        return response
    }

    @Step("PUT request to {uri} to a certain item {item} with Json body {json}")
    fun putRequestToCertainAddress(uri: String, item: String, json: Map<String,String>): Response {
        val response = put(
            url = Constants.BASE_URI.endpoint + uri + item,
            headers = mapOf("Content-Type" to "application/json"),
            params = mapOf(),
            data = null,
            json = json)
        return response
    }

    @Step("PATCH request to {uri} to a certain item {item} with Json body {json}")
    fun patchRequestToCertainAddress(uri: String, item: String, json: Map<String,String>): Response {
        val response = patch(
            url = Constants.BASE_URI.endpoint + uri + item,
            headers = mapOf("Content-Type" to "application/json"),
            params = mapOf(),
            data = null,
            json = json)
        return response
    }

    @Step("POST request to {uri} with a certain Json body {json}")
    fun postRequestWithJsonBody(uri: String, json: Map<String,String>): Response {
        val response = post(
            url = Constants.BASE_URI.endpoint + uri,
            headers = mapOf("Content-Type" to "application/json"),
            params = mapOf(),
            data = null,
            json = json)
        return response
    }

    @Step("DELETE request to {uri} with item {item} ")
    fun deleteRequestToCertainAddress(uri: String, item: String): Response {
        val response = delete(Constants.BASE_URI.endpoint + uri + item)
        return response
    }

}