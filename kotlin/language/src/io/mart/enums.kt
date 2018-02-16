package io.mart

fun main(args: Array<String>) {
    println(Department.HR.getDepartInfo())
}

enum class Department(val myName: String, val numEmployee: Int) {
    HR("Human resources", 5),
    IT("Geeks", 100),
    SALES("Who sales", 20);

    fun getDepartInfo() = "The $myName has $numEmployee people"
}
