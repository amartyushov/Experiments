package io.mart

fun main(args: Array<String>) {

}

open class Printer()
// if you want class to be extendable => add open keyword
// you need to specify primary constructor by ()

class LaserPrinter() : Printer()
// here you also declarer primary constructors

class BestPrinter : Printer {
    constructor() : super()
    // this is an alternative to how to solve problem with primary constractors
}

// ------------------------------------------------------------------------------

// this is how you can use params in constructors
// open can be substituted by abstract
abstract class Splitter(val name: String) {
    open fun split() = println("Splitter is $name") // in order to make it overridable

    abstract fun bestPrice(): Double
}

open class NewSplitter(name: String, ppm: Int) : Splitter(name) { // you do not have to match params in constructor with parent
    final override fun split() = println("New splitter is $name")

    override fun bestPrice(): Double = 129.22
}

class SpecialNewSplitter(name: String, ppm: Int) : NewSplitter(name, ppm) {
    //override fun split() = println("Special New splitter is $name") now it is impossible, because it is final in parent
}

// ------------------------------------------------------------------------------

// if you specify primary constructor for class, then any child has to delegate instantiation to this primary constructor
// but you can also work on the level of secondary constructors

open class Smth {
    val myval: String

    constructor(myval: String) {
        this.myval = myval
    }
}

class SmthElse : Smth {
    constructor(myval: String) : super(myval)  // here you delegate creation on the level of secondary constructors
}

// ------------------------------------------------------------------------------

//open data class DataClass (val num : Int) // data classes are closed, cannot extend it