package com.example.salsadwiyanti

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CalculatorActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var editbil1: EditText
    private lateinit var editbil2: EditText
    private lateinit var hasil: TextView
    private lateinit var btnTambah: Button
    private lateinit var btnKurang: Button
    private lateinit var btnKali: Button
    private lateinit var btnBagi: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        editbil1 = findViewById(R.id.edt_bil1)
        editbil2 = findViewById(R.id.edt_bil2)
        hasil = findViewById(R.id.result)
        btnTambah = findViewById(R.id.tambah)
        btnKurang = findViewById(R.id.kurang)
        btnKali = findViewById(R.id.kali)
        btnBagi = findViewById(R.id.bagi)

        btnTambah.setOnClickListener(this)
        btnKurang.setOnClickListener(this)
        btnKali.setOnClickListener(this)
        btnBagi.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tambah -> hitung('+')
            R.id.kurang -> hitung('-')
            R.id.kali -> hitung('*')
            R.id.bagi -> hitung('/')
        }
    }

    private fun hitung(operator: Char) {
        val inputBilangan1 = editbil1.text.toString().trim()
        val inputBilangan2 = editbil2.text.toString().trim()

        var isEmptyFields = false
        var isInvalidDouble = false

        if (TextUtils.isEmpty(inputBilangan1)) {
            isEmptyFields = true
            editbil1.error = "Kolom ini tidak boleh kosong"
        }

        if (TextUtils.isEmpty(inputBilangan2)) {
            isEmptyFields = true
            editbil2.error = "Kolom ini tidak boleh kosong"
        }

        val bilangan1 = toDouble(inputBilangan1)
        val bilangan2 = toDouble(inputBilangan2)

        if (bilangan1 == null) {
            isInvalidDouble = true
            editbil1.error = "Bilangan yang anda masukkan harus angka valid"
        }

        if (bilangan2 == null) {
            isInvalidDouble = true
            editbil2.error = "Bilangan yang anda masukkan harus angka valid"
        }

        if (!isEmptyFields && !isInvalidDouble) {
            var hasilOperasi = 0.0

            when (operator) {
                '+' -> hasilOperasi = bilangan1!! + bilangan2!!
                '-' -> hasilOperasi = bilangan1!! - bilangan2!!
                '*' -> hasilOperasi = bilangan1!! * bilangan2!!
                '/' -> {
                    if (bilangan2 != 0.0) {
                        hasilOperasi = bilangan1!! / bilangan2!!
                    } else {
                        editbil2.error = "Bilangan kedua tidak boleh nol"
                        return
                    }
                }
            }

            hasil.text = hasilOperasi.toString()
        }
    }

    private fun toDouble(str: String): Double? {
        return try {
            str.toDouble()
        } catch (e: NumberFormatException) {
            null
        }
    }
}
