package io.mart

fun main(args: Array<String>) {

    //println(countTo100())

    "string".apply somestring@{
        "another".apply {
            println(toLowerCase())
            println(this@somestring.toUpperCase())
        }
    }

}

/*fun countTo100(): String {
    val numbers = StringBuilder()
    for (i in 1..99) {
        numbers.append(i).append(", ")
    }
    numbers.append(100)
    return numbers.toString()
}*/

/*fun countTo100() =
        with(StringBuilder()) {
            for (i in 1..99) {
                append(i).append(", ")
            }
            append(100)
            toString()
        }*/


fun countTo100() =
        StringBuilder().apply {
            for (i in 1..99) {
                append(i).append(", ")
            }
            append(100)
        }.toString()

fun findBy(dogs: List<Dog>, name: String) {
    dogs.forEach returnBlock@ {
        if (it.firstName == name) {
            println("dog is found")
            return@returnBlock      // here if you find a dog => you just leave lambda and continue with method
            // return               // in THIS case you just quit a method
        }
        println("dog is not found")
    }
}


