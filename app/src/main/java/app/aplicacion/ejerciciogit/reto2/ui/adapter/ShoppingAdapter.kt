package app.aplicacion.ejerciciogit.reto2.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import app.aplicacion.ejerciciogit.R
import app.aplicacion.ejerciciogit.reto2.data.model.ShoppingList

class ShoppingAdapter:RecyclerView.Adapter<ShoppingViewHolder>() {

    private val userDiff=object :DiffUtil.ItemCallback<ShoppingList>(){
        override fun areItemsTheSame(oldItem: ShoppingList, newItem: ShoppingList): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ShoppingList, newItem: ShoppingList): Boolean {
            return oldItem == newItem
        }

    }

    val diff=AsyncListDiffer(this,userDiff)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        return ShoppingViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.shopping_item,parent,false))
    }

    override fun getItemCount()=diff.currentList.size

    private var selectedPosition:((ShoppingList)->Unit)?=null

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        holder.render(diff.currentList[position],selectedPosition)
    }

    fun onClickShoppingList(listener:((ShoppingList)->Unit)?){
        selectedPosition=listener
    }

}