package com.example.broadcastexample


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Vibrator
import android.util.Log
import android.widget.Toast

class BrdcstAlaramExample : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {


        Log.d("Alaram Ringing","Done")

    }
}