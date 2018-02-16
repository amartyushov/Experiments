package io.mart

data class Auto(val color: String, val model: String, val year: Int)
// toString, equals, copy, hashcode out of the box

fun main(args: Array<String>) {
    val car1 = Auto("red", "Ford", 1999)
    val car2 = Auto("red", "Ford", 1999)
    val car3 = car1.copy()
    val car4 = car1.copy(year = 1985) // copy with override

    println(car1)
    println(car1 == car2) // works correctly out of the box
    println(car1 == car3) // works correctly out of the box
}