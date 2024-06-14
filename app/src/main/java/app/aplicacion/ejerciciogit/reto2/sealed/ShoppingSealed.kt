package app.aplicacion.ejerciciogit.reto2.sealed

sealed class ShoppingSealed(var isSelected:Boolean=false) {
    object FRUTAS:ShoppingSealed()
    object VERDURAS:ShoppingSealed()
    object ARTICULOSLIMPIEZA:ShoppingSealed()
    object VIVERES:ShoppingSealed()
}