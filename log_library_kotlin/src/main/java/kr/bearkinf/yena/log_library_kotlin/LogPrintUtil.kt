package kr.bearkinf.yena.log_library_kotlin

import android.util.Log


/**
 * 안드로이드 스튜디오 로그켓 클래스.
 * 안드로이드 스튜디오 로그켓에서 로그켓 출력한 곳을 쉽게
 * 이동하기 위해 만듬
 */
object LogPrintUtil {

    enum class LogLevel(val value: Int) {

        None(0x0),
        Debug(0x1),
        Warn(0x2),
        Error(0x4),
        Info(0x8),
        Verbose(0x10),

        All(LogLevel.Debug.value or LogLevel.Warn.value or LogLevel.Error.value or LogLevel.Info.value or LogLevel.Verbose.value)
    }

    var debug: Boolean = false  //디버그모드 일때는 true
        set(value) {
            //값을 받고
            field = value
            //플래그 설정을 변경한다.
            FLAGS = if (value) LogPrintUtil.LogLevel.All else LogPrintUtil.LogLevel.None
        }


    var FLAGS: LogLevel = LogPrintUtil.LogLevel.None
        set(value) {
            //디버그가 true 일때 필드값을 변경한다.
            if (debug) field = value
        }

    var TAG = "log"

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

        val ste = trace[position]
        val sb = StringBuilder()
        sb.append("[${Thread.currentThread().name}_Thread]")
        sb.append("(${ste.fileName}:${ste.lineNumber})::")
        sb.append("${ste.methodName}() : ")
        sb.append(strMsg)
        return sb.toString()
    }


    /**
     * 파란색, blue
     */
    fun d(strMsg: Any, strTag: String? = null, sleepCheck: Boolean = false) {

        if ((FLAGS.value and LogPrintUtil.LogLevel.Debug.value) != LogPrintUtil.LogLevel.Debug.value) {
            return
        }
        Log.d(strTag ?: TAG, buildMakeMessage(strMsg, sleepCheck))
    }

    /**
     *  노란색, yellow
     */
    fun w(strMsg: Any, strTag: String? = null, sleepCheck: Boolean = false) {
        if (FLAGS.value and LogPrintUtil.LogLevel.Warn.value != LogPrintUtil.LogLevel.Warn.value) {
            return
        }
        Log.w(strTag ?: TAG, buildMakeMessage(strMsg, sleepCheck))
    }

    /**
     *  빨간색, red
     */
    fun e(strMsg: Any, strTag: String? = null, sleepCheck: Boolean = false) {
        if (FLAGS.value and LogPrintUtil.LogLevel.Error.value != LogPrintUtil.LogLevel.Error.value) {
            return
        }
        Log.e(strTag ?: TAG, buildMakeMessage(strMsg, sleepCheck))

    }


    /**
     *  녹색, green
     */
    fun i(strMsg: Any, strTag: String? = null, sleepCheck: Boolean = false) {
        if (FLAGS.value and LogPrintUtil.LogLevel.Info.value != LogPrintUtil.LogLevel.Info.value) {
            return
        }
        Log.i(strTag ?: TAG, buildMakeMessage(strMsg, sleepCheck))
    }

    /**
     *  흰색, white
     */
    fun v(strMsg: Any, strTag: String? = null, sleepCheck: Boolean = false) {
        if (FLAGS.value and LogPrintUtil.LogLevel.Verbose.value != LogPrintUtil.LogLevel.Verbose.value) {
            return
        }
        Log.v(strTag ?: TAG, buildMakeMessage(strMsg, sleepCheck))
    }


}
