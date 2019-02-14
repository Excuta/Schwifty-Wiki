package com.excuta.schwiftypedia

import android.app.Application
import com.excuta.schwiftypedia.core.component.CoreComponent
import com.excuta.schwiftypedia.core.component.DaggerCoreComponent

class SchwiftyApp : Application() {
    private lateinit var coreComponent: CoreComponent
    override fun onCreate() {
        super.onCreate()
        var coreComponent = DaggerCoreComponent.builder()
            .appContext(applicationContext)
            .loggingNetworkTag("SchwiftyNetwork")
            .retrofitBaseUrl("")
            .build()
    }
}