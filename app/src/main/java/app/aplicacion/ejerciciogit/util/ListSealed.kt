package app.aplicacion.ejerciciogit.util

import app.aplicacion.ejerciciogit.reto2.sealed.ShoppingSealed
import app.aplicacion.ejerciciogit.reto2.sealed.ShoppingSealed.*

object ListSealed {
    fun getList()= listOf<ShoppingSealed>(VERDURAS,VIVERES,FRUTAS,ARTICULOSLIMPIEZA)
}