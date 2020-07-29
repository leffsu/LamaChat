package su.leff.database.entity.user

class UserRepository(private val dao: UserDAO) {

    suspend fun insertUser(user: UserEntity) {
        dao.insertUser(user)
    }

    suspend fun fetchAllUsers(): List<UserEntity> {
        return dao.fetchAllUsers()
    }

    suspend fun getUser(userGUID: String): UserEntity {
        return dao.getUser(userGUID)
    }

    suspend fun updateUser(user: UserEntity) {
        return dao.updateUser(user)
    }

    suspend fun deleteUser(user: UserEntity) {
        return dao.deleteUser(user)
    }
}