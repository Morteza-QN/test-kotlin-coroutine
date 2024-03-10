package me.mqn.testcoroutins.base

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    companion object {

        private const val TAG = "BaseFragment"
    }

    init {
        Log.v(TAG, "init base fragment")
    }

    protected fun ViewGroup.addButton(label: String, onclick: View.OnClickListener) {
        val button = Button(context)
        button.layoutParams =
            ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        button.text = label
        button.setOnClickListener(onclick)
        this.addView(button)
    }
}