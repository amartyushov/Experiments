package io.mart

import com.google.inject.AbstractModule
import com.google.inject.Guice
import com.google.inject.Provides
import com.google.inject.Singleton
import com.google.inject.name.Named
import javax.inject.Inject

interface Service {
    fun work(str: String)
}


class ServiceImpl : Service {
    override fun work(str: String) {
        println("ServiceImpl: $str")
    }
}

class Man @Inject constructor(@Named("forMan") var service: Service) {
    fun bla() = service.work("Man")
}

fun main(args: Array<String>) {
    val injector = Guice.createInjector(ProvidesMethodsModule())
    var man = injector.getInstance(Man::class.java)
    man.bla()

    var man2 = injector.getInstance(Man::class.java)
    man.bla()
}

// targeted binding
class ProvidesMethodsModule : AbstractModule() {
    override fun configure() {
    }

    @Provides
    @Named("forMan")
    @Singleton
    fun getService(): Service = ServiceImpl()
    // Named in this case just shows a possibilities
}

