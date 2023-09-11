package com.github.luismendes070.tictactoegame.ui

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.github.luismendes070.tictactoegame.R
import com.github.luismendes070.tictactoegame.databinding.ActivityLicensesScrollingBinding

class LicensesScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLicensesScrollingBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        try{

            super.onCreate(savedInstanceState)

            binding = ActivityLicensesScrollingBinding.inflate(layoutInflater)
            setContentView(binding.root)

            setSupportActionBar(findViewById(R.id.toolbar))
            binding.toolbarLayout.title = title
            binding.fab.setOnClickListener { view ->
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }

        }
        catch (e: java.lang.IllegalStateException){
            e.printStackTrace()
        }
        catch (e:Exception){

        }finally {

        }

    }
}
