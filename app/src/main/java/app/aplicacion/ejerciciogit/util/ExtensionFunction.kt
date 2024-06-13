package app.aplicacion.ejerciciogit.util

import android.app.Activity
import android.view.View
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date

fun Activity.ToastT(message:String){
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}
fun Activity.getCurrentHour():String{
    val hour=Calendar.getInstance().time
    val hourFormater=SimpleDateFormat("hh:mm")
    return hourFormater.format(hour)

}
fun Activity.getCurrentDate():String{
    val date=Date()
    val formaterDate=SimpleDateFormat("YYYY-MM-dd")
    return formaterDate.format(date)
}