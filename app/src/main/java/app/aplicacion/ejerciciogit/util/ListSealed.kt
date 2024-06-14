package app.aplicacion.ejerciciogit.util

import app.aplicacion.ejerciciogit.reto2.sealed.CategoryShopping
import app.aplicacion.ejerciciogit.reto2.sealed.CategoryShopping.*

object ListSealed {
    fun getList()= listOf<CategoryShopping>(VERDURAS,VIVERES,FRUTAS,ARTICULOSLIMPIEZA)
}