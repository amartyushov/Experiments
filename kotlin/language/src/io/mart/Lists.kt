package io.mart

fun main(args: Array<String>) {

    val strings = listOf("spring", "summer", "summer", "fall", "winter")  // immutable list

    val emptyList = emptyList<String>()

    val notNullList = listOfNotNull("hello", null, "buy")
    //println(notNullList)

    val arrayList = arrayListOf(1,2,3)
    //println(arrayList.javaClass)

    val arrayList2 = mutableListOf<Int>(1,2,3)

    val array = arrayOf("a", "s", "r")
    val list = listOf(*array)
    val list2 = array.toList()
    //println(list2)

    println(strings.last())
    println(strings.asReversed())
    println(strings.getOrNull(5))       // trying to get 5th element

    val ints = listOf(1,2,3,4,5)
    println(ints.max())

    val mergeLIst = strings + ints

    val noDuplicates = strings.union(ints)
    println(noDuplicates)

    val noDupStrings = strings.distinct()
    println(noDupStrings)


}