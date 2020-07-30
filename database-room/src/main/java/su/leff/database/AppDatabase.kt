package su.leff.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import su.leff.database.Constants.DATABASE_NAME
import su.leff.database.entity.dialog.DialogEntity
import su.leff.database.entity.dialog.DialogEntityDAO
import su.leff.database.entity.dialogmembership.DialogMembershipEntity
import su.leff.database.entity.dialogmembership.DialogMembershipEntityDAO
import su.leff.database.entity.message.MessageEntity
import su.leff.database.entity.message.MessageEntityDAO
import su.leff.database.entity.note.NoteEntity
import su.leff.database.entity.note.NoteEntityDAO
import su.leff.database.entity.user.UserEntity
import su.leff.database.entity.user.UserEntityDAO
import java.util.concurrent.Executors

@Database(
    entities = [
        NoteEntity::class,
        DialogEntity::class,
        DialogMembershipEntity::class,
        MessageEntity::class,
        UserEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(CalendarConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun noteDAO(): NoteEntityDAO

    abstract fun messageDAO(): MessageEntityDAO

    abstract fun dialogDAO(): DialogEntityDAO

    abstract fun dialogMembershaipDAO(): DialogMembershipEntityDAO

    abstract fun userDAO(): UserEntityDAO

    companion object {

        // For Singleton instantiation
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                instance
                    ?: buildDatabase(
                        context
                    )
                        .also { instance = it }
            }
        }

        // Create and pre-populate the database. See this article for more details:
        // https://medium.com/google-developers/7-pro-tips-for-room-fbadea4bfbd1#4785
        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .allowMainThreadQueries()
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        Executors.newSingleThreadScheduledExecutor().execute(Runnable {
                            // add prepopulated entities here
                        })
                    }
                })
                .build()
        }
    }
}