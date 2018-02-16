package io.mart

import com.google.inject.AbstractModule
import com.google.inject.Guice

class ConstructorBinding() {
    constructor(flag: Boolean) : this() {
        if (flag) {
            println("Flag was set")
        }
    }
}

fun main(args: Array<String>) {
    val injector = Guice.createInjector(ConstructorBindingModule())
    injector.getInstance(ConstructorBinding::class.java)
}

class ConstructorBindingModule : AbstractModule() {
    override fun configure() {
        bind(Boolean::class.java).toInstance(true)
        bind(ConstructorBinding::class.java).toConstructor(
                ConstructorBinding::class.java.getConstructor(Boolean::class.java))
        // untargeted binding
    }
}