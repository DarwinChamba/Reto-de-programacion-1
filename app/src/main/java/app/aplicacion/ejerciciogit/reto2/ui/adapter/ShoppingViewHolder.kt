package app.aplicacion.ejerciciogit.reto2.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import app.aplicacion.ejerciciogit.databinding.ShoppingItemBinding
import app.aplicacion.ejerciciogit.reto2.data.model.ShoppingList

class ShoppingViewHolder(view: View) :RecyclerView.ViewHolder(view){

    private val binding=ShoppingItemBinding.bind(view)

    fun render(shoppingList: ShoppingList){

        binding.cantidad.text=shoppingList.price.toString()
        binding.isCompleted.isChecked=shoppingList.isCompleted
        binding.hour.text=shoppingList.hour
        binding.date.text=shoppingList.date
        binding.name.text=shoppingList.name
        binding.cantidad.text=shoppingList.number.toString()

    }


}