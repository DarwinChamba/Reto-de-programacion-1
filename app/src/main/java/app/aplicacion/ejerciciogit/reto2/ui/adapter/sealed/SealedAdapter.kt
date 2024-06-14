package app.aplicacion.ejerciciogit.reto2.ui.adapter.sealed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.aplicacion.ejerciciogit.R
import app.aplicacion.ejerciciogit.reto2.sealed.CategoryShopping

class SealedAdapter(val sealed: List<CategoryShopping>) : RecyclerView.Adapter<SealedViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SealedViewHolder {
        return SealedViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_sealed, parent, false)
        )
    }

    override fun getItemCount() = sealed.size

    override fun onBindViewHolder(holder: SealedViewHolder, position: Int) {
        holder.renderCategory(sealed[position],cardSelected)
    }

    private var cardSelected: ((Int) -> Unit)? = null

    fun onClickCardSelected(isSelected:((Int)->Unit)?){
        cardSelected=isSelected
    }

}