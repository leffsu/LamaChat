package su.leff.network

interface Network {
    fun signIn(email: String, password: String)
    fun signUp(username: String, email: String, password: String)


}