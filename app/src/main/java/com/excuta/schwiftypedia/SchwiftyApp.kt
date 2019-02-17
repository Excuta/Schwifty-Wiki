package com.excuta.schwiftypedia

import android.app.Application
import com.excuta.core.component.CoreComponent
import com.excuta.core.component.DaggerCoreComponent

typealias CoreComponentOwner = CoreComponent.Owner

class SchwiftyApp : Application(), CoreComponentOwner {

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

fun Application.ifCoreComponentProvider(
    ifBlock: CoreComponentOwner.() -> Unit,
    elseBlock: Application.() -> Unit = {}
) {
    val owner = this as? CoreComponentOwner
    if (owner != null) {
        owner.ifBlock()
    } else {
        this.elseBlock()
    }
}
