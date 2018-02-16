package io.mart

import com.google.inject.AbstractModule
import com.google.inject.Guice
import com.google.inject.name.Named
import com.google.inject.name.Names
import javax.inject.Inject

class CommunicationNamed() {

    @Inject
    @Named("NamedImpl")
    var communicator: Communicator? = null;

    fun sendMessage(message: String): Boolean? = communicator?.sendMessage(message)
}

fun main(args: Array<String>) {
    val injector = Guice.createInjector(BasicModuleNamed())
    val comms = injector.getInstance(CommunicationNamed::class.java)
    comms.sendMessage("Hello annotated")
}

class BasicModuleNamed : AbstractModule() {
    override fun configure() {
        bind(Communicator::class.java)
                .annotatedWith(Names.named("NamedImpl"))
                .to(AnnotatedCommunicatorImpl::class.java)
    }
}