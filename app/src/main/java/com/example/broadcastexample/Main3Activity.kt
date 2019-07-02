package com.example.broadcastexample

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main3.*

class Main3Activity : AppCompatActivity() {


    var brdcstLogout : BroadcastReceiver? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        brdcstLogout = BrdcstLogout()

        btnLogout.setOnClickListener {
//            val intent = Intent()
//            intent.addCategory(Intent.CATEGORY_DEFAULT)
//            intent.action = "com.example.broadcastexample.CustomCall"

            sendBroadcast(Intent("Finish"))

        }


    }
    override fun onStart() {
        super.onStart()
        var intetfilter= IntentFilter("com.example.broadcastexample.CustomCall")
        intetfilter.addCategory("android.intent.category.DEFAULT")

        registerReceiver(brdcstLogout,intetfilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(brdcstLogout)
    }
}
