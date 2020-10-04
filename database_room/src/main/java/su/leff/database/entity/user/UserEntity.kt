package su.leff.database.entity.user

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import su.leff.database.CalendarConverter
import java.util.*

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey val userGUID: String,
    val username: String,
    val avatarUrl: String
)