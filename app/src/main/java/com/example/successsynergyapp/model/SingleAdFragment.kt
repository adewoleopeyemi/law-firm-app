package com.example.successsynergyapp.model

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.successsynergyapp.R
import com.example.successsynergyapp.databinding.FragmentSingleAdBinding


class SingleAdFragment(var image: String) : Fragment() {
    lateinit var binding: FragmentSingleAdBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_single_ad, container, false)
        Glide.with(requireContext()).load(image).placeholder(R.drawable.law_preview_3).into(binding.singleAd)
        return binding.root
    }

}