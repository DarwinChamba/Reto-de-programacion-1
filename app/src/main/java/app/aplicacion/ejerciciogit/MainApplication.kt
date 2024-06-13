package app.aplicacion.ejerciciogit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import app.aplicacion.ejerciciogit.databinding.ActivityMainBinding

class MainApplication : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}