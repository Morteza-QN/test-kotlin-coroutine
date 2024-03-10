package me.mqn.testcoroutins.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import me.mqn.testcoroutins.R
import me.mqn.testcoroutins.base.BaseFragment

class FirstFragment : BaseFragment() {

    companion object {

        private const val TAG = "FirstFragment"
    }

    private val viewModel: FirstViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val root = view.findViewById<LinearLayout>(R.id.root)

        root.addButton(label = "next") {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }
    }
}