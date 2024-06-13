package app.aplicacion.ejerciciogit.reto2.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tableShoppingList")
data class ShoppingList(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val number: Int,
    val price: Float,
    val isCompleted: Boolean = false,
    val hour: String,
    val date: String
)