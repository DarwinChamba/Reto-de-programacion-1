package app.aplicacion.ejerciciogit.reto2.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import app.aplicacion.ejerciciogit.reto2.sealed.CategoryShopping
import java.io.Serializable


@Entity(tableName = "tableShoppingList")
data class ShoppingList(

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val number: Int,
    val price: Float,
    val isCompleted: Boolean = false,
    val hour: String,
    val date: String,
    val category:CategoryShopping
)