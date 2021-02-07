package com.kdroid.androidjetpackdemo

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

// lifecycle owner
class MainActivityObserver : LifecycleObserver {

    val TAG: String = MainActivityObserver::class.simpleName.toString()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreateEvent() {
        Log.d(TAG, "onCreateEvent() called")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStartEvent() {
        Log.d(TAG, "onStartEvent() called")
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResumeEvent() {
        Log.d(TAG, "onResumeEvent() called")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPauseEvent() {
        Log.d(TAG, "onPauseEvent() called")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStopEvent() {
        Log.d(TAG, "onStopEvent() called")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroyEvent() {
        Log.d(TAG, "onDestroyEvent() called")
    }


}