package app.aplicacion.ejerciciogit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import app.aplicacion.ejerciciogit.databinding.ActivityMainBinding
import java.util.Random
import kotlin.jvm.internal.Intrinsics.Kotlin



class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private var numeroRandom=-1
    private var vidas=3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnNumberRandom.setOnClickListener {
            getRandonmNumber()
        }
        binding.btnVerificar.setOnClickListener {
            verificarNumero()
        }




    }
    private fun getRandonmNumber(){
        val random=Random()
        numeroRandom=random.nextInt(34);
        val dialog=AlertDialog.Builder(this)
        dialog.setMessage("Numero generado con exito")
        dialog.setIcon(R.drawable.ic_iconrandom)
        dialog.setTitle("Numero Aleatorio")
        dialog.setPositiveButton("Aceptar"){dialog,which->
            dialog.dismiss()
        }
        dialog.setCancelable(false)
        val builder=dialog.create()
        builder.show()

    }
    private fun verificarNumero(){
        val isCorrect=getNumber()
        if(isCorrect){
            val numeroCorrecto=Integer.parseInt(binding.myNumber.text.toString())
            compararNumeros(numeroCorrecto)
        }

    }
    private fun compararNumeros(numero:Int){
        if (numeroRandom !=-1){
            if(numero == numeroRandom){
                //Toast.makeText(this,"numero encontrado",Toast.LENGTH_SHORT).show()
                alertDialogCorrect()
                numeroRandom=-1

            }else if(numero>numeroRandom){

                alertDialogWrong("el numero debe ser menor")
                vidas --
            }else if(numero<numeroRandom){

                alertDialogWrong("el numero debe ser mayor")
                vidas --
            }
            if(vidas ==2){
                binding.imageView.setImageResource(R.drawable.dosvidas)
            } else if(vidas==1){
                binding.imageView.setImageResource(R.drawable.unavida)
            } else if(vidas==0){
                binding.imageView.setImageResource(0)
                val dialog=AlertDialog.Builder(this)
                dialog.setMessage("Gracias por jugar....el juego ha terminado")
                dialog.setIcon(R.drawable.ic_iconrandom)
                dialog.setTitle("Juego terminado")
                dialog.setPositiveButton("Aceptar"){dialog,which->
                    dialog.dismiss()
                }
                dialog.setCancelable(false)
                val builder=dialog.create()
                builder.show()
            }

        }else{
            Toast.makeText(this,"Primero debes generar un numero aletorio",Toast.LENGTH_SHORT).show()
        }

    }

    private fun getNumber():Boolean{
        val numero=binding.myNumber.text.toString()
        if(numero.isNullOrEmpty()){
            Toast.makeText(this,"Ingrese un numero entero",Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun alertDialogWrong(message:String){
        val dialog=AlertDialog.Builder(this)
        dialog.setTitle("Numero equivocado")
        dialog.setIcon(R.drawable.ic_cancel)

        val view=LayoutInflater.from(this).inflate(R.layout.wrong_answer,null)
        dialog.setView(view)
        dialog.setMessage(message)
        dialog.setPositiveButton("ACEPTAR"){dialog,which->
            dialog.dismiss()

        }

        val alert=dialog.create()
        alert.show()
        alert.setCancelable(false)
    }

    private fun alertDialogCorrect(){

            val dialog=AlertDialog.Builder(this)
            dialog.setTitle("Numero Correcto")
            dialog.setIcon(R.drawable.ic_cancel)

            val view=LayoutInflater.from(this).inflate(R.layout.correct_answer,null)
            dialog.setView(view)
            dialog.setPositiveButton("ACEPTAR"){dialog,which->
                dialog.dismiss()

            }

            val alert=dialog.create()
            alert.show()
            alert.setCancelable(false)
        }

}