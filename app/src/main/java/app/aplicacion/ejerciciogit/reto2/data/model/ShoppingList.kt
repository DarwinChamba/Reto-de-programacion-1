package app.aplicacion.ejerciciogit.reto2.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tableShoppingList")
data class ShoppingList (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val nombre:String,
    val cantidad:Int,
    val precio:Float,
    val isCompleted:Boolean=false
        )