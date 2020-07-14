package su.leff.database.entity.dialogmembership

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import su.leff.database.CalendarConverter
import java.util.*

@Entity(tableName = "dialog")
data class DialogMembership(
    @PrimaryKey val dialogMembershipGUID: String,
    val dialogGUID: String,
    val userGUID: String,
    val role: Int
)