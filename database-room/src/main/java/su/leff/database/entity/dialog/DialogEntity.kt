package su.leff.database.entity.dialog

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import su.leff.database.CalendarConverter
import java.util.*

@Entity(tableName = "dialog")
data class DialogEntity(
    @PrimaryKey val dialogGUID: String,
    val name: String,
    val isGroup: Boolean
)