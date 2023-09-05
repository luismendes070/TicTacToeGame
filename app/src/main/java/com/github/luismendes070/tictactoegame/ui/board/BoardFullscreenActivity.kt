package com.github.luismendes070.tictactoegame.ui.board

import androidx.appcompat.app.AppCompatActivity
import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MotionEvent
import android.view.View
import android.view.WindowInsets
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TableLayout
import android.widget.TextView
import com.github.luismendes070.tictactoegame.R
import com.github.luismendes070.tictactoegame.databinding.ActivityBoardFullscreenBinding

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class BoardFullscreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBoardFullscreenBinding
    private lateinit var fullscreenContent: TextView
    private lateinit var fullscreenContentControls: LinearLayout
    private val hideHandler = Handler(Looper.myLooper()!!)
    private var currentPlayer = "X"
    private val board = Array(3) { Array(3) { "" } }

    @SuppressLint("InlinedApi")
    private val hidePart2Runnable = Runnable {
        // Delayed removal of status and navigation bar
        if (Build.VERSION.SDK_INT >= 30) {
            fullscreenContent.windowInsetsController?.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
        } else {
            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            fullscreenContent.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LOW_PROFILE or
                        View.SYSTEM_UI_FLAG_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        }
    }
    private val showPart2Runnable = Runnable {
        // Delayed display of UI elements
        supportActionBar?.show()
        fullscreenContentControls.visibility = View.VISIBLE
    }
    private var isFullscreen: Boolean = false

    private val hideRunnable = Runnable { hide() }

    /**
     * Touch listener to use for in-layout UI controls to delay hiding the
     * system UI. This is to prevent the jarring behavior of controls going away
     * while interacting with activity UI.
     */
    private val delayHideTouchListener = View.OnTouchListener { view, motionEvent ->
        when (motionEvent.action) {
            MotionEvent.ACTION_DOWN -> if (AUTO_HIDE) {
                delayedHide(AUTO_HIDE_DELAY_MILLIS)
            }

            MotionEvent.ACTION_UP -> view.performClick()
            else -> {
            }
        }
        false
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {

        try{

            super.onCreate(savedInstanceState)

            binding = ActivityBoardFullscreenBinding.inflate(layoutInflater)
            setContentView(binding.root)

            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            isFullscreen = true

            // Set up the user interaction to manually show or hide the system UI.
            fullscreenContent = binding.fullscreenContent
            fullscreenContent.setOnClickListener { toggle() }

            fullscreenContentControls = binding.fullscreenContentControls

            // Upon interacting with UI controls, delay any scheduled hide()
            // operations to prevent the jarring behavior of controls going away
            // while interacting with the UI.
            binding.dummyButton.setOnTouchListener(delayHideTouchListener)

            val tableLayout = findViewById<TableLayout>(R.id.tableLayout)
            val button00 = findViewById<Button>(R.id.button00)


        }catch (e:Exception){

            e.printStackTrace()

        }finally {

        }

    } // end onCreate function

    // ChatGPT
    fun onCellClick(view: View) {
        if (view is Button) {
            val row = view.tag.toString().toInt() / 3
            val col = view.tag.toString().toInt() % 3

            if (board[row][col].isEmpty()) {
                view.text = currentPlayer
                board[row][col] = currentPlayer
                currentPlayer = if (currentPlayer == "X") "O" else "X"
            }

            if (checkForWin(row, col)) {
                // Handle game over logic (e.g., show a message, disable buttons)
            }
        }
    }

    private fun checkForWin(row: Int, col: Int): Boolean {
        // Implement your win-checking logic here
        // Check for rows, columns, and diagonals
        return false
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)


        try{

            // Trigger the initial hide() shortly after the activity has been
            // created, to briefly hint to the user that UI controls
            // are available.
            delayedHide(100)

        }catch (e:Exception){

        }finally {

        }

    }

    private fun toggle() {

        try{

            if (isFullscreen) {
                hide()
            } else {
                show()
            }

        }catch (e:Exception){

        }finally {

        }

    }

    private fun hide() {

        try{

            // Hide UI first
            supportActionBar?.hide()
            fullscreenContentControls.visibility = View.GONE
            isFullscreen = false

            // Schedule a runnable to remove the status and navigation bar after a delay
            hideHandler.removeCallbacks(showPart2Runnable)
            hideHandler.postDelayed(hidePart2Runnable, UI_ANIMATION_DELAY.toLong())

        }catch (e:Exception){
            e.printStackTrace()
        }finally {

        }

    }

    // ChatGPT
    private fun show() {
        runCatching {
            // Show the system bar
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                fullscreenContent.windowInsetsController?.show(
                    WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars()
                )
            } else {
                fullscreenContent.systemUiVisibility =
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                        View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
            }
            isFullscreen = true

            // Schedule a runnable to display UI elements after a delay
            hideHandler.removeCallbacks(hidePart2Runnable)
            hideHandler.postDelayed(showPart2Runnable, UI_ANIMATION_DELAY.toLong())
        }.onFailure { e ->
            e.printStackTrace()
        }
    }


    /**
     * Schedules a call to hide() in [delayMillis], canceling any
     * previously scheduled calls.
     */
    private fun delayedHide(delayMillis: Int) {
        hideHandler.removeCallbacks(hideRunnable)
        hideHandler.postDelayed(hideRunnable, delayMillis.toLong())
    }

    companion object {
        /**
         * Whether or not the system UI should be auto-hidden after
         * [AUTO_HIDE_DELAY_MILLIS] milliseconds.
         */
        private const val AUTO_HIDE = true

        /**
         * If [AUTO_HIDE] is set, the number of milliseconds to wait after
         * user interaction before hiding the system UI.
         */
        private const val AUTO_HIDE_DELAY_MILLIS = 3000

        /**
         * Some older devices needs a small delay between UI widget updates
         * and a change of the status and navigation bar.
         */
        private const val UI_ANIMATION_DELAY = 300
    }
}
