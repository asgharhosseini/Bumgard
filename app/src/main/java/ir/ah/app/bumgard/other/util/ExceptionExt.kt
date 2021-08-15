package ir.ah.app.bumgard.other.util

import  ir.ah.app.bumgard.BuildConfig

fun Exception.print() {
    if (BuildConfig.DEBUG)
        printStackTrace()
}

fun Throwable.print() {
    if (BuildConfig.DEBUG)
        printStackTrace()
}

