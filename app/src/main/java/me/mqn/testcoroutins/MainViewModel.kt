package me.mqn.testcoroutins

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.mqn.testcoroutins.base.BaseViewModel

class MainViewModel : BaseViewModel() {

    companion object {

        private const val TAG = "MainViewModel"
    }

    init {
        Log.d(TAG, ">>> init MainViewModel")
    }

    fun startCoroutine() {
        viewModelScope.launch(mExceptionHandler) {
            Log.d(TAG, ">>> startCoroutine")

        }
    }
}