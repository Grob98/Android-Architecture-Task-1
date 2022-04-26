package de.hsfl.ella8493.taskone.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private var number: Int = 0

    fun getNumber() : Int {
        return this.number
    }

    fun setNumber(number: Int) {
        this.number = number
    }
}