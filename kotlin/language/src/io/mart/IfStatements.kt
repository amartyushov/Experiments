package io.mart

fun main(args: Array<String>) {

    val condition = 69 < 22

    val num1 = if (condition) 50 else 100

    val num3 = if (condition) {
        println("smth")
        50
    } else {
        println("bla")
        345
    }

    println(num3)

    // you can also do following
    println(
            if (condition) {
                println("smth")
                50
            } else {
                println("bla")
                345
            }
    )

}