package src.main.kotlin.baseapp.freitech.com.myapplication2.qiitasample.extentions

import android.app.Activity
import android.support.annotation.IdRes
import android.view.View

    fun <T:View> View.bindView(@IdRes id: Int): Lazy<T> = lazy{
        findViewById<T>(id)
    }

    fun android.content.Context.toast(message: String, duration: Int = android.widget.Toast.LENGTH_SHORT){
        android.widget.Toast.makeText(this, message, duration).show()
    }