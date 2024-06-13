package app.aplicacion.ejerciciogit.reto2.ui.view

import android.annotation.SuppressLint
import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import app.aplicacion.ejerciciogit.R
import app.aplicacion.ejerciciogit.databinding.ActivityProgramingChallenge2Binding
import app.aplicacion.ejerciciogit.reto2.data.model.ShoppingList
import app.aplicacion.ejerciciogit.reto2.ui.adapter.ShoppingAdapter
import app.aplicacion.ejerciciogit.reto2.ui.viewmodel.ShoppingListViewModel
import app.aplicacion.ejerciciogit.util.ToastT
import app.aplicacion.ejerciciogit.util.getCurrentDate
import app.aplicacion.ejerciciogit.util.getCurrentHour
import java.text.SimpleDateFormat
import java.util.Calendar


class ProgramingChallenge2 : AppCompatActivity() {
    private lateinit var binding:ActivityProgramingChallenge2Binding
    private lateinit var model: ShoppingListViewModel
    private lateinit var cadapter:ShoppingAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityProgramingChallenge2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        model=ViewModelProvider(this).get(ShoppingListViewModel::class.java)
        binding.floatingButton.setOnClickListener {
            addignNewShopping()
        }
        initRecycler()
        getAllLog()
    }

    private fun getAllLog() {
        model.shoppingList.observe(this, Observer {
            cadapter.diff.submitList(it)
        })
    }

    private fun addignNewShopping() {
        val dialog=Dialog(this)
        dialog.setContentView(R.layout.add_shopping)
        val name=dialog.findViewById<EditText>(R.id.name)
        val price=dialog.findViewById<EditText>(R.id.price)
        val number=dialog.findViewById<EditText>(R.id.number)
        val btnAddingNewShopping=dialog.findViewById<Button>(R.id.btnAddShopping)
        btnAddingNewShopping.setOnClickListener {
            val newName=name.text.toString()
            val newPrice=price.text.toString()
            val newNumber=number.text.toString()
            if(newName.isNullOrEmpty() || newPrice.isNullOrEmpty() || newNumber.isNullOrEmpty()){
                ToastT("requiered field")

            }else{
                val shopping=ShoppingList(0, newName,newNumber.toInt(),newPrice.toFloat(),
                    false,getCurrentHour(),getCurrentDate())
                model.insertShooping(shopping)
                ToastT("registration completed successfully")
            }
        }
    }
   private fun initRecycler(){
       cadapter= ShoppingAdapter()
       binding.recycler.apply {
           layoutManager=LinearLayoutManager(this@ProgramingChallenge2)
           adapter=cadapter
           setHasFixedSize(true)
       }
   }


}