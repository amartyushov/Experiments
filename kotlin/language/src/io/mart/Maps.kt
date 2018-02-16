package io.mart

fun main(args: Array<String>) {

    val immuMap = mapOf(
            1 to House("red", 1980),
            2 to House("blue", 1950),
            3 to House("green", 1955)
    )

    println(immuMap.javaClass)
    println(immuMap)

    val mutableMap = mutableMapOf(                  // LinkedHashMap inside
            1 to House("red 1", 19801),
            2 to House("blue 1", 19501),
            3 to House("green 1", 19551)
    )

    for ((key, value) in mutableMap) {      // destructuring declaration
        println(key)
        println(value)
    }

    val pair = Pair(10, "ten")
    val (first, second) = pair

    val house = House("red", 1834)
    val (color, year) = house
    println("Color = $color, year = $year")

    val room = Room("red", 1834)
    val (color1, year1) = room
    println("Color = $color1, year = $year1")

}

class House (val color: String, val year: Int){
    // if you want to have destructuring declaration
    operator fun component1() = color
    operator fun component2() = year

    // for data classes destructuring declaration is out of the box
}

data class Room(val color: String, val year: Int)