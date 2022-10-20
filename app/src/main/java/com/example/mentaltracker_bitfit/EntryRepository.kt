package com.example.mentaltracker_bitfit

import androidx.lifecycle.LiveData

class EntryRepository(private val entryDao: EntryDao) {
    val readAllData : LiveData<List<EntryEntitySchema>> = entryDao.readAllEntries()

    fun addEntry (entry: EntryEntitySchema){
        entryDao.addEntry(entry)
    }
}