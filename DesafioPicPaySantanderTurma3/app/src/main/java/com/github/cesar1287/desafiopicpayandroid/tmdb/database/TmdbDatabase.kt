package com.github.cesar1287.desafiopicpayandroid.tmdb.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.github.cesar1287.desafiopicpayandroid.tmdb.model.Result

object TmdbDatabase {

    @Database(entities = [Result::class], version = 1, exportSchema = false)
    abstract class TmdbRoomDatabase : RoomDatabase() {
        abstract fun movieDao(): MovieDao
    }

    fun getDatabase(context: Context): TmdbRoomDatabase {
        return Room.databaseBuilder(
            context,
            TmdbRoomDatabase::class.java,
            "tmdb_db"
        ).build()
    }
}