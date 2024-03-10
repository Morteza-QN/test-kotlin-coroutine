package me.mqn.testcoroutins.first

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.mqn.testcoroutins.base.BaseViewModel

class FirstViewModel : BaseViewModel() {

    companion object {

        private const val TAG = "FirstViewModel"
    }

    init {
        Log.d(TAG, ">>> init FirstViewModel")
    }

    fun startCoroutineFirst() {
        viewModelScope.launch(mExceptionHandler) {
            Log.d(TAG, ">>> startCoroutineFirst")
        }
    }
}