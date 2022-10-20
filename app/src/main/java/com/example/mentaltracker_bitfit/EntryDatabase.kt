package com.example.mentaltracker_bitfit

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [EntryEntitySchema::class], version = 1)
abstract class EntryDatabase : RoomDatabase() {

    abstract fun entryDao(): EntryDao


    companion object {
        @Volatile
        private var INSTANCE: EntryDatabase? = null


        fun getInstance(context: Context): EntryDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                EntryDatabase::class.java, "Entry-db"
            ).build()
    }
}