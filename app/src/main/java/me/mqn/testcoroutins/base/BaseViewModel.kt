package me.mqn.testcoroutins.base

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

abstract class BaseViewModel : ViewModel() {

    companion object {

        private const val TAG = "BaseViewModel"
    }

    init {
        Log.v(TAG, "init base view model")
    }

    protected val scope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    protected val mExceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        Log.e(
            TAG,
            ">>> Exception handled base ViewModel:" +
                    "\n>>> coroutineContext = $coroutineContext " +
                    "\n>>> throwable: $throwable"
        )
        // 1. Trigger event to prompt error dialog
        // 2. Log to tracking system for observability
    }

    override fun onCleared() {
        super.onCleared()

        Log.v(TAG, ">>> onCleared base view model")
        scope.cancel()
    }
}