package io.mart

import com.google.inject.AbstractModule
import com.google.inject.Guice

/**
 * the dependency tree of the class will not be automatically wired.
 * You should limit the use of this mode
 * where there isn’t any heavy initialization or dependency injection necessary.
 */
class InstanceBinding() {
    constructor(flag: Boolean) : this() {
        if (flag) {
            println("Flag was set")
        }
    }
}

fun main(args: Array<String>) {
    val injector = Guice.createInjector(InstanceBindingModule())
    injector.getInstance(InstanceBinding::class.java)
}

// targeted binding
class InstanceBindingModule : AbstractModule() {
    override fun configure() {
        bind(InstanceBinding::class.java).toInstance(InstanceBinding(true))
    }
}