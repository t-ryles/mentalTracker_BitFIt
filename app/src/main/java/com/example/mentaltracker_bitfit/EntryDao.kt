package com.example.mentaltracker_bitfit

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EntryDao {

    @Insert
    fun addEntry(entry: EntryEntitySchema)

    @Query("Select * FROM mental_data")
    fun readAllEntries() : LiveData<List<EntryEntitySchema>>


}