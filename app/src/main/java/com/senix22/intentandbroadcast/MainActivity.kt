package com.senix22.intentandbroadcast

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val connectionReceiver = ConnectionBroadcastReceiver()
    private val clickReceiver = ClickBroadcast()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startSendIntentButton.setOnClickListener {
            sendIntent()
        }
        openMapButton.setOnClickListener {
            openMaps()
        }
        clickBroadcast.setOnClickListener {
            sendBroadcast(Intent("startClick"))
        }
    }

    override fun onStart() {
        super.onStart()
        registerReceiver(connectionReceiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
        registerReceiver(clickReceiver, IntentFilter("startClick"))
    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(connectionReceiver)
        unregisterReceiver(clickReceiver)
    }

    private fun openMaps() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/%D0%9F%D0%BE%D0%B4%D0%B2%D0%BE%D0%BB%D0%BE%D1%87%D0%B8%D1%81%D0%BA,+%D0%A2%D0%B5%D1%80%D0%BD%D0%BE%D0%BF%D0%BE%D0%BB%D1%8C%D1%81%D0%BA%D0%B0%D1%8F+%D0%BE%D0%B1%D0%BB%D0%B0%D1%81%D1%82%D1%8C/@49.5272346,26.1176776,14z/data=!4m5!3m4!1s0x4731db44361901c9:0xfd8731941fafb2a0!8m2!3d49.5290848!4d26.1416979"))
        startActivity(intent)
    }

    private fun sendIntent() {
        val newYearString = "New Year"
        val newYearInt = 2021
        val intent = Intent(this, NewYearAcitvity::class.java)
        intent.putExtra("YearKey", newYearString)
        intent.putExtra("YearKeyInt", newYearInt)
        startActivity(intent)
    }

}