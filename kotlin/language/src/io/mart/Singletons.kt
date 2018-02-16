package io.mart

import java.time.Year

fun main(args: Array<String>) {
    println(Singletons.getTagLine())
    println(Singletons.getCopyrightLine())

    SomeClass.SomeCompanion.accessPrivateVarCO()
    SomeClass.accessPrivateVarCO() // you can also call it like this

    val smClass1 = SomeClass.justAssign("bla")
    val smClass2 = SomeClass.upperOrLowerCase("bla", false)
    println(smClass1.someString)
    println(smClass2.someString)
}


// constructors do not make sense
// instance is created out of the box
// can extend classes
object Singletons {

    val currentYear = Year.now().value

    fun getTagLine() = "Company rocks"
    fun getCopyrightLine() = "Copyright \u00A9 $currentYear"
}

// you can not reach accessPrivateVar() as static java way, without creating an instance
// you can create companion objects inside of class to reach stuff inside without instance creation
class SomeClass private constructor(val someString: String) { // in order to not create object using constructor, but using factory

    companion object SomeCompanion{  // you can reach accessPrivateVarCO without instance (like static)
        private val privateVarCO = 16

        fun accessPrivateVarCO(){
            println("Accessing private var $privateVarCO")
        }

        // below are factories for class
        fun justAssign(string: String) : SomeClass = SomeClass(string)
        fun upperOrLowerCase(string: String, lowerCase: Boolean) : SomeClass {
            if (lowerCase) {
                return SomeClass(string.toLowerCase())
            } else {
                return SomeClass(string.toUpperCase())

            }
        }
    }
}

