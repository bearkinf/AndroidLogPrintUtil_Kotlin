package kr.bearkinf.yena.android_log_kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kr.bearkinf.yena.log_library_kotlin.LogPrintUtil

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        LogPrintUtil.setDebug(if (BuildConfig.DEBUG) LogPrintUtil.All else LogPrintUtil.None)
        LogPrintUtil.setTag("Log")

        LogPrintUtil.d("Kotlin log false")
        LogPrintUtil.d("")
        LogPrintUtil.d("Kotlin log", sleepCheck = false)

        LogPrintUtil.d("Kotlin log sleepCheck true", "bear", true)
    }
}
