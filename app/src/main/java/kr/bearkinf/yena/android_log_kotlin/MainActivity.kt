package kr.bearkinf.yena.android_log_kotlin

import android.os.Bundle
import android.util.Log

import androidx.appcompat.app.AppCompatActivity
import kr.bearkinf.yena.log_library_kotlin.LogPrintUtil

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        LogPrintUtil.debug = BuildConfig.DEBUG

        LogPrintUtil.TAG = "Log"

        println(LogPrintUtil.FLAGS)

        LogPrintUtil.d("blue 6897BB")
        LogPrintUtil.e("red FF6B68")
        LogPrintUtil.v("v  white")
        LogPrintUtil.i("green  6A8759")
        LogPrintUtil.w("yellow BBB529")
    }
}
