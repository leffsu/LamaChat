package su.leff.database.entity.user

class UserRepository(private val dao: UserDAO) {

    suspend fun insertUser(user: User) {
        dao.insertUser(user)
    }

    suspend fun fetchAllUsers(): List<User> {
        return dao.fetchAllUsers()
    }

    suspend fun getUser(userGUID: String): User {
        return dao.getUser(userGUID)
    }

    suspend fun updateUser(user: User) {
        return dao.updateUser(user)
    }

    suspend fun deleteUser(user: User) {
        return dao.deleteUser(user)
    }
}