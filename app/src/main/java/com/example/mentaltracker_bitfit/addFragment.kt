package com.example.codepath_bitfit_fragments

import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.codepath_bitfit.R
import com.example.mentaltracker_bitfit.DailyEntryApplication
import com.example.mentaltracker_bitfit.EntryEntitySchema
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.Slider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class EntryActivity : AppCompatActivity() {


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_add)

        //Slider
        val sliderNum = findViewById<Slider>(R.id.slider)

        //EditText
        val feelingText = findViewById<EditText>(R.id.whyFeelings).text

        //Buttons
        val postButton = findViewById<Button>(R.id.floatingActionButton)

        //Setting current date
        val textView: TextView = findViewById(R.id.dateTextView)
        val simpleDateFormat = SimpleDateFormat("MM.dd.yyyy")
        val currentDate = simpleDateFormat.format(Date())
        currentDate.also { textView.text = it }

        //Getting slider value
        sliderNum.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) {
                // Responds to when slider's touch event is being started
            }

            override fun onStopTrackingTouch(slider: Slider) {
                // Responds to when slider's touch event is being stopped

            }
        })

        //Handling post click event
        postButton.setOnClickListener {
            Toast.makeText(applicationContext, feelingText, Toast.LENGTH_SHORT).show()

            // TODO Save event to database
            lifecycleScope.launch(Dispatchers.IO) {
                (application as DailyEntryApplication).db.entryDao().addEntry(
                    EntryEntitySchema(
                        currentDate,
                        sliderNum.value.toString(),
                        feelingText.toString()
                    )
                )

            }
            // Empty text fields
            findViewById<EditText>(R.id.whyFeelings).setText("")
        }

    }
}