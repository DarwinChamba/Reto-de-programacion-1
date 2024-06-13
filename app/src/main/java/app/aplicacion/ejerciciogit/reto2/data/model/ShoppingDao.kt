package app.aplicacion.ejerciciogit.reto2.data.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface ShoppingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoppingList(shoppingList: ShoppingList)

    @Update
    suspend fun updateShoppingList(shoppingList: ShoppingList)

    @Delete
    suspend fun deleteShoppingList(shoppingList: ShoppingList)

    @Query("select * from tableShoppingList")
    fun getAllShoppingList():LiveData<List<ShoppingList>>


}