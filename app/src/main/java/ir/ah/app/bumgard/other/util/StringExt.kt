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

fun getTodayDate():String{
    val dateFormat: DateFormat = SimpleDateFormat("dd-MMM-yyyy")
    val calendar = Calendar.getInstance()
    val today = calendar.time
    return dateFormat.format(today)

}
fun getTomorrowDate():String{
    val dateFormat: DateFormat = SimpleDateFormat("dd-MMM-yyyy")
    val calendar = Calendar.getInstance()
    calendar.add(Calendar.DAY_OF_YEAR, 1)
    val tomorrow = calendar.time
  return dateFormat.format(tomorrow)
}


