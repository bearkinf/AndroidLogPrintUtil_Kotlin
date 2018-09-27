package kr.bearkinf.yena.log_library_kotlin

import android.util.Log

/**
 * 안드로이드 스튜디오 로그켓 클래스.
 * 안드로이드 스튜디오 로그켓에서 로그켓 출력한 곳을 쉽게
 * 이동하기 위해 만듬
 */
object LogPrintUtil {

    private val Debug = 0x01
    private val Warn = 0x02
    private val Error = 0x04
    private val Info = 0x08
    private val Verbose = 0x10

    val None = 0x00
    val All = Debug or Warn or Error or Info or Verbose

    private var FLAGS = if (BuildConfig.DEBUG) All else None


    private var TAG = "log"

    /**
     * 디버깅 설정
     * LogPrintUtil.setDebug( BuildConfig.DEBUG ? LogPrintUtil.All : LogPrintUtil.None);
     */
    fun setDebug(flags: Int) {
        FLAGS = flags
    }

    /**
     * 테그설정
     */
    fun setTag(tag: String) {
        TAG = tag
    }

    /**
     * 로그켓 출력 메서드
     */
    private fun buildMakeMessage(strMsg: Any, sleepCheck_1: Boolean): String {

        if (sleepCheck_1) {
            Thread.sleep(1)
        }

        val trace = Thread.currentThread().stackTrace
        var position = 0
        var find = false

        trace.forEach {
            if (it.className == this.javaClass.name) {
                find = true
            }
            if (find && it.className != this.javaClass.name) {
                 return@forEach
            }
            position++
        }

//        for (i in 0 until trace.size) {
//            if (!find && trace[i].className != this.javaClass.name) {
//                continue
//            }
//            if (trace[i].className == this.javaClass.name) {
//                find = true
//                continue
//            }
//            if (find && trace[i].className != this.javaClass.name) {
//                position = i
//                break
//            }
//        }

        val ste = trace[position]
        val sb = StringBuilder()
        sb.append("(${ste.fileName}:${ste.lineNumber})")
        sb.append(strMsg)
        return sb.toString()
    }


    /**
     * 파란색, blue
     */
    fun d(strMsg: Any, strTag: String? = null, sleepCheck: Boolean = false) {
        if (FLAGS and Debug != Debug) {
            return
        }
        Log.d(strTag ?: TAG, buildMakeMessage(strMsg, sleepCheck))
    }

    /**
     *  노란색, yellow
     */
    fun w(strMsg: Any, strTag: String? = null, sleepCheck: Boolean = false) {
        if (FLAGS and Debug != Debug) {
            return
        }
        Log.w(strTag ?: TAG, buildMakeMessage(strMsg, sleepCheck))
    }

    /**
     *  빨간색, red
     */
    fun e(strMsg: Any, strTag: String? = null, sleepCheck: Boolean = false) {
        if (FLAGS and Debug != Debug) {
            return
        }
        Log.e(strTag ?: TAG, buildMakeMessage(strMsg, sleepCheck))

    }


    /**
     *  녹색, green
     */
    fun i(strMsg: Any, strTag: String? = null, sleepCheck: Boolean = false) {
        if (FLAGS and Debug != Debug) {
            return
        }
        Log.i(strTag ?: TAG, buildMakeMessage(strMsg, sleepCheck))
    }

    /**
     *  녹색, green
     */
    fun v(strMsg: Any, strTag: String? = null, sleepCheck: Boolean = false) {
        if (FLAGS and Debug != Debug) {
            return
        }
        Log.v(strTag ?: TAG, buildMakeMessage(strMsg, sleepCheck))
    }


}
