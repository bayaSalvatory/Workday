package com.workday

import android.app.Application
import com.workday.di.coreModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GifApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@GifApp)
            modules(listOf(coreModule))
        }
    }
}