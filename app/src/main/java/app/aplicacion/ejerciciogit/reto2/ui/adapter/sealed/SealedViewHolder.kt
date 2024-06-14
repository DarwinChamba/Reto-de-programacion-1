package app.aplicacion.ejerciciogit.reto2.ui.adapter.sealed

import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import app.aplicacion.ejerciciogit.R
import app.aplicacion.ejerciciogit.databinding.ItemSealedBinding
import app.aplicacion.ejerciciogit.reto2.sealed.CategoryShopping

class SealedViewHolder(view: View):RecyclerView.ViewHolder(view) {
    private val binding=ItemSealedBinding.bind(view)

    fun renderCategory(sealed: CategoryShopping, isSelected:((Int)->Unit)?){

        itemView.setOnClickListener {
            isSelected?.invoke(layoutPosition)
        }

       val colorSelected=if(sealed.isSelected){
            ContextCompat.getColor(binding.category.context,R.color.cardSelected)
        }else{
           ContextCompat.getColor(binding.category.context,R.color.cardNoSelected)
       }
        binding.cardCategory.setCardBackgroundColor(colorSelected)





      var color= when(sealed){
            CategoryShopping.ARTICULOSLIMPIEZA -> {

                binding.category.text="ARTICULOS DE LIMPIEZA"
                ContextCompat.getColor(binding.category.context, R.color.limpieza)
            }
            CategoryShopping.FRUTAS ->{

                binding.category.text="FRUTAS"
                ContextCompat.getColor(binding.category.context, R.color.frutas)
            }
            CategoryShopping.VERDURAS -> {

                binding.category.text="VERDURAS"
                ContextCompat.getColor(binding.category.context, R.color.verduras)
            }
            CategoryShopping.VIVERES -> {

                binding.category.text="VIVERES"
                ContextCompat.getColor(binding.category.context, R.color.viveres)
            }
        }
        binding.view.setBackgroundColor(color)

    }



}