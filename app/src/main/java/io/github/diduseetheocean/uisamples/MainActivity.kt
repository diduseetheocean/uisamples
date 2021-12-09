package io.github.diduseetheocean.uisamples

import android.os.Bundle
import android.widget.ImageView
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import io.github.diduseetheocean.uisamples.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            topLevelDestinationIds = setOf(
                R.id.navigation_home, R.id.navigation_notifications
            )
        )
        //val actionbar = findViewById<Toolbar>(R.id.toolbar)
        //setSupportActionBar(actionbar)
        //setupActionBarWithNavController(navController, appBarConfiguration)
        findViewById<ImageView>(R.id.toolbar_back_btn).setOnClickListener {
            navController.navigateUp()
        }
        navView.setupWithNavController(navController)
        navView.selectedItemId = R.id.navigation_dashboard
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp()
    }
}