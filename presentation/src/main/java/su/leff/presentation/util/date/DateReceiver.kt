package su.leff.presentation.util.date

import java.text.SimpleDateFormat
import java.util.*

object DateReceiver {
    fun getDateType(calendar: Calendar): DateType {
        var dateType = DateType.TODAY
        val timeHour = SimpleDateFormat("HH:mm", Locale.getDefault())
        val timeTextHour: String = timeHour.format(calendar.time)
        val hour = calendar.get(Calendar.HOUR)
        val minutes: Int = calendar.get(Calendar.MINUTE)
        val day: Int = calendar.get(Calendar.DAY_OF_YEAR)
        val week = calendar.get(Calendar.WEEK_OF_YEAR)
        val month: Int = calendar.get(Calendar.MONTH)
        val year: Int = calendar.get(Calendar.YEAR)
        val nowCalendar = Calendar.getInstance()
        val nowHour: Int = nowCalendar.get(Calendar.HOUR)
        val nowMinutes = nowCalendar.get(Calendar.MINUTE)
        val nowDay = nowCalendar.get(Calendar.DAY_OF_YEAR)
        val nowWeek = nowCalendar.get(Calendar.WEEK_OF_YEAR)
        val nowMonth = nowCalendar.get(Calendar.MONTH)
        val nowYear = nowCalendar.get(Calendar.YEAR)

        /*Если год сообщения не совпадает с текущим годом, то выводим год сообщения.
        *Иначе если неделя сообщения не совпадает с тукущей неделей, то выводим дату текущего года.
        * Иначе если день сообщения не совпадает с текущим днем, то выводим день недели, но если
        * текущий день минус 1 равен дню сообщения, то выводим вчера.
         */
        if (year != nowYear) {
            dateType = DateType.OTHER_YEAR
        } else {
            if (week != nowWeek) {
                dateType = DateType.THIS_YEAR
            } else {
                if (day != nowDay) {
                    if (nowDay - 1 == day) {
                        dateType =
                            DateType.YESTERDAY
                    } else {
                        dateType =
                            DateType.THIS_WEEK
                    }
                } else {
                    dateType = DateType.TODAY
                }
            }
        }


        return dateType
    }

    fun getCurrectDate(calendar: Calendar): String {
        val datetype = getDateType(calendar)
        return when (datetype) {
            DateType.TODAY -> {
                val format = SimpleDateFormat("hh:mm", Locale.getDefault())
                format.format(calendar.time)
            }
            DateType.YESTERDAY -> {
                "вчера"
            }
            DateType.THIS_WEEK -> {
                val format = SimpleDateFormat("EEEE", Locale.getDefault())
                format.format(calendar.time)
            }
            DateType.THIS_YEAR -> {
                val format = SimpleDateFormat("dd.MM", Locale.getDefault())
                format.format(calendar.time)
            }
            DateType.OTHER_YEAR -> {
                val format = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
                format.format(calendar.time)
            }
        }
    }
}

