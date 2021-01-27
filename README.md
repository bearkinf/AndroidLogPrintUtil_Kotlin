# AndroidLogLibKotlin

allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://jitpack.io/' }

    }
}
dependencies {
        implementation 'com.github.bearkinf:AndroidLogPrintUtil_Kotlin:1.5.0'
}

LogPrintUtil.debug = BuildConfig.DEBUG

LogPrintUtil.TAG = "Log"


LogPrintUtil.e("BaseActivity start")



