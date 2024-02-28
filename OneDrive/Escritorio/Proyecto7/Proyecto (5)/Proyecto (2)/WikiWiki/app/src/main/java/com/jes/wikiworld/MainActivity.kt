package com.jes.wikiworld
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.jes.wikiworld.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar el NavController y el AppBarConfiguration
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController

        // Configurar el AppBarConfiguration con las opciones del menú
        appBarConfiguration = AppBarConfiguration.Builder(
            R.id.itemListFragment,
            R.id.favItemListFragment,
            R.id.userInfoText
        ).build()

        // Configurar ActionBar con NavController y AppBarConfiguration
        setupActionBarWithNavController(navController, appBarConfiguration)

        // Vincular el menú inferior con el NavController
        binding.bottomNavigationView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        // Manejar la acción de navegación hacia arriba
        return navController.navigateUp() || super.onSupportNavigateUp()
    }


    override fun onBackPressed() {
        // Verificar si se puede retroceder en el NavController
        if (!navController.popBackStack()) {
            // Si no hay más elementos en la pila de retroceso, ejecutar el comportamiento predeterminado de onBackPressed
            super.onBackPressed()
        }
    }



    
    override fun onRestart() {
        super.onRestart()
        Log.d(LIFE_CYCLE, "La Activity ha sido reiniciada (Restarted)")
    }

    override fun onStart() {
        super.onStart()
        Log.d(LIFE_CYCLE, "La Activity ha sido iniciada (Started)")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LIFE_CYCLE, "La Activity ha pasado a primer plano (Resumed)")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LIFE_CYCLE, "La Activity ha sido pausada (Paused)")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LIFE_CYCLE, "La Activity ha sido parada (Stopped)")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LIFE_CYCLE, "La Activity ha sido destruida (Destroyed)")
    }

    companion object {
        const val LIFE_CYCLE = "LifeCycle"
    }
}

