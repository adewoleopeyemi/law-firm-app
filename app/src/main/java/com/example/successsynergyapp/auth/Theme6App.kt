package com.example.successsynergyapp.auth

import android.app.Application
import com.example.successsynergyapp.R
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump

open class Theme6App : Application() {

    override fun onCreate() {
        super.onCreate()
        app = this

        ViewPump.init(ViewPump.builder().addInterceptor(CalligraphyInterceptor(
                CalligraphyConfig.Builder().setDefaultFontPath(getString(R.string.t6_font_regular)).setFontAttrId(R.attr.fontPath).build())
        ).build())
    }

    companion object {
        lateinit var app: Theme6App

        fun getAppInstance(): Theme6App {
            return app
        }
    }
}