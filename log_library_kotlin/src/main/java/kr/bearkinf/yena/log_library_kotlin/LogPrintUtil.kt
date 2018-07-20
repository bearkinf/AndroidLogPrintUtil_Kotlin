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
    private fun buildMakeMessage(strMsg: Any): String {

        Thread.sleep(1)

        val ste = Thread.currentThread().stackTrace[4]
        val sb: StringBuilder
        sb = StringBuilder()
        sb.append("(" + ste.fileName + ":" + ste.lineNumber + ")")
        sb.append(strMsg)
        return sb.toString()

    }

    /**
     * 파란색, blue
     */
    fun d(strMsg: Any) {
        if (FLAGS and Debug != Debug) {
            return
        }

        Log.d(TAG, buildMakeMessage(strMsg))
    }

    /**
     * 파란색, blue
     */
    fun d(strTag: String, strMsg: Any) {
        if (FLAGS and Debug != Debug) {
            return
        }

        Log.d(strTag, buildMakeMessage(strMsg))
    }

    /**
     * 노란색, yellow
     */
    fun w(strMsg: Any) {
        if (FLAGS and Warn != Warn) {
            return
        }

        Log.w(TAG, buildMakeMessage(strMsg))
    }

    /**
     * 노란색, yellow
     */
    fun w(strTag: String, strMsg: Any) {
        if (FLAGS and Warn != Warn) {
            return
        }

        Log.w(strTag, buildMakeMessage(strMsg))
    }

    /**
     * 빨간색, red
     */
    fun e(strMsg: Any) {
        if (FLAGS and Error != Error) {
            return
        }

        Log.e(TAG, buildMakeMessage(strMsg))
    }

    /**
     * 빨간색, red
     */
    fun e(strTag: String, strMsg: Any) {
        if (FLAGS and Error != Error) {
            return
        }

        Log.e(strTag, buildMakeMessage(strMsg))
    }

    /**
     * 녹색, green
     */
    fun i(strMsg: Any) {
        if (FLAGS and Info != Info) {
            return
        }

        Log.i(TAG, buildMakeMessage(strMsg))
    }

    /**
     * 녹색, green
     */
    fun i(strTag: String, strMsg: Any) {
        if (FLAGS and Info != Info) {
            return
        }

        Log.i(strTag, buildMakeMessage(strMsg))
    }

    /**
     * 하얀색, white
     */
    fun v(strMsg: Any) {
        if (FLAGS and Verbose != Verbose) {
            return
        }

        Log.v(TAG, buildMakeMessage(strMsg))
    }

    /**
     * 하얀색, white
     */
    fun v(strTag: String, strMsg: Any) {
        if (FLAGS and Verbose != Verbose) {
            return
        }

        Log.v(strTag, buildMakeMessage(strMsg))
    }
}
