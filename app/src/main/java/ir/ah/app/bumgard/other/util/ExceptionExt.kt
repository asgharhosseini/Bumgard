package ir.ah.app.bumgard.other.util

fun Exception.print() {
    if (BuildConfig.DEBUG)
        printStackTrace()
}

fun Throwable.print() {
    if (BuildConfig.DEBUG)
        printStackTrace()
}

