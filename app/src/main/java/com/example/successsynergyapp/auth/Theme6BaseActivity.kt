package com.example.successsynergyapp.auth

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.successsynergyapp.extensions.lightStatusBar
import io.github.inflationx.viewpump.ViewPumpContextWrapper

open class Theme6BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lightStatusBar()
        supportActionBar?.hide()
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase!!))
    }
}