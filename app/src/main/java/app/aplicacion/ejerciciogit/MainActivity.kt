package app.aplicacion.ejerciciogit

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import app.aplicacion.ejerciciogit.databinding.ActivityMainBinding
import java.util.Random
import kotlin.jvm.internal.Intrinsics.Kotlin


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var numeroRandom = -1
    private var vidas = 3
    private lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnNumberRandom.setOnClickListener {
            getRandonmNumber()
        }
        binding.btnVerificar.setOnClickListener {
            verificarNumero()
        }
        binding.showNumber.setOnClickListener {
            showNumberRandom()
        }
        mediaPlayer = MediaPlayer.create(applicationContext, R.raw.main_song)

        mediaPlayer.isLooping = true




        cambiarColor()


    }

    private fun showNumberRandom() {
        binding.showNumberRandom.visibility = View.VISIBLE
        binding.showNumberRandom.text = numeroRandom.toString()
    }


    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
        mediaPlayer.release()
    }
    override fun onPause() {
        super.onPause()
        mediaPlayer.pause()
    }
    override fun onResume() {
        super.onResume()
       mediaPlayer.start()
    }


    private fun getRandonmNumber() {
        val random = Random()
        numeroRandom = random.nextInt(34);
        comunAlertDialog("Numero Aleatorio", "Numero generado con exito", R.drawable.ic_iconrandom)


    }

    private fun verificarNumero() {
        val isCorrect = getNumber()
        if (isCorrect) {
            val numeroCorrecto = Integer.parseInt(binding.myNumber.text.toString())
            compararNumeros(numeroCorrecto)
        }

    }

    private fun compararNumeros(numero: Int) {

        if (numeroRandom != -1) {
            if (numero == numeroRandom) {
                val view = LayoutInflater.from(this).inflate(R.layout.correct_answer, null)
                alertDialog("Numero Correcto", view)
                numeroRandom = -1
                vidas = 3
                binding.imageView.setImageResource(0)
                binding.imageView.setImageResource(R.drawable.tresvidas)
                binding.showNumberRandom.setText("")

            } else if (numero > numeroRandom) {

                val view = LayoutInflater.from(this).inflate(R.layout.wrong_answer, null)
                alertDialog("El numero debe ser menor", view)
                vidas--
                binding.myNumber.setText("")

            } else if (numero < numeroRandom) {

                val view = LayoutInflater.from(this).inflate(R.layout.wrong_answer, null)
                alertDialog("El numero debe ser mayor", view)
                vidas--
                binding.myNumber.setText("")

            }
            if (vidas == 2) {
                binding.imageView.setImageResource(R.drawable.dosvidas)
            } else if (vidas == 1) {
                binding.imageView.setImageResource(R.drawable.unavida)
            } else if (vidas == 0) {
                binding.imageView.setImageResource(R.drawable.tresvidas)
                numeroRandom = -1
                vidas = 3
                val icon = R.drawable.ic_iconrandom
                comunAlertDialog(
                    "Juego Terminado",
                    "Gracias por jugar....el juego ha terminado",
                    icon
                )
                binding.showNumberRandom.setText("")

            }

        } else {
            Toast.makeText(this, "Primero debes generar un numero aletorio", Toast.LENGTH_SHORT)
                .show()
        }


    }

    private fun comunAlertDialog(title: String, message: String, icon: Int) {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle(title)
        dialog.setMessage(message)
        dialog.setIcon(icon)
        dialog.setPositiveButton("Aceptar") { dialog, which ->
            dialog.dismiss()
        }
        dialog.setCancelable(false)
        val builder = dialog.create()
        builder.show()
    }

    private fun getNumber(): Boolean {
        val numero = binding.myNumber.text.toString()
        if (numero.isNullOrEmpty()) {
            Toast.makeText(this, "Ingrese un numero entero", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun alertDialog(title: String, view: View) {

        val dialog = AlertDialog.Builder(this)
        dialog.setTitle(title)
        dialog.setIcon(R.drawable.ic_cancel)
        dialog.setView(view)
        dialog.setPositiveButton("ACEPTAR") { dialog, which ->
            dialog.dismiss()

        }

        val alert = dialog.create()
        alert.show()
        alert.setCancelable(false)
    }

    private fun cambiarColor() {
        val window = this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = getColor(R.color.colorPantalla)

    }

}