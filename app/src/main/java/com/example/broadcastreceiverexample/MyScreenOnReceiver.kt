package com.example.broadcastreceiverexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class MyScreenOnReceiver : BroadcastReceiver() {
    var offCounter = 0
    var onCounter = 0

    override fun onReceive(context: Context, intent: Intent) {

        if(intent.action == Intent.ACTION_SCREEN_OFF){
            offCounter++
        }
        else if(intent.action == Intent.ACTION_SCREEN_ON){
            onCounter++
        }
    }
}
