package io.mart

fun main(args: Array<String>) {

    run { println("in lambda") }

    val dogs = listOf(
            Dog("a", 1),
            Dog("b", 2),
            Dog("c", 3)
    )

    println(dogs.minBy { d -> d.age })
    println(dogs.minBy { it.age })
    println(dogs.minBy(Dog::age))

    var num = 10
    run {
        num += 5        // can acess local variables
        println(num)
    }

    run(::dummy)

}

data class Dog(val firstName: String, val age: Int)

fun useParam (dogs: List<Dog>, num: Int) {
    dogs.forEach {
        println(it.firstName)
        println(num)
    }
}

fun dummy() = "I am in fun"