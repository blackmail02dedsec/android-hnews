package com.example.myapplication.ui.fragmentfirst

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.R

class FragmentFirstFragment : Fragment() {

    companion object {
        fun newInstance() = FragmentFirstFragment()
    }

    private lateinit var viewModel: FragmentFirstViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_first_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(FragmentFirstViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
