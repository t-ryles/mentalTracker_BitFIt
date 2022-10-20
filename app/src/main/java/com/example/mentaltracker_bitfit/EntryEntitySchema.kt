package com.example.mentaltracker_bitfit

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mental_data")
data class EntryEntitySchema (
    @ColumnInfo(name = "date")val dateEntrySchema: String?,
    @ColumnInfo(name = "emotionalScale")val scaleEntrySchema: String?,
    @ColumnInfo(name = "emotionalNotes")val noteEntrySchema: String?,
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    )