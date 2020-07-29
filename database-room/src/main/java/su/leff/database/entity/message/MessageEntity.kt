package su.leff.database.entity.message

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import su.leff.database.CalendarConverter
import java.util.*

@Entity(tableName = "message")
data class MessageEntity(
    @PrimaryKey val messageGUID: String,
    val text: String,
    val userGUID: String
)