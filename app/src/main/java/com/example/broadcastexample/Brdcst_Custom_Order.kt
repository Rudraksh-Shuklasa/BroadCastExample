package com.example.broadcastexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast



class Brdcst_Custom_Order : BroadcastReceiver(){

    private val TAG=Brdcst_Custom_Order::class.java.simpleName
    private val BREAD_CRUMB="BreadCrumb"

    override fun onReceive(p0: Context?, p1: Intent?) {
//        var bundle=getResultExtras(true)
//        var trail = bundle.getString(BREAD_CRUMB)
//
//        trail = if (trail == null) "Start->$TAG" else "$trail->$TAG"
//        bundle.putString(BREAD_CRUMB, trail)
//        Log.d(TAG, "BroadCastReceiver1 triggered: $trail")
        Log.d("one",Thread.currentThread().id.toString())

    }






}