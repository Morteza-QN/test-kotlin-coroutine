package me.mqn.testcoroutins.secend

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import me.mqn.testcoroutins.Util.printStateComplete
import me.mqn.testcoroutins.Util.runCatching
import me.mqn.testcoroutins.base.BaseViewModel

class SecondViewModel : BaseViewModel() {

    companion object {

        private const val TAG = "SecondViewModel"
    }

    init {
        Log.d(TAG, ">>> init SecondViewModel")
    }

    fun startCoroutineSecond() {
        Log.d(TAG, ">>> startCoroutineSecond")
        viewModelScope.launch(mExceptionHandler) {
            Log.d(TAG, ">>> lunchCoroutineSecond")
            runCatching {
                delay(2000)
                throw IllegalArgumentException("A complete failure!")
            }
        }.printStateComplete("123654")
    }
}