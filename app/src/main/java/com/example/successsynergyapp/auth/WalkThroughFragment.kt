package com.example.successsynergyapp.auth

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.databinding.DataBindingUtil
import com.example.successsynergyapp.MainActivity
import com.example.successsynergyapp.R
import com.example.successsynergyapp.databinding.FragmentWalkThroughBinding
import com.example.successsynergyapp.extensions.*

class WalkThroughFragment (var page: Int) : Fragment() {
    lateinit var binding : FragmentWalkThroughBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_walk_through, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.makeTransparent(); activity?.makeNormalStatusBar(R.color.T6transparent); activity?.lightNavigation(); activity?.makeNormalNavigationBar()
        binding.lblTripGo.text = "Success Synergy"
        when (page) {
            1 -> {
                binding.txtWalkTitle.text = "Find experienced lawyers"
                binding.txtWalkDesc.text = "If you need legal solutions, we can connect you solution providers. "
                binding.ivBackgroundImage.setImageDrawable(activity?.getDrawable(R.drawable.law_preview_3))
            }
            2 -> {
                binding.txtWalkTitle.text = "We offer you trusted and reliable services"
                binding.txtWalkDesc.text = "If you are a legal solutions provider, we provide te clients. "
                binding.ivBackgroundImage.setImageDrawable(activity?.getDrawable(R.drawable.law_preview_img))
            }
            3 -> {
                binding.txtWalkTitle.text = "We offer you trusted and reliable services"
                binding.txtWalkDesc.text = "Let us help you find the perfect match for your case."
                binding.ivBackgroundImage.setImageDrawable(activity?.getDrawable(R.drawable.law_preview_4))
            }
        }
        if (page == 1){
            binding.btnGetStarted.visibility = GONE
        }
        else{
            binding.btnGetStarted.text = "FINISH"
            binding.btnGetStarted.onClick { activity?.startActivity(Intent(context, UserTypeActivity::class.java)) }
            binding.btnSkip.visibility = GONE
        }
        binding.btnSkip.onClick { activity?.startActivity(Intent(context, UserTypeActivity::class.java)) }
    }
}