package com.bignerdranch.android.geoquiz

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

private const val TAG = "CheatViewModel"
const val IS_CHEATER_KEY_CHEAT_ACTIVITY = "IS_CHEATER_KEY_CHEAT_ACTIVITY"

class CheatViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    var isCheater: Boolean
        get() = savedStateHandle.get(IS_CHEATER_KEY_CHEAT_ACTIVITY) ?: false
        set(value) = savedStateHandle.set(IS_CHEATER_KEY_CHEAT_ACTIVITY, value)

}
