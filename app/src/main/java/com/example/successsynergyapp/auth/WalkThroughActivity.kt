package com.example.successsynergyapp.auth

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.successsynergyapp.R
import com.example.successsynergyapp.databinding.ActivityWalkThroughBinding
import com.example.successsynergyapp.utils.AllPermissionsUtils

class WalkThroughActivity : Theme6BaseActivity() {
    lateinit var binding: ActivityWalkThroughBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_walk_through)
        AllPermissionsUtils(this)
        val adapter = MyAdapter(supportFragmentManager, 2); binding.viewPager.adapter = adapter
    }

    inner class MyAdapter(fm: FragmentManager, private var totalTabs: Int) : FragmentPagerAdapter(fm) {
        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> WalkThroughFragment(1)
                1 -> WalkThroughFragment(2)
                else -> WalkThroughFragment(1)
            }
        }

        override fun getCount(): Int = totalTabs
    }
}