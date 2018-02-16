package io.mart

interface Inter {
    fun toImpl(num: Int): String
}

fun wantsInterface(si: Inter) {
    println("Printing from wantsInterface ${si.toImpl(22)}")
}

fun main(args: Array<String>) {

    var mutVar = 45

    wantsInterface(object: Inter {
        override fun toImpl(num: Int): String {
            mutVar++  // here you can acess vars
            return "This is ${num}"
        }
    })

    println(mutVar)
}