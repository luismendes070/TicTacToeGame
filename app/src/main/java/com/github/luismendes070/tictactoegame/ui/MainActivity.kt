package com.github.luismendes070.tictactoegame.ui

// Bard sdk 34 permissions
import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import android.content.ContentValues.TAG
import android.content.Intent
import android.view.MenuItem
import android.widget.GridLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.github.luismendes070.tictactoegame.R
import com.github.luismendes070.tictactoegame.databinding.ActivityMainBinding
import com.github.luismendes070.tictactoegame.logic.TicTacToeGame
import com.github.luismendes070.tictactoegame.ui.board.BoardFullscreenActivity

class MainActivity : AppCompatActivity() {

    // Bard sdk 34 permissions
    private lateinit var btnPlay: Button
    private lateinit var btnLicenses: Button

    // ChatGPT
    private lateinit var appBarConfiguration: AppBarConfiguration

    private lateinit var binding: ActivityMainBinding

    private lateinit var button: Button
    private val ticTacToeGame = TicTacToeGame()

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {

        try{

            super.onCreate(savedInstanceState)
            // View Binding - 🔄 CONECTA VISTAS en Android con Kotlin - Tutorial Android Studio en
            // español https://youtu.be/yE2Y2q4iWpU
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            // Bard sdk 34 permissions
            // btnPlay = findViewById(R.id.btnPlay)

            binding.btnPlay.setOnClickListener {
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 100)

                } else {
                    startGame()

                    // Do something when the button is clicked
                    Toast.makeText(this, "Clicked!", Toast.LENGTH_SHORT).show()

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

                    btnLicenses = findViewById(R.id.btnLicenses)
                    btnLicenses.setOnClickListener {

                        // Create an Intent with the current activity as the context and the target activity class.
                        val intent = Intent(this, LicensesScrollingActivity::class.java)

// Optionally, you can pass data to the target activity using extras.
                        // intent.putExtra("key", "value")

// Start the new activity.
                        startActivity(intent)

                    }

                }
            }

        }catch (e:Exception){

            e.printStackTrace()

        }finally {

        }

    } // end onCreate function

    // Bard sdk 34 permissions
    @Suppress("UNCHECKED_CAST")
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 100 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            startGame()
        } else {
            Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun startGame() {
        Log.d("MainActivity", "Game started")
    }

    @Suppress("UNCHECKED_CAST")
    private fun onCellClicked(row: Int, col: Int) {

        try{

            val button00 = findViewById<Button>(R.id.button00)

            button00.setOnClickListener {

                // Handle the cell click logic
                ticTacToeGame.makeMove(row,col,'O')
                // ticTacToeGame.makeMove(row,col,"X")
                println("[$row][$col]")

                // Create an Intent with the current activity as the context and the target activity class.
                val intent = Intent(this, BoardFullscreenActivity::class.java)

// Optionally, you can pass data to the target activity using extras.
                // intent.putExtra("key", "value")

// Start the new activity.
                startActivity(intent)


            }

        }catch (e:Exception){

            e.printStackTrace()

        }finally {

        }

    }

    @Suppress("UNCHECKED_CAST")
    private fun resetGame() {
        // Reset the game logic and UI
    }


    // ChatGPT
    @Suppress("UNCHECKED_CAST")
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


    @Suppress("UNCHECKED_CAST")
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
