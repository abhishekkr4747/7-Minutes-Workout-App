
// Import the required classes
package com.example.notesapp_internshala.acitivity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.notesapp_internshala.R
import com.example.notesapp_internshala.fragments.NotesFragment

// Define the MainActivity class
class MainActivity : AppCompatActivity() {
    // Initialize a variable to track whether the back button has been pressed once
    private var backPressedOnce = false

    // Override the onCreate method
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set the content view
        setContentView(R.layout.activity_main)

        // Initialize the NavController
        val navController: NavController
        // Get the NavHostFragment
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        // Get the NavController from the NavHostFragment
        navController = navHostFragment.navController
        // Set the graph for the NavController
        navController.setGraph(R.navigation.nav_graph)
    }

    // Override the onBackPressed method
    override fun onBackPressed() {
        // Check if the current fragment is NotesFragment
        val currentFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
        if (currentFragment is NotesFragment) {
            // Check if the back button has been pressed once
            if (backPressedOnce) {
                // If the back button has been pressed once, exit the application
                super.onBackPressed()
            } else {
                // If the back button has not been pressed once, show a message and reset the flag after a delay
                Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show()
                backPressedOnce = true
                Handler().postDelayed({
                    backPressedOnce = false
                }, 2000)
            }
        } else {
            // If the current fragment is not NotesFragment, proceed with the default behavior
            super.onBackPressed()
        }
    }
}
