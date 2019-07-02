package com.example.broadcastexample

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_alaram_example.*
import android.widget.Toast
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import java.util.*
import android.R.string.cancel




class AlaramExample : AppCompatActivity() {
    var pendingIntent: PendingIntent? = null
    var alarmManager: AlarmManager? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alaram_example)

        btnStartAlaram.setOnClickListener {
//            if (!edtIntervalTime.getText().toString().equals("")) {
//                val i = Integer.parseInt(edtIntervalTime.getText().toString())
//                intent = Intent(this, BrdcstAlaramExample::class.java)
//                pendingIntent = PendingIntent.getBroadcast(
//                    this.applicationContext, 2, intent, PendingIntent.FLAG_CANCEL_CURRENT
//                )
//                alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
//                alarmManager!!.setRepeating(
//                    AlarmManager.RTC_WAKEUP,
//                    Calendar.getInstance().getTimeInMillis() + i * 1000,
//                    1000,
//                    pendingIntent
//                )
//
//                Toast.makeText(
//                    this, "Alarm $i seconds",
//                    Toast.LENGTH_LONG
//                ).show()
//            } else {
//                Toast.makeText(this, "Please Enter time ", Toast.LENGTH_SHORT).show()
//            }

            intent = Intent(this, BrdcstAlaramExample::class.java)
            pendingIntent = PendingIntent.getBroadcast(
                this.applicationContext, 280192, intent, PendingIntent.FLAG_CANCEL_CURRENT
            )

            val calendar = Calendar.getInstance()
            calendar.timeInMillis = System.currentTimeMillis()
            calendar.set(Calendar.HOUR_OF_DAY, 19)
            calendar.set(Calendar.MINUTE, 11)

            alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

            alarmManager!!.setInexactRepeating(
                AlarmManager.RTC_WAKEUP, calendar.timeInMillis,
                AlarmManager.INTERVAL_HOUR, pendingIntent
            )

        }


        btnStopAlaram.setOnClickListener {
            if (alarmManager != null) {

                alarmManager!!.cancel(pendingIntent);
                Toast.makeText(this, "Alarm Cancel",Toast.LENGTH_LONG).show();

            }
        }
    }

    override fun onStop() {
        super.onStop()
        if (alarmManager != null) {
            alarmManager!!.cancel(pendingIntent)
        }


    }
}
