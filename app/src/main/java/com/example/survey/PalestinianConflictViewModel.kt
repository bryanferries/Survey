package com.example.survey

import androidx.lifecycle.ViewModel

class PalestinianConflictViewModel: ViewModel() {


    private var palestineCount = 0
    private var israelCount = 0

    fun addPalestine() {
        palestineCount++
    }

    fun getPalestine(): Int {
        return palestineCount
    }

    fun addIsrael() {
        israelCount++
    }

    fun getIsrael(): Int {
        return israelCount
    }

    fun clearCount() {
        palestineCount = 0
        israelCount = 0
    }
}