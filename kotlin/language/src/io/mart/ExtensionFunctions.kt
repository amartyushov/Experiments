package io.mart

// Here we "add" upperFirstLast functoin to String class
fun String.upperFirstLast(): String {
    val upperFirst = this.substring(0, 1).toUpperCase() + this.substring(1)
    return upperFirst.substring(0, this.length - 1) +
            upperFirst.substring(this.length - 1, this.length).toUpperCase()
} // actually "this" keyword can be deleted, and it will work

fun main(args: Array<String>) {
    val v = "this is a string"
    println(v.upperFirstLast())
}