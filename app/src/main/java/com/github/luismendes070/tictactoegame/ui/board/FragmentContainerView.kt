package com.github.luismendes070.tictactoegame.ui.board

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.luismendes070.tictactoegame.R

class FragmentContainerView : Fragment() {

    companion object {
        fun newInstance() = FragmentContainerView()
    }

    private lateinit var viewModel: FragmentContainerViewViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_fragment_container_view, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FragmentContainerViewViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
