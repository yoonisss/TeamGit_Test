package com.example.k1109_chc_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.k1109_chc_test.databinding.FragmentBlank1Binding

class BlankFragment1 : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentBlank1Binding.inflate(inflater, container, false)
        return binding.root
    }


}