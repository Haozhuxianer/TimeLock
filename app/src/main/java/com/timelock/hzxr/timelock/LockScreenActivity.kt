package com.timelock.hzxr.timelock

import android.app.KeyguardManager
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.KeyEvent
import android.view.WindowManager

/**
 * Created by Hzxr on 2018/3/11.
 */
class LockScreenActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD)
        window.addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED)
        setContentView(R.layout.activity_main)
    }

//    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
//        val key = event?.keyCode?: return true
//        return when(key) {
//            KeyEvent.KEYCODE_BACK -> true
//            KeyEvent.KEYCODE_MENU -> true
//            else -> super.onKeyDown(keyCode, event)
//        }
//    }
}