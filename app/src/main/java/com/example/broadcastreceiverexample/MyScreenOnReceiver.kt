package com.example.broadcastreceiverexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.widget.Toast


class MyScreenOnReceiver : BroadcastReceiver() {
    var offCounter = 0
    var onCounter = 0

    override fun onReceive(context: Context, intent: Intent) {

        val result = goAsync()
        val thread: Thread = object : Thread() {
            override fun run() {
                //Emulate some work
                sleep(7000)

                if(intent.action == Intent.ACTION_SCREEN_OFF){
                    offCounter++
                }
                else if(intent.action == Intent.ACTION_SCREEN_ON){
                    onCounter++
                }
                //Need to move UI update back to main thread
                val handler = Handler(context.mainLooper)
                handler.post {
                    MainActivity.updateCounters()
                }

                result.resultCode = offCounter+onCounter
                result.finish()
            }
        }
        thread.start()
    }
}
