package io.mart

fun main(args: Array<String>) {

    val range = 1..50
    val rangeStep = range.step(5)
    val charRahge = 'a'..'z'        // everythins what is comparable can be used as a range

    val backwardRahge = 5.downTo(1)

    println(2 in range)
    println('b' in charRahge)
    println(4 in backwardRahge)

    for (i in rangeStep){
        //println(i)
    }

    val str = "hello"       // you can you everything what has iterator in for loop
    for (n in str) {
        //println(n)
    }

    for (m in 0..6 step 2){
        //println(m)
    }

    for (m in 20 downTo 2 step 4){
        //println(m)
    }

    for (m in 1 until 5){   // here 5 is exclusive [1..5)
        //println(m)
    }

    val seasons = arrayOf("s", "a", "w")
    for (m in seasons){
    }
    for (i in seasons.indices){
        //println("${seasons[i]} has index $i")
    }
    //seasons.forEach { println(it) }
    //seasons.forEachIndexed { i, value -> println("$value has index $i") }

    for (i in 1..3) {
        println("i = $i")
        jloop@ for (j in 1..4) {        // you can give names to loops
            println("j = $j")
            for (k in 5..10){
                println("k = $k")
                if (k == 7) {
                    break@jloop;
                }
            }
        }
    }


    val notInRange = 32 !in 1..10
}
