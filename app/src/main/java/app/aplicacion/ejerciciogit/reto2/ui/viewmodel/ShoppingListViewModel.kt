package app.aplicacion.ejerciciogit.reto2.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import app.aplicacion.ejerciciogit.reto2.data.model.DataShoppingList
import app.aplicacion.ejerciciogit.reto2.data.model.ShoppingList
import app.aplicacion.ejerciciogit.reto2.data.repository.ShoppingListRepository
import kotlinx.coroutines.launch

class ShoppingListViewModel(application: Application):AndroidViewModel(application) {

    private val repository:ShoppingListRepository
    val shoppingList:LiveData<List<ShoppingList>>

    init {
        val dao=DataShoppingList.invoke(application).getShoopingList()
        repository=ShoppingListRepository(dao)
        shoppingList=repository.getAllShoopingList()
    }

    fun insertShooping(shoppingList: ShoppingList){
        viewModelScope.launch {
            repository.insertShopping(shoppingList)
        }
    }

    fun updateShooping(shoppingList: ShoppingList){
        viewModelScope.launch {
            repository.updateShopping(shoppingList)
        }
    }

    fun deleteShooping(shoppingList: ShoppingList){
        viewModelScope.launch {
            repository.deleteShopping(shoppingList)
        }
    }


}