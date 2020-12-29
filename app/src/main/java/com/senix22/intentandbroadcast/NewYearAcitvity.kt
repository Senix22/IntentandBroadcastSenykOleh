package com.senix22.intentandbroadcast

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_new_year_acitvity.*

class NewYearAcitvity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_year_acitvity)

        val newInt=  intent.getIntExtra("YearKeyInt",0).toString()
        val newString = intent.getStringExtra("YearKey")
        newYearText.setText("$newString  $newInt")
    }
}