package com.example.broadcastexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class Brdcst_PowerOn : BroadcastReceiver(){
    override fun onReceive(p0: Context?, p1: Intent?) {
       Toast.makeText(p0,"Phone is On",Toast.LENGTH_LONG).show()
    }

}