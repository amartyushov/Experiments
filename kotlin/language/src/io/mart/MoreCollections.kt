package io.mart

fun main(args: Array<String>) {
    val setInts = setOf(10, 12, 13)

    val immuMap = mapOf(
            1 to House("red", 1980),
            2 to House("blue", 1950),
            3 to House("green", 1955)
    )

    println(setInts.filter { it % 2 != 0 })

    println(immuMap.filter { it.value.year == 1980 })

    val ints10 = arrayOf(1,2,3,4,5)

    val add10List1 = ints10.map { it + 10 }
    println(add10List1)

    println(immuMap.map { it.value.year })
    println(immuMap.filter { it.value.color == "red" }
            .map { it.value.year })

    println(immuMap.all { it.value.year > 1980 })   // false
    println(immuMap.all { it.value.year > 1080 })   // true
    println(immuMap.count { it.value.year > 1080 })
}