package com.example.salsadwiyanti

import android.os.Bundle
import android.view.WindowManager
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BrightnessActivity : AppCompatActivity() {

    private lateinit var seekBar: SeekBar
    private lateinit var textView: TextView
    private var backLightValue: Float = 0.5f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_brightness)

        seekBar = findViewById(R.id.brightnessControl)
        textView = findViewById(R.id.brightnessValue)

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                backLightValue = progress.toFloat() / 100
                textView.text = backLightValue.toString()
                updateScreenBrightness()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Tidak perlu implementasi khusus di sini
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Tidak perlu implementasi khusus di sini
            }
        })
    }

    private fun updateScreenBrightness() {
        val layoutParams = window.attributes
        layoutParams.screenBrightness = backLightValue
        window.attributes = layoutParams
    }
}
