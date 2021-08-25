package com.example.successsynergyapp.dashboard.form

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.successsynergyapp.R
import com.example.successsynergyapp.databinding.FragmentFormBinding
import com.example.successsynergyapp.extensions.onClick

class FormFragment : Fragment() {
    lateinit var binding: FragmentFormBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_form, container, false)
        binding.fbNewForm.onClick {
            startActivity(Intent(requireActivity(), UserFormActivity::class.java))
        }
        return binding.root
    }


}