package io.mart

import com.google.inject.AbstractModule
import com.google.inject.Guice
import javax.inject.Inject

class MethodInjection() {

    var communicator: Communicator? = null

    @Inject
    fun setMe(communicator: Communicator) {
        this.communicator = communicator
    }

    fun sendMessage(str: String) =
            communicator?.sendMessage(str)
}

fun main(args: Array<String>) {
    val injector = Guice.createInjector(MethodInjectionModule())
    val comms = injector.getInstance(MethodInjection::class.java)
    comms.sendMessage("Hello")
}

class MethodInjectionModule : AbstractModule() {
    override fun configure() {
        bind(Communicator::class.java).to(DefaultCommunicatorImpl::class.java)
    }
}



