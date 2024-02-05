package com.example.salsadwiyanti

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private lateinit var imgCrud : ImageView
    private lateinit var Calc : ImageView
    private lateinit var Camer : ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgCrud = findViewById(R.id.img_crud)
        Calc = findViewById(R.id.img_calc)
        Camer = findViewById(R.id.img_camera)

        imgCrud.setOnClickListener{
            val intent = Intent(this,RoomActivity::class.java)
            startActivity(intent)
        }
        Calc.setOnClickListener{
            val intent = Intent(this,CalculatorActivity::class.java)
            startActivity(intent)
        }
        Camer.setOnClickListener{
            val intent = Intent(this,BrightnessActivity::class.java)
            startActivity(intent)
        }
    }

}