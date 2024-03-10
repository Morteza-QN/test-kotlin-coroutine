package me.mqn.testcoroutins

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import me.mqn.testcoroutins.base.BaseFragment

class MainFragment : BaseFragment() {

    companion object {

        private const val TAG = "MainFragment"
    }

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // addRepeatingJob(state = Lifecycle.State.STARTED) {}
        // addJob(state = Lifecycle.State.STARTED) {}}
        val root = view.findViewById<LinearLayout>(R.id.root)
        root.addButton(label = "next") {
            findNavController().navigate(R.id.action_mainFragment_to_firstFragment)
        }
    }
}