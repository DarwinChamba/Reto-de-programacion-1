package app.aplicacion.ejerciciogit.reto2.data.model

import android.content.Context
import android.webkit.CookieSyncManager.createInstance
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.util.concurrent.locks.Lock

@Database(entities = [ShoppingList::class], version = 1, exportSchema = false)

abstract  class DataShoppingList : RoomDatabase(){

    abstract fun getShoopingList():ShoppingDao

    companion object{
        @Volatile
        private var instance:DataShoppingList?=null
        private val Lock =Any()

        operator fun invoke(context: Context)= instance?: synchronized(Lock){
            instance?:createInstanceData(context).also{ instance=it}
        }
        private fun createInstanceData(context: Context)=
            Room.databaseBuilder(context.applicationContext,
            DataShoppingList::class.java,
            "shoppingDatabase").build()
    }




}