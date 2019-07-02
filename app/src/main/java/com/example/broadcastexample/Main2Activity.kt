package com.example.broadcastexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {
    var finshBroadCast : BroadcastReceiver?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        finshBroadCast=object : BroadcastReceiver(){
            override fun onReceive(p0: Context?, p1: Intent?) {
                finish()
            }

        }
        registerReceiver(finshBroadCast, IntentFilter("Finish"))
        btnOnThird.setOnClickListener {
            var intent=Intent(this,Main3Activity::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(finshBroadCast)
    }
}
