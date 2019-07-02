package com.example.broadcastexample

import android.app.Application
import android.app.NotificationManager
import android.app.NotificationChannel
import android.os.Build



class BaseClass : Application(){

    public  val channelId="TEST_CHANNLE"
    override fun onCreate() {
        super.onCreate()

            createNotificationChannle()
    }

    private fun createNotificationChannle() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel1 = NotificationChannel(
                channelId,
                "Channel 1",
                NotificationManager.IMPORTANCE_HIGH
            )
            channel1.description = "This is Channel 1"



            val manager = getSystemService(NotificationManager::class.java)
            manager!!.createNotificationChannel(channel1)
        }
    }

}