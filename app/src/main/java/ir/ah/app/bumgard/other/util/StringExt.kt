package ir.ah.app.bumgard.other.util

import java.text.*
import java.util.*

fun dateToName(date: Date): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    return dateFormat.format(date.toLocaleString())
}

fun String.isValidEmail() =
    isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()


fun dateFormatted(date: Long): String {

    return DateFormat.getDateInstance(DateFormat.MEDIUM).format(Date(date))
}