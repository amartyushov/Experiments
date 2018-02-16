package io.mart

import com.google.inject.AbstractModule
import com.google.inject.Guice
import java.util.logging.Logger
import javax.inject.Inject


class ConstractorInjection() {

    @Inject
    var logger: Logger? = null

    lateinit var communicator: Communicator;

    @Inject
    constructor(communicator: Communicator) : this() {
        this.communicator = communicator
        logger?.info("Inside of constractor")       // actually value is not injected
    }

    fun sendMessage(message: String): Boolean? = communicator.sendMessage(message)
}

class ConstractorInjection2 @Inject constructor(var communicator: Communicator) {

    fun sendMessage(message: String): Boolean? = communicator.sendMessage(message)
}


fun main(args: Array<String>) {
    val injector = Guice.createInjector(ConstractorInjectionModule())
    val comms = injector.getInstance(ConstractorInjection::class.java)
    val comms2 = injector.getInstance(ConstractorInjection2::class.java)
    comms.sendMessage("Hello")
    comms2.sendMessage("Hello")
}

class ConstractorInjectionModule : AbstractModule() {
    override fun configure() {
        bind(Communicator::class.java).to(DefaultCommunicatorImpl::class.java)
    }
}



