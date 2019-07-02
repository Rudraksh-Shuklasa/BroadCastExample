package com.example.broadcastexample

import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.BroadcastReceiver
import android.content.Context
import android.support.v4.view.accessibility.AccessibilityEventCompat.setAction
import android.content.Intent
import android.support.v4.app.FragmentActivity
import android.util.Log


class MainActivity : AppCompatActivity() {
    var finshBroadCast : BroadcastReceiver ?= null
     var broadcastReceiver: BroadcastReceiver? = null

      var orderBroadCast : BroadcastReceiver ? = null

     val TAG = MainActivity::class.java!!.getSimpleName()
     val BREAD_CRUMB = "BreadCrumb"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        broadcastReceiver=Brdcst_Custom()
        orderBroadCast = Brdcst_Custom_Order()


        finshBroadCast=object : BroadcastReceiver(){
            override fun onReceive(p0: Context?, p1: Intent?) {
                finish()
            }

        }


        registerReceiver(finshBroadCast, IntentFilter("Finish"))

        btnOnSecond.setOnClickListener {
            var intent=Intent(this,Main2Activity::class.java)
            startActivity(intent)
        }
        btn_lunch_customBroadcasr.setOnClickListener {
            val intent = Intent()
            intent.addCategory(Intent.CATEGORY_DEFAULT)
            intent.action = "com.example.broadcastexample.CustomCall"

            sendOrderedBroadcast(intent, null, object : BroadcastReceiver() {
                override fun onReceive(context: Context, intent: Intent) {
                    val bundle = getResultExtras(true)
                    var breadcrumb = bundle.getString(BREAD_CRUMB)
                    breadcrumb = breadcrumb + "->" + TAG
                    Log.i(TAG, "On Receive: $breadcrumb")
                }
            }, null, 0, null, null)
        }
    }


    override fun onStart() {
        super.onStart()
        var intetfilter=IntentFilter("com.example.broadcastexample.CustomCall")
        intetfilter.addCategory("android.intent.category.DEFAULT")

        registerReceiver(orderBroadCast,intetfilter)
        registerReceiver(broadcastReceiver,intetfilter)
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(finshBroadCast)
        unregisterReceiver(broadcastReceiver)
        unregisterReceiver(orderBroadCast)
    }
}
