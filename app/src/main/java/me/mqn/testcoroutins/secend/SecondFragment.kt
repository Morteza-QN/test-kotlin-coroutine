package me.mqn.testcoroutins.secend

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import me.mqn.testcoroutins.R
import me.mqn.testcoroutins.base.BaseFragment

class SecondFragment : BaseFragment() {

    companion object {

        private const val TAG = "SecondFragment"
    }

    private val viewModel: SecondViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_secend, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        viewModel.startCoroutineSecond()
    }
}