package io.mart

fun main(args: Array<String>) {

    //println(getNum("22.5") ?: throw IllegalArgumentException("is not an int"))
    notImpl("sdf")
}

fun getNum(str: String): Int? {
    return try {
        Integer.parseInt(str)
    } catch (e: NumberFormatException) {
        //0
        null
    } finally {
        println("I am in finally")
        // 1 you can not return here a value
    }
}

fun notImpl(str: String): Nothing {
    throw IllegalArgumentException("Impl")
}