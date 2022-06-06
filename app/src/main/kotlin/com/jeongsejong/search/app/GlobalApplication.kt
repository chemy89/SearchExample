package com.jeongsejong.search.app

import android.app.Application
import com.jeongsejong.search.network.ApiProvider
import com.jeongsejong.search.helper.PreferenceManager
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.dsl.module

/**
 * Created by jeongsejong on 2022/06/06
 */
class GlobalApplication : Application() {
    companion object {
        lateinit var instance: GlobalApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initApplicationSetting()
    }

    private fun initApplicationSetting() {
        val modules = module{
            single { ApiProvider() }
            single { PreferenceManager(this@GlobalApplication) }
        }

        startKoin {
            androidLogger()
            androidContext(this@GlobalApplication)
            modules(modules)
        }
    }

}