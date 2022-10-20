package com.example.mentaltracker_bitfit

import android.app.Application

class DailyEntryApplication : Application() {
    val db by lazy { EntryDatabase.getInstance(this) }}