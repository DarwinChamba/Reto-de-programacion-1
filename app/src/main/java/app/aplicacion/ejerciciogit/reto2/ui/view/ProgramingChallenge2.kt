package app.aplicacion.ejerciciogit.reto2.ui.view

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.accessibility.AccessibilityEventCompat.setAction
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import app.aplicacion.ejerciciogit.R
import app.aplicacion.ejerciciogit.databinding.ActivityProgramingChallenge2Binding
import app.aplicacion.ejerciciogit.reto2.data.model.DeleteShopping
import app.aplicacion.ejerciciogit.reto2.data.model.ShoppingList
import app.aplicacion.ejerciciogit.reto2.ui.adapter.ShoppingAdapter
import app.aplicacion.ejerciciogit.reto2.ui.adapter.sealed.SealedAdapter
import app.aplicacion.ejerciciogit.reto2.ui.viewmodel.ShoppingListViewModel
import app.aplicacion.ejerciciogit.util.Constants
import app.aplicacion.ejerciciogit.util.ListSealed
import app.aplicacion.ejerciciogit.util.ToastT
import app.aplicacion.ejerciciogit.util.changeColorWindow
import app.aplicacion.ejerciciogit.util.getCurrentDate
import app.aplicacion.ejerciciogit.util.getCurrentHour
import app.aplicacion.ejerciciogit.reto2.sealed.CategoryShopping
import app.aplicacion.ejerciciogit.reto2.sealed.CategoryShopping.*
import app.aplicacion.ejerciciogit.ui.MainApplication
import com.google.android.material.snackbar.Snackbar


class ProgramingChallenge2 : AppCompatActivity() {
    private lateinit var binding: ActivityProgramingChallenge2Binding
    private lateinit var model: ShoppingListViewModel
    private lateinit var cadapter: ShoppingAdapter
    private lateinit var adapterSealed: SealedAdapter
    private lateinit var categoryShopping: CategoryShopping
    var lista = mutableListOf<ShoppingList>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProgramingChallenge2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        model = ViewModelProvider(this).get(ShoppingListViewModel::class.java)
        binding.floatingButton.setOnClickListener {
            addignNewShopping()
        }
        initRecycler()
        getAllLog()
        initRecyclerSealed()
        cardSelected()
        cambiarColor()
        deleteShopping()
        ObjectSelecte()

    }

    private fun ObjectSelecte() {
        cadapter.onClickShoppingList { shoppingItem ->
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.add_shopping)
            val title = dialog.findViewById<TextView>(R.id.titleUpdate)
            val name = dialog.findViewById<EditText>(R.id.name)
            val price = dialog.findViewById<EditText>(R.id.price)
            val number = dialog.findViewById<EditText>(R.id.number)
            val btnAddingNewShopping = dialog.findViewById<Button>(R.id.btnAddShopping)
            val spinner = dialog.findViewById<Spinner>(R.id.spinner)
            val adapterr =
                ArrayAdapter(this, android.R.layout.simple_spinner_item, Constants.getCategory())
            spinner.adapter = adapterr
            spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    p0: AdapterView<*>?,
                    p1: View?,
                    position: Int,
                    p3: Long
                ) {
                    val category = Constants.getCategory()[position]

                    categoryShopping = when (category) {
                        "VERDURAS" -> VERDURAS
                        "VIVERES" -> VIVERES
                        "FRUTAS" -> FRUTAS
                        else -> ARTICULOSLIMPIEZA
                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {}
            }
            title.setText("Update Shopping List")
            name.setText(shoppingItem.name)
            price.setText(shoppingItem.price.toString())
            number.setText(shoppingItem.number.toString())
            val category = when (shoppingItem.category) {
                ARTICULOSLIMPIEZA -> "LIMPIEZA"
                FRUTAS -> "FRUTAS"
                VERDURAS -> "VERDURAS"
                VIVERES -> "VIVERES"
            }

            val position = Constants.getCategory().indexOf(category)
            spinner.setSelection(position)
            btnAddingNewShopping.setText("Update")

            btnAddingNewShopping.setOnClickListener {
                val newName = name.text.toString()
                val newPrice = price.text.toString()
                val newNumber = number.text.toString()
                if (newName.isNullOrEmpty() || newPrice.isNullOrEmpty() || newNumber.isNullOrEmpty()) {
                    ToastT("required field")
                } else {
                    val updatedShoppingItem = ShoppingList(
                        shoppingItem.id, newName, newNumber.toInt(), newPrice.toFloat(),
                        false, getCurrentHour(), getCurrentDate(), categoryShopping
                    )

                    model.updateShooping(updatedShoppingItem)

                }
                dialog.dismiss()
            }
            dialog.show()

        }
    }


    private fun addignNewShopping() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.add_shopping)
        val title = dialog.findViewById<TextView>(R.id.titleUpdate)
        val name = dialog.findViewById<EditText>(R.id.name)
        val price = dialog.findViewById<EditText>(R.id.price)
        val number = dialog.findViewById<EditText>(R.id.number)
        val btnAddingNewShopping = dialog.findViewById<Button>(R.id.btnAddShopping)
        val spinner = dialog.findViewById<Spinner>(R.id.spinner)
        val adapterr =
            ArrayAdapter(this, android.R.layout.simple_spinner_item, Constants.getCategory())
        spinner.adapter = adapterr
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {

                val category = Constants.getCategory()[position]

                categoryShopping = when (category) {
                    "VERDURAS" -> VERDURAS
                    "VIVERES" -> VIVERES
                    "FRUTAS" -> FRUTAS
                    else -> ARTICULOSLIMPIEZA
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

        }
        btnAddingNewShopping.setOnClickListener {
            val newName = name.text.toString()
            val newPrice = price.text.toString()
            val newNumber = number.text.toString()
            if (newName.isNullOrEmpty() || newPrice.isNullOrEmpty() || newNumber.isNullOrEmpty()) {
                ToastT("requiered field")

            } else {
                val shopping = ShoppingList(
                    0, newName, newNumber.toInt(), newPrice.toFloat(),
                    false, getCurrentHour(), getCurrentDate(), categoryShopping
                )
                model.insertShooping(shopping)



                ToastT("registration completed successfully")
            }
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun deleteShopping() {
        val itemDelete = object : DeleteShopping() {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                val shopping = cadapter.diff.currentList[position]
                model.deleteShooping(shopping)
                Snackbar.make(binding.root, "registro eliminado con exito ", Snackbar.LENGTH_LONG)
                    .apply {
                        setAction("DESAHACER") {
                            model.insertShooping(shopping)
                        }
                    }.show()


            }

        }
        ItemTouchHelper(itemDelete).apply {
            attachToRecyclerView(binding.recycler)
        }
    }

    private fun filterList() {

        val categoryList = ListSealed.getList().filter { it.isSelected == true }

        if (!categoryList.isNullOrEmpty()) {
            var elementosSeleccionados = mutableListOf<ShoppingList>()
            val newList = lista.filter { categoryList.contains(it.category) }
            elementosSeleccionados.addAll(newList)
            cadapter.diff.submitList(elementosSeleccionados)
        } else {
            cadapter.diff.submitList(lista)
        }
    }

    private fun cardSelected() {
        adapterSealed.onClickCardSelected {

            ListSealed.getList()[it].isSelected = !ListSealed.getList()[it].isSelected
            adapterSealed.notifyItemChanged(it)
            filterList()
        }
    }


    private fun getAllLog() {
        model.shoppingList.observe(this, Observer {
            cadapter.diff.submitList(it)
            lista.clear()
            lista = it.toMutableList()
        })
    }


    private fun initRecycler() {
        cadapter = ShoppingAdapter()
        binding.recycler.apply {
            layoutManager = LinearLayoutManager(this@ProgramingChallenge2)
            adapter = cadapter
            setHasFixedSize(true)
        }
    }

    private fun initRecyclerSealed() {
        adapterSealed = SealedAdapter(ListSealed.getList())
        binding.recyclerCategory.apply {
            layoutManager = LinearLayoutManager(
                this@ProgramingChallenge2,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            adapter = adapterSealed
            setHasFixedSize(true)
        }
    }

    private fun cambiarColor() {
        val color = R.color.limpieza
        changeColorWindow(color)
    }


}