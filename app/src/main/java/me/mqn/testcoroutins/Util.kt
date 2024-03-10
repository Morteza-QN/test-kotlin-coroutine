package me.mqn.testcoroutins

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.cancellation.CancellationException

object Util {

    fun LifecycleOwner.addRepeatingJob(
        state: Lifecycle.State,
        coroutineContext: CoroutineContext = EmptyCoroutineContext,
        block: suspend CoroutineScope.() -> Unit
    ): Job = lifecycleScope.launch(coroutineContext) {
        repeatOnLifecycle(state, block)
    }

    /*     fun Job.printOnComplete(message: String) {
            invokeOnCompletion {
                println(message)
            }
        } */

    fun Job.printStateComplete(message: String) {
        invokeOnCompletion { throwable ->
            when (throwable) {
                is CancellationException -> Log.i("stateComplete", "CancellationException")
                is Throwable             -> Log.e("stateComplete", "Job failed with exception! ${throwable.message}")
                null                     -> Log.d("stateComplete", "Job completed normally!")
                // else -> Log.e("stateComplete", ">>> error: ${throwable.message}")
            }
        }
    }

    inline fun <T, R> T.runCatching(block: T.() -> R): Result<R> {
        return try {
            Result.success(block())
        } catch (e: Throwable) {
            Log.e("runCatching", ">>> error: ${e.message}")
            Result.failure(e)
        }
    }
}