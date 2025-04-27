package com.example.seekbar

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.RangeSlider

class MainActivity : AppCompatActivity() {
    private lateinit var rangeSlider: RangeSlider
    private lateinit var tvMuteDuration: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rangeSlider = findViewById(R.id.rangeSlider)
        tvMuteDuration = findViewById(R.id.tvMuteDuration)

        rangeSlider.addOnChangeListener { slider, _, _ ->
            val values = slider.values
            val startMinutes = values[0].toInt()
            val endMinutes = values[1].toInt()

            val startHours = startMinutes / 60
            val startMins = startMinutes % 60

            val endHours = endMinutes / 60
            val endMins = endMinutes % 60

            tvMuteDuration.text = "🔇 From ${startHours}h ${startMins}m to ${endHours}h ${endMins}m"
        }
    }
}