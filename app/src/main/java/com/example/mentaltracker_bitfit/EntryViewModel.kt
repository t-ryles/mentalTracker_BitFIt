package com.example.mentaltracker_bitfit

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EntryViewModel (application: Application): AndroidViewModel ( application) {

    private val readAllEntries : LiveData<List<EntryEntitySchema>>
    private val repository : EntryRepository

    init {
        val entryDao = EntryDatabase.getInstance(application).entryDao()
        repository = EntryRepository(entryDao)
        readAllEntries = repository.readAllData
    }

    fun addEntry (entry: EntryEntitySchema) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addEntry(entry)

        }
    }
}