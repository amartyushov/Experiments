package io.mart

import com.google.inject.*
import java.util.*
import kotlin.concurrent.thread

object ThreadScope : Scope {
    override fun <T : Any?> scope(key: Key<T?>, creator: Provider<T?>): Provider<T?> {
        return Provider {
            val cache = ThreadLocalCache.instance
            val value: T? = cache.get(key) ?: creator.get()
            cache.add(key, value)
            value
        }
    }
}

private class ThreadLocalCache {
    private val map = HashMap<Key<*>, Any>()
    operator fun <T> get(key: Key<T>): T {
        return map[key] as T
    }

    fun <T> add(key: Key<T>, value: T?) {
        map[key] = value as Any
    }

    companion object {
        // use lazy init to avoid memory overhead when not using the scope?
        val THREAD_LOCAL = object : ThreadLocal<ThreadLocalCache>() {
            override fun initialValue(): ThreadLocalCache {
                return ThreadLocalCache()
            }
        }
        val instance: ThreadLocalCache
            get() = THREAD_LOCAL.get()
    }
}

class HookExecutor {
    var flag: String = ""
    fun changeFlag(str: String) {
        this.flag = str
        println("Thread ${Thread.currentThread().name}: flag is $flag")
    }
}

fun main(args: Array<String>) {
    val injector = Guice.createInjector(ThreadSCopeModule())

    for (i in 1..3) {
        thread(start = true) {
            for (j in 1..6) {
                val executor = injector.getInstance(HookExecutor::class.java)
                println("Thread ${Thread.currentThread().name}. Executor $executor")
            }
        }
    }
}

// targeted binding
class ThreadSCopeModule : AbstractModule() {
    override fun configure() {
        bind(HookExecutor::class.java).`in`(ThreadScope)
    }
}