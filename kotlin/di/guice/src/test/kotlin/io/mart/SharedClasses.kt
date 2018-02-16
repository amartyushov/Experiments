package io.mart

import com.google.inject.Singleton


interface Communicator {
    fun sendMessage(str: String): Boolean
}

@Singleton
class DefaultCommunicatorImpl : Communicator {
    override fun sendMessage(str: String): Boolean {
        println("DEFAULT: sending message $str")
        return true
    }
}

class AnnotatedCommunicatorImpl : Communicator {
    override fun sendMessage(str: String): Boolean {
        println("ANNOTATED: sending message $str")
        return true
    }
}