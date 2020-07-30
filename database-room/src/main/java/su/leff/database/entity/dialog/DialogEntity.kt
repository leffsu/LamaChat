package su.leff.database.entity.dialog

import androidx.room.Entity
import androidx.room.PrimaryKey
import su.leff.core.domain.Dialog

@Entity(tableName = "dialog")
class DialogEntity(
    @PrimaryKey val dialogGUID: String,
    val name: String,
    val isGroup: Boolean
) {
    fun toDialog(dialogEntity: DialogEntity): Dialog {
        return Dialog(dialogGUID, name, isGroup)
    }
}