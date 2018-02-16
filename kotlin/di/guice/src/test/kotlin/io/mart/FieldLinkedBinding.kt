package io.mart

import com.google.inject.AbstractModule
import com.google.inject.Guice
import javax.inject.Inject


class FieldInjection() {

    @Inject
    var communicator: Communicator? = null;

    fun sendMessage(message: String): Boolean? = communicator?.sendMessage(message)
}

fun main(args: Array<String>) {
    val injector = Guice.createInjector(BasicModule())
    val comms = injector.getInstance(FieldInjection::class.java)
    comms.sendMessage("Hello")

    val comms2 = injector.getInstance(FieldInjection::class.java)
    comms.sendMessage("Hello")
}

class BasicModule : AbstractModule() {
    override fun configure() {
        bind(Communicator::class.java).to(DefaultCommunicatorImpl::class.java)//.`in`(Singleton::class.java)
    }
}



