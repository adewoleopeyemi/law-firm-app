package com.example.successsynergyapp

import android.os.Bundle
import androidx.databinding.DataBindingUtil.setContentView
import com.example.successsynergyapp.R
import com.example.successsynergyapp.extensions.addFragment
import com.example.successsynergyapp.auth.Theme6BaseActivity
import com.example.successsynergyapp.dashboard.HomeFragment

class MainActivity : Theme6BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment(HomeFragment(), R.id.frameLayout)
    }

}
