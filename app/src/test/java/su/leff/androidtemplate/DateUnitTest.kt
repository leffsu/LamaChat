package su.leff.androidtemplate

import org.junit.Assert
import org.junit.Test
import su.leff.presentation.util.date.DateReceiver
import su.leff.presentation.util.date.DateType
import java.util.*

class DateUnitTest {
    @Test
    fun date_type_test_yesterday() {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - 1)
        val datetype = DateReceiver.getDateType(calendar)
        Assert.assertEquals(DateType.YESTERDAY, datetype)
    }

    @Test
    fun date_type_test_today() {
        val calendar = Calendar.getInstance()
        val datetype = DateReceiver.getDateType(calendar)
        Assert.assertEquals(DateType.TODAY, datetype)
    }
    @Test
    fun date_type_test_week() {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - 2)
        val datetype = DateReceiver.getDateType(calendar)
        Assert.assertEquals(DateType.THIS_WEEK, datetype)
    }
    @Test
    fun date_type_test_year() {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1)
        val datetype = DateReceiver.getDateType(calendar)
        Assert.assertEquals(DateType.THIS_YEAR, datetype)
    }
    @Test
    fun date_type_test_oter_year() {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 2)
        val datetype = DateReceiver.getDateType(calendar)
        Assert.assertEquals(DateType.OTHER_YEAR, datetype)
    }
}