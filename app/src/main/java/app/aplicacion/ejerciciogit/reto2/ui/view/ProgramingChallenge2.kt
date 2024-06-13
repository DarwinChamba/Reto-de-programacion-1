package app.aplicacion.ejerciciogit.reto2.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import app.aplicacion.ejerciciogit.databinding.ActivityProgramingChallenge2Binding
import app.aplicacion.ejerciciogit.reto2.ui.viewmodel.ShoppingListViewModel

class ProgramingChallenge2 : AppCompatActivity() {
    private lateinit var binding:ActivityProgramingChallenge2Binding
    private lateinit var model: ShoppingListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityProgramingChallenge2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        model=ViewModelProvider(this).get(ShoppingListViewModel::class.java)
    }
}