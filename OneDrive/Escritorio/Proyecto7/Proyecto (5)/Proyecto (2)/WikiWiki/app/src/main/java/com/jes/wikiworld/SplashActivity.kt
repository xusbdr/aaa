package com.jes.wikiworld

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.widget.TextView
class SplashActivity : AppCompatActivity() {

    private val SPLASH_DISPLAY_LENGTH: Long = 3000 // Tiempo de visualización del splash en milisegundos (3 segundos)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // Crear un nuevo handler para manejar el retraso
        Handler().postDelayed({
            // Crear una nueva intención para abrir la MainActivity
            val mainIntent = Intent(this@SplashActivity, MainActivity::class.java)
            startActivity(mainIntent)
            finish() // Cerrar SplashActivity después de iniciar MainActivity
        }, SPLASH_DISPLAY_LENGTH)
    }
}