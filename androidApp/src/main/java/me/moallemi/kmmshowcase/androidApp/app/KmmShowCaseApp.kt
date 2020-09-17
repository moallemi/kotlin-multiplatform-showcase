package me.moallemi.kmmshowcase.androidApp.app

import android.app.Application
import android.content.Context
import me.moallemi.kmmshowcase.shared.di.initKoin
import org.koin.dsl.module

class KmmShowCaseApp : Application() {

    override fun onCreate() {
        super.onCreate()

        initializeKoin()
    }

    private fun initializeKoin() {
        initKoin(
            module {
                single<Context> { this@KmmShowCaseApp.applicationContext }
            }
        )
    }

}