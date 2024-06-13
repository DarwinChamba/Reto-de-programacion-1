package app.aplicacion.ejerciciogit.reto2.data.repository

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import app.aplicacion.ejerciciogit.reto2.data.model.DataShoppingList
import app.aplicacion.ejerciciogit.reto2.data.model.ShoppingDao
import app.aplicacion.ejerciciogit.reto2.data.model.ShoppingList

class ShoppingListRepository(private val dao: ShoppingDao){

    suspend fun insertShopping(shoppingList: ShoppingList){
        dao.insertShoppingList(shoppingList )
    }
    suspend fun updateShopping(shoppingList: ShoppingList){
        dao.updateShoppingList(shoppingList )
    }
    suspend fun deleteShopping(shoppingList: ShoppingList){
        dao.deleteShoppingList(shoppingList )
    }

    fun getAllShoopingList():LiveData<List<ShoppingList>>{
        return dao.getAllShoppingList()
    }

}