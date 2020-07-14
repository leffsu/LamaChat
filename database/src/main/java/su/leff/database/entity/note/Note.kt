package su.leff.database.entity.note

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import su.leff.database.CalendarConverter
import java.util.*

@Entity(tableName = "note")
data class Note(
    @PrimaryKey val noteGUID: String,
    val text: String,
    @TypeConverters(CalendarConverter::class)
    val date: Calendar
)