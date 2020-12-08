package com.github.cesar1287.desafiopicpayandroid.tmdb.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.github.cesar1287.desafiopicpayandroid.model.Movie
import com.github.cesar1287.desafiopicpayandroid.tmdb.model.Result

object TmdbDatabase {

//    private val MIGRATION_1_2 = object : Migration(1, 2) {
//        override fun migrate(database: SupportSQLiteDatabase) {
//            database.execSQL("CREATE TABLE `Fruit` (`id` INTEGER, `name` TEXT, " +
//                    "PRIMARY KEY(`id`))")
//        }
//    }
//
//    private val MIGRATION_2_3 = object : Migration(2, 3) {
//        override fun migrate(database: SupportSQLiteDatabase) {
//            database.execSQL("ALTER TABLE movies ADD COLUMN streaming TEXT")
//        }
//    }
//
//    private val MIGRATION_3_4 = object : Migration(3, 4) {
//        override fun migrate(database: SupportSQLiteDatabase) {
//            database.execSQL("DROP TABLE `Fruit`")
//        }
//    }

    @Database(entities = [Result::class, Movie::class], version = 1, exportSchema = false)
    abstract class TmdbRoomDatabase : RoomDatabase() {
        abstract fun movieDao(): MovieDao
        abstract fun resultDao(): ResultDao
    }

    fun getDatabase(context: Context): TmdbRoomDatabase {
        return Room.databaseBuilder(
            context,
            TmdbRoomDatabase::class.java,
            "tmdb_db"
        ).build()
    }
}