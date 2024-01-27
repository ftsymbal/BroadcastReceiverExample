package com.example.broadcastreceiverexample

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

val receiver = MyScreenOnReceiver()
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.MyTextView)

        val filter = IntentFilter(Intent.ACTION_SCREEN_ON)
        filter.addAction(Intent.ACTION_SCREEN_OFF)

        registerReceiver(receiver, filter, RECEIVER_EXPORTED)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }
    override fun onResume() {
        super.onResume()
        updateCounters()
    }
    companion object {
        private lateinit var textView: TextView
        fun updateCounters() {
            if (::textView.isInitialized) {
                textView.text = "Counted" +
                        " OFFs: " + receiver.offCounter +
                        " ONs: " + receiver.onCounter
            }
        }
    }
}