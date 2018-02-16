package io.mart

typealias EmployeeSet = Set<Employee> // you just save your typing time

fun main(args: Array<String>) {
    // val - like final, can not assign multiple times. Kotlin best practice is to use immutable variables
    val number = 25 // compiler under the hood makes it integer
    val num: Int
    num = 10
    // num = 23 : error => assigning second time
    val n: Short = 25 // you make both: explicitly specify type and set a value => to make 25 explicilty Short (but not integer)

    var mutableNum: Int
    mutableNum = 20
    mutableNum = 30
    // underscope tips that this is mutable variable


    // ---------------------------------------------------------------------------------------------


    val employee1 = Employee("Lynn", 500) // you cannot assign diff Employee to employee1
    // employee1 = Employee("Alex", 1) compilation error
    employee1.name = "Bran"
    //employee1.id = 13 compilation error, because of "val id: Int"


    // ---------------------------------------------------------------------------------------------


    val emp: EmployeeSet // usage of typealias


    // ---------------------------------------------------------------------------------------------

    var newEmployee: Any = employee1
    if (newEmployee is Employee) {
        newEmployee.name = "Alex" // this is smart casting
        val castedEmployee = newEmployee as Employee // this is explicit casting
    }


    // ---------------------------------------------------------------------------------------------
    // String template


    val change = 4.22
    //println("Change is $change") // Change is $$change => Change is $4.22

    val a = 10
    val b = 2
    //println("$a divided by $b is ${a/b}")


    // ---------------------------------------------------------------------------------------------
    // raw String


    val poerty = """One
        |$a
        |Three
        |Four""".trimMargin()
    //println(poerty)

    // ---------------------------------------------------------------------------------------------
    // equality


    val car1 = Car("Ford")
    val car2 = Car("Lada")
    val car3 = Car("Lada")

    //println(car1 == car2)  // structural
    //println(car2 == car3)
    //println(car1 === car2) // referenctial
    //println(car2 === car3)

    val str = "Hello"
    val str1 = "Hello"
    println(str === str1) // in Kotlin it is true, because you have pool of strings

}

class Employee(var name: String, val id: Int)

class Car(var name: String) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Car

        if (name != other.name) return false

        return true
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }
}