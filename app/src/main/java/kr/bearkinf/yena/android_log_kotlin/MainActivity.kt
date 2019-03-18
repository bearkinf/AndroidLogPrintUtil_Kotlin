package kr.bearkinf.yena.android_log_kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kr.bearkinf.yena.log_library_kotlin.LogPrintUtil

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        LogPrintUtil.debug = false

        LogPrintUtil.TAG = "Log"

        println(LogPrintUtil.FLAGS)

        LogPrintUtil.d("Kotlin log false")
        LogPrintUtil.e("error")
        LogPrintUtil.v("Kotlin log", sleepCheck = false)
        LogPrintUtil.i("Kotlin log sleepCheck true", "bear", true)
        LogPrintUtil.w("Log")




        LogPrintUtil.FLAGS = LogPrintUtil.LogLevel.Debug
        println(LogPrintUtil.FLAGS)
        LogPrintUtil.d("ddddLog")
        LogPrintUtil.w("ddddLog")
        LogPrintUtil.e("dddLog")
        LogPrintUtil.i("dddLog")
        LogPrintUtil.v("dddLog")
        LogPrintUtil.d("")
        LogPrintUtil.FLAGS = LogPrintUtil.LogLevel.Warn
        println(LogPrintUtil.FLAGS)
        LogPrintUtil.w("wwwLog")
        LogPrintUtil.w("wwwLog")
        LogPrintUtil.e("wwwLog")
        LogPrintUtil.i("wwwLog")
        LogPrintUtil.v("wwwLog")
        LogPrintUtil.d("")
        LogPrintUtil.FLAGS = LogPrintUtil.LogLevel.Error
        println(LogPrintUtil.FLAGS)
        LogPrintUtil.e("eeeLog")
        LogPrintUtil.w("eeeLog")
        LogPrintUtil.e("eeeLog")
        LogPrintUtil.i("eeeLog")
        LogPrintUtil.v("eeeLog")
        LogPrintUtil.d("")
        LogPrintUtil.FLAGS = LogPrintUtil.LogLevel.Info
        println(LogPrintUtil.FLAGS)
        LogPrintUtil.i("iiiLog")
        LogPrintUtil.w("iiiLog")
        LogPrintUtil.e("iiiLog")
        LogPrintUtil.i("iiiLog")
        LogPrintUtil.v("iiiLog")
        LogPrintUtil.d("")
        LogPrintUtil.FLAGS = LogPrintUtil.LogLevel.Verbose
        println(LogPrintUtil.FLAGS)
        LogPrintUtil.v("vvvLog")
        LogPrintUtil.w("vvvLog")
        LogPrintUtil.e("vvvLog")
        LogPrintUtil.i("vvvLog")
        LogPrintUtil.v("vvvLog")

    }
}
