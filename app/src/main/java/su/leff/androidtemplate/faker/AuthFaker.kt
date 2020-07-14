package su.leff.androidtemplate.faker

object AuthFaker {

    val username = "leff@leff.su"
    val password = "abrakadabra00P"

    fun login(login: String, password: String): Boolean {
        return login == username && password == this.password
    }
}