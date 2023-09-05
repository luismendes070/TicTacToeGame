package com.github.luismendes070.tictactoegame

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.GridLayout
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.appcompat.app.AppCompatActivity
import com.github.luismendes070.tictactoegame.databinding.ActivityMainBinding
import com.github.luismendes070.tictactoegame.logic.TicTacToeGame
import com.github.luismendes070.tictactoegame.ui.board.BoardFullscreenActivity

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var button: Button
    private val ticTacToeGame = TicTacToeGame()

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
