package io.mart

import java.math.BigDecimal

fun main(args: Array<String>) {

    var num = 500
    var num2 = 200
    val y = 10

    when(num) {
        100, 500 -> println(num)
        in 400..450 -> println("in range")
        y+70 -> println(num)
        200 -> println(num)
        300 -> println(num)
        else -> println("no match")
    }

    val obj: Any = "string"
    val obj2: Any = BigDecimal(25.2)
    val obj3: Any = 45

    val smth: Any = obj2

    val z = when(smth) {        // kotlin.Unit will be assigned
        is String -> println(smth.toUpperCase())
        is BigDecimal -> println(smth.remainder(BigDecimal(10.5)))
        is Int -> println("$smth - 22")
        else -> println("no match")
    }

    val time = Seas.AUTUMN
    val str = when(time){
        Seas.SPRING -> {
            num += 5
            "spring"
        }
        Seas.SUMMER -> "SUMMER"
        Seas.AUTUMN -> "AUTUMN"
        Seas.WINTER -> "WINTER"
    }
    println(str)

    when{
        num < num2 -> println("less")
        num > num2 -> println("more")
        num == num2 -> println("equal")
    }
}

enum class Seas {
    SPRING, SUMMER, AUTUMN, WINTER
}