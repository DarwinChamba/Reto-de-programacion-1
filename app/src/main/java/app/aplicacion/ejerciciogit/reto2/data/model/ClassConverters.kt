package app.aplicacion.ejerciciogit.reto2.data.model

import androidx.room.TypeConverter
import app.aplicacion.ejerciciogit.reto2.sealed.CategoryShopping

class ClassConverters {

    @TypeConverter
    fun getConverterSealed(category: CategoryShopping): String {
        return when (category) {
            CategoryShopping.ARTICULOSLIMPIEZA -> "LIMPIEZA"
            CategoryShopping.FRUTAS -> "FRUTAS"
            CategoryShopping.VERDURAS -> "VERDURAS"
            CategoryShopping.VIVERES -> "VIVERES"
        }

    }

    @TypeConverter
    fun toCategoryShopping(category: String): CategoryShopping {
        return when (category) {
            "LIMPIEZA" -> CategoryShopping.ARTICULOSLIMPIEZA
            "FRUTAS" -> CategoryShopping.FRUTAS
            "VERDURAS" -> CategoryShopping.VERDURAS
            else -> CategoryShopping.VIVERES
        }

    }
}