package io.mart

fun main(args: Array<String>) {

    val setInts = setOf(10, 12, 13)
    println(setInts.plus(99))
    println(setInts.plus(999)) // change nothing : no duplicates
    println(setInts.minus(99))

    val setIntsMutable = mutableSetOf(10, 12, 13)
    setIntsMutable.plus(10)




}