package reqres

object TestData {

    fun getBody(data: String): Map<String, String> = when (data) {
        "regSuccess" -> mapOf("email" to "eve.holt@reqres.in", "password" to "pistol")
        "regUnsuccess" -> mapOf("email" to "sydney@fife")
        "update" -> mapOf("name" to "morpheus", "job" to "zion resident")
        else -> mapOf()

    }

    fun getValidationData(data: String): String = when (data) {
        "regSuccess" -> "{\"id\":4,\"token\":\"QpwL5tke4Pnpja7X4\"}"
        "regUnsuccess" -> "{\"error\":\"Missing password\"}"
        "update" -> "\"name\":\"morpheus\",\"job\":\"zion resident\",\"updatedAt\":"
        "singleResource" -> "\"id\":2,\"name\":\"fuchsia rose\""
        "listOfResources" -> "\"page\":2,\"per_page\":6,\"total\":12,\"total_pages\":2,\"data\":"
        "listOfResourcesStart" -> "\"id\":7,\"name\":\"sand dollar\""
        "listOfResourcesEnd" -> "\"id\":12,\"name\":\"honeysuckle\""
        "singleUser" -> "\"id\":3,\"email\":\"emma.wong@reqres.in\",\"first_name\":\"Emma\""
        "listOfUsers" -> "\"page\":1,\"per_page\":6,\"total\":12,\"total_pages\":2"
        "listOfUsersStart" -> "[{\"id\":1,\"email\":\"george.bluth@reqres.in\""
        "listOfUsersEnd" -> "{\"id\":6,\"email\":\"tracey.ramos@reqres.in\","
        else -> ""

    }

}
