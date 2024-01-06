package com.example.broadcastreceiverexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyScreenOnReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val toast = Toast.makeText(context, "Locale changed", Toast.LENGTH_SHORT)
        toast.show()
    }
}
