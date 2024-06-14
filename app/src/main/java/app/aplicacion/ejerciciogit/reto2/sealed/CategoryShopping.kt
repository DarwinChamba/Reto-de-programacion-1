package app.aplicacion.ejerciciogit.reto2.sealed

sealed class CategoryShopping(var isSelected:Boolean=false) {
    object FRUTAS:CategoryShopping()
    object VERDURAS:CategoryShopping()
    object ARTICULOSLIMPIEZA:CategoryShopping()

    object VIVERES:CategoryShopping()
}