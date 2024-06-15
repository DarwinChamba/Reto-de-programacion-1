package app.aplicacion.ejerciciogit.reto2.ui.adapter

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import app.aplicacion.ejerciciogit.R
import app.aplicacion.ejerciciogit.databinding.ShoppingItemBinding
import app.aplicacion.ejerciciogit.reto2.data.model.ShoppingList
import app.aplicacion.ejerciciogit.reto2.sealed.CategoryShopping

class ShoppingViewHolder(view: View) :RecyclerView.ViewHolder(view){

    private val binding=ShoppingItemBinding.bind(view)

    fun render(shoppingList: ShoppingList,listener:((Int)->Unit)?){

        binding.price1.text=shoppingList.price.toString()
        binding.isCompleted.isChecked=shoppingList.isCompleted
        binding.hour.text=shoppingList.hour
        binding.date.text=shoppingList.date
        binding.name.text=shoppingList.name
        binding.cantidad1.text=shoppingList.number.toString()
        val totalPrecio=shoppingList.price* shoppingList.number
        binding.total1.text=totalPrecio.toString()+" $"


        itemView.setOnClickListener {
            listener?.invoke(layoutPosition)
        }
        val color =when(shoppingList.category){

            CategoryShopping.FRUTAS -> ContextCompat.getColor(binding.view.context,R.color.frutas)
            CategoryShopping.VERDURAS -> ContextCompat.getColor(binding.view.context,R.color.verduras)
            CategoryShopping.VIVERES -> ContextCompat.getColor(binding.view.context,R.color.viveres)
            CategoryShopping.ARTICULOSLIMPIEZA -> ContextCompat.getColor(binding.view.context,R.color.limpieza)
        }
        binding.view.setBackgroundColor(color)

    }


}