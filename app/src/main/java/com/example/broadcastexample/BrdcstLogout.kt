package com.example.broadcastexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.support.v4.app.ActivityCompat.finishAffinity
import android.widget.Toast
import android.support.v4.content.ContextCompat.startActivity



class BrdcstLogout : BroadcastReceiver(){
    override fun onReceive(p0: Context?, p1: Intent?) {
        val newIntent = Intent(p0, MainActivity::class.java)

//        newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//        newIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        p0!!.startActivity(newIntent)
    }

}