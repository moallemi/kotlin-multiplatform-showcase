package me.moallemi.kmmshowcase.androidApp.app

import android.app.Application
import me.moallemi.kmmshowcase.shared.di.initKoin
import org.koin.android.ext.koin.androidContext

class KmmShowCaseApp : Application() {

    override fun onCreate() {
        super.onCreate()

        initializeKoin()
    }

    private fun initializeKoin() {
        initKoin {
            androidContext(this@KmmShowCaseApp)
        }
    }

}