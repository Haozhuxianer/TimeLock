package com.timelock.hzxr.timelock

import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.IBinder

/**
 * Created by Hzxr on 2018/3/11.
 */
class ScreenOffListenerService: Service() {
    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        val intentFilter = IntentFilter()
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF)
        registerReceiver(mScreenOffReceiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_REDELIVER_INTENT
    }

    private val mScreenOffReceiver = object :BroadcastReceiver(){
        override fun onReceive(context: Context, intent: Intent) {
            if (intent.action.equals(Intent.ACTION_SCREEN_OFF)) {
                val mLockIntent = Intent(context, LockScreenActivity::class.java)
                mLockIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK and
                        Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)
                startActivity(mLockIntent)
            }
        }
    }
}