package app.aplicacion.ejerciciogit.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.aplicacion.ejerciciogit.databinding.ActivityMainApplicationBinding
import app.aplicacion.ejerciciogit.reto1.MainActivity
import app.aplicacion.ejerciciogit.reto2.ui.view.ProgramingChallenge2

class MainApplication : AppCompatActivity() {
    private lateinit var binding: ActivityMainApplicationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainApplicationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGameRandomNumber.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        binding.btnShoppingList.setOnClickListener {
            startActivity(Intent(this,ProgramingChallenge2::class.java))
        }
    }
}