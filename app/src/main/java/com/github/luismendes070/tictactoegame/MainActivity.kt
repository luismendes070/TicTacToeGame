package com.github.luismendes070.tictactoegame

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.GridLayout
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.appcompat.app.AppCompatActivity
import com.github.luismendes070.tictactoegame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        try{

            super.onCreate(savedInstanceState)
            setContentView(binding.root)

            button = findViewById(R.id.button)

            button.setOnClickListener(){
                // Do something when the button is clicked
                Toast.makeText(this, "Clicked!", Toast.LENGTH_SHORT).show()
            }

            val gridLayout: GridLayout = findViewById(R.id.gridLayout)

            for (row in 0 until gridLayout.rowCount) {
                for (col in 0 until gridLayout.columnCount) {
                    val cellButton = Button(this)
                    cellButton.id = View.generateViewId()
                    cellButton.setBackgroundResource(R.drawable.tic_tac_toe_cell_bg)
                    cellButton.setOnClickListener { onCellClicked(row, col) }
                    gridLayout.addView(cellButton)
                }
            }

            val resetButton: Button = findViewById(R.id.resetButton)
            resetButton.setOnClickListener { resetGame() }

        }catch (e:Exception){

            e.printStackTrace()

        }finally {

        }

    } // end onCreate function

    private fun onCellClicked(row: Int, col: Int) {
        // Handle the cell click logic
    }

    private fun resetGame() {
        // Reset the game logic and UI
    }


    // ChatGPT
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        try {
            when (item.itemId) {
                R.id.nav_settings -> {
                    val navController = findNavController(R.id.nav_host_fragment_content_main)
                    navController.navigate(R.id.nav_settings)
                }
            }
        } catch (e: Exception) {
            // Handle the exception here
            Log.e(TAG, "Navigation error: ${e.message}")
            // Optionally, show a toast or display an error message to the user
            // Toast.makeText(this, "Navigation error: ${e.message}", Toast.LENGTH_SHORT).show()
        }

        return super.onOptionsItemSelected(item)
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}