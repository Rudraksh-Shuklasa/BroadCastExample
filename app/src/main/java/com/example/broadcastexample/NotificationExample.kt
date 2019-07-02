package com.example.broadcastexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_notification_example.*
import android.app.PendingIntent
import android.content.Intent
import android.app.NotificationManager

import android.app.Notification
import android.content.Context
import android.support.v4.app.NotificationManagerCompat
import android.support.v4.app.NotificationCompat






class NotificationExample : AppCompatActivity() {
    private var notificationManager: NotificationManagerCompat? = null
    val channelId="TEST_CHANNLE"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification_example)
        btnGetNotification.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            val pIntent = PendingIntent.getActivity(this, 12, intent, 0)
            notificationManager = NotificationManagerCompat.from(this);



            val notification = NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentIntent(pIntent)
                .setContentTitle("One Notification")
                .setContentText("Godadasdsadsadddsahdgsadhjdsgahdsahjdashddshshjsdsadhsadhsdsdshdhjsddssahd")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build()

            notificationManager!!.notify(1, notification)


        }
    }
}
