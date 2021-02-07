package com.kdroid.usecasedemoapplication

import android.app.Service
import android.content.Intent
import android.os.*
import android.util.Log
import android.widget.Toast

class HelloService : Service() {

    private var serviceLooper: Looper? = null
    private var serviceHandler: ServiceHandler? = null

    private val TAG: String? = HelloService::class.simpleName

    private inner class ServiceHandler(looper: Looper) : Handler(looper) {
        override fun handleMessage(msg: Message) {
            try {
                Thread.sleep(5000)
            } catch (e: InterruptedException) {
                // Restore interrupt status.
                Thread.currentThread().interrupt()
                Log.e(TAG, "handleMessage: " + e.localizedMessage)
            }
            stopSelf(msg.arg1)
        }
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate() called")
        HandlerThread("Service Argument", Process.THREAD_PRIORITY_BACKGROUND).apply {
            start()
            serviceLooper = looper
            serviceHandler = ServiceHandler(looper)
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Toast.makeText(this, "service starting", Toast.LENGTH_SHORT).show()
        Log.d(TAG, "service starting");

        serviceHandler?.obtainMessage()?.also { msg ->
            msg.arg1 = startId
            serviceHandler?.sendMessage(msg)
        }
        return START_STICKY

    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }
}