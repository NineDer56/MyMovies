package com.example.mymovies.data.room

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MovieItemDbModel::class], version = 1)
abstract class MovieItemDatabase : RoomDatabase() {

    abstract fun movieDao() : MovieItemDao

    companion object {

        private var instance: MovieItemDatabase? = null
        private val LOCK = Any()

        fun getInstance(application: Application): MovieItemDatabase {

            // Добавление проверки перед синхронизацией способствует лучшей производительности
            instance?.let {
                return it
            }

            synchronized(LOCK) {
                instance?.let {
                    return it
                }

                val db = Room.databaseBuilder(
                    application,
                    MovieItemDatabase::class.java,
                    "movies.db"
                ).build()
                instance = db

                return db
            }
        }
    }
}