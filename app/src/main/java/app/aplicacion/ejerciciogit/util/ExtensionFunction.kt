package app.aplicacion.ejerciciogit.util

import android.app.Activity
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import app.aplicacion.ejerciciogit.R
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

fun Activity.changeColorWindow(color:Int){
    val window=this.window
    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
    window.statusBarColor=getColor(color)
}