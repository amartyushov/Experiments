package io.mart

import java.math.BigDecimal

fun main(args: Array<String>) {

    val names = arrayOf("A", "B", "C")

    val longs = arrayOf(1L, 2L, 3L)
    val longs2 = arrayOf<Long>(1,2,3,4)
    val ints = arrayOf(1,2,3,4)

    val evenNum = Array(16) {i -> i * 2}

    for (num in evenNum) {
        //println(num)
    }

    var someArray: Array<Int>
    someArray = arrayOf(1,2,3,4)
    someArray = Array(6){i -> (i+1)*10}

    val mixed = arrayOf("hello", 22, BigDecimal(10.5))

    val array1 = arrayOf(1,2,3)
    //DummyClass().printArray(array1) // type mismatch
    val array1int = intArrayOf(1,2,3) // for arrays of primitives from java
    DummyClass().printArray(array1int)


}