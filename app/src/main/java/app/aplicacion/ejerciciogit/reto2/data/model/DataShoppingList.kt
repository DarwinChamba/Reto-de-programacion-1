package app.aplicacion.ejerciciogit.reto2.data.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import java.util.concurrent.locks.Lock

@Database(entities = [ShoppingList::class], version = 2, exportSchema = false)
@TypeConverters(ClassConverters::class)

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
            "shoppingDatabase").fallbackToDestructiveMigration().build()
    }




}