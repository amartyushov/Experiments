package io.mart

import com.google.inject.AbstractModule
import com.google.inject.Guice
import javax.inject.Inject
import javax.inject.Provider

//When your @Provides methods start to grow complex, you may consider moving them to a class of their own.

interface Log {
    fun record(str: String)
}

class DbLog : Log {
    override fun record(str: String) {
        println("DbLog $str")
    }
}

interface Connection {
    fun connect(str: String)
}

class DbConnection : Connection {
    override fun connect(str: String) {
        println("DbConnection $str")
    }
}

class DbLogProvider : Provider<Log> {

    @Inject
    lateinit var connection: Connection

    override fun get(): Log {
        connection.connect("Connecting")
        return DbLog()
    }
}

class ProviderModule : AbstractModule() {
    override fun configure() {
        bind(Log::class.java).toProvider(DbLogProvider::class.java)
        bind(Connection::class.java).to(DbConnection::class.java)
    }
}

fun main(args: Array<String>) {
    val injector = Guice.createInjector(ProviderModule())
    var log = injector.getInstance(Log::class.java)
    log.record("Recording")
}
