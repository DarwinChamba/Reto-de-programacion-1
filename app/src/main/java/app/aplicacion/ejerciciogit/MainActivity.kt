package app.aplicacion.ejerciciogit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        print("esta es una nueva version")
        print("segundo print ")
        print("tercer print")
        print("comentario de stash")

        print("comentario en la rama proyecto")
    }
}