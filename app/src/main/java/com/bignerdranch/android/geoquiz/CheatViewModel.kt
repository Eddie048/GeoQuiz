package com.bignerdranch.android.geoquiz

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

const val IS_CHEATER_KEY_OTHER = "IS_CHEATER_KEY_OTHER"

class CheatViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    var isCheater: Boolean
        get() = savedStateHandle.get(IS_CHEATER_KEY_OTHER) ?: false
        set(value) = savedStateHandle.set(IS_CHEATER_KEY_OTHER, value)

}
