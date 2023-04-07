package com.example.survey

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.guestlist.R

const val PALESTINE_COUNT_KEY = "palestine-count-bundle-key"
const val ISRAEL_COUNT_KEY = "israel-count-bundle-key"

class MainActivity : AppCompatActivity() {

    //*******My stuff
    lateinit var palestineButton: Button
    lateinit var israelButton: Button
    lateinit var palestineCount: TextView
    lateinit var israelCount: TextView
    lateinit var clearCount: Button

    private val palestinianConflictViewModel: PalestinianConflictViewModel by lazy {
        ViewModelProvider(this).get(PalestinianConflictViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        palestineButton = findViewById(R.id.palestine_button)
        israelButton = findViewById(R.id.israel_button)
        palestineCount = findViewById(R.id.palestine_count)
        israelCount = findViewById(R.id.israel_count)
        clearCount = findViewById(R.id.clear_button)

        palestineButton.setOnClickListener {
            addPalestine()
        }

        israelButton.setOnClickListener {
            addIsrael()
        }

        clearCount.setOnClickListener {
            palestinianConflictViewModel.clearCount()
            updatePalestineCount()
            updateIsraelCount()
        }

        val savedLastGuestMessage = savedInstanceState?.getString(ISRAEL_COUNT_KEY)
        israelCount.text = savedLastGuestMessage

        updateIsraelCount()
        updatePalestineCount()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(ISRAEL_COUNT_KEY, israelCount.text.toString())
        outState.putString(PALESTINE_COUNT_KEY, palestineCount.text.toString())
    }

    private fun addPalestine() {
        palestinianConflictViewModel.addPalestine()
        updatePalestineCount()
    }

    private fun updatePalestineCount() {
        val pCount = palestinianConflictViewModel.getPalestine()
        val pCountDisplay = pCount.toString()
        palestineCount.text = pCountDisplay
    }


    private fun addIsrael() {
        palestinianConflictViewModel.addIsrael()
        updateIsraelCount()
    }

    private fun updateIsraelCount() {
        val iCount = palestinianConflictViewModel.getIsrael()
        val iCountDisplay = iCount.toString()
        israelCount.text = iCountDisplay
    }
}









