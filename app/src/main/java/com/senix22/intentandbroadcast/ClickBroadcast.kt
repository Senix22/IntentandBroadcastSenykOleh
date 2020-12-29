package com.senix22.intentandbroadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class ClickBroadcast : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        Toast.makeText(context, "ClickBroadcast - user tap on button", Toast.LENGTH_SHORT).show()
    }
}
