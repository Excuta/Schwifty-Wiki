package com.excuta.schwiftypedia

import android.app.Application
import com.excuta.schwiftypedia.core.component.CoreComponent
import com.excuta.schwiftypedia.core.component.DaggerCoreComponent

typealias CoreComponentProvider = CoreComponent.Owner

class SchwiftyApp : Application(), CoreComponentProvider {

    override fun get(): CoreComponent {
        return coreComponent
    }

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

fun Application.ifCoreComponentProvider(ifBlock: () -> Unit, elseBlock: () -> Unit = {}) {
    if (this::class.isInstance(CoreComponentProvider::class)) {
        ifBlock()
    } else {
        elseBlock()
    }
}
