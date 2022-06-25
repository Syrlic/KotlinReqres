package reqres

enum class Constants (val endpoint: String){
    BASE_URI("https://reqres.in"),
    USERS("/api/users"),
    REGISTER("/api/register"),
    RESOURCE("/api/unknown")
}