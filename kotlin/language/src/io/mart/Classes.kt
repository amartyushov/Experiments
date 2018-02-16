package io.mart


fun main(args: Array<String>) {
    val worker = WorkerGetSet("John")
    println(worker.fullTime)
}

// ---------------------------------------------------
class Worker constructor(firstName: String) {
    val firstName: String

    init {
        this.firstName = firstName
    }
}

class WorkerShort constructor(firstName: String) {
    val firstName: String = firstName
}

class WorkerShortest constructor(val firstName: String) // this is called primary constructor.
// And only he can declare class fields within this short form
// because here constructor actually declares class field firstName

class WorkerShortest2(val firstName: String) // constructor is public in this case

// ---------------------------------------------------

class WorkerTwoParams(val name: String) {
    var fullTime: Boolean = true

    constructor(name: String, fullTime: Boolean) : this(name) { // secondary constractor has to delegate for to primary constractor
        this.fullTime = fullTime
    }
}

class WorkerTwoParamsDefaultvalue(val name: String, var fullTime: Boolean = true)

// ---------------------------------------------------

class WorkerPrivate(val name: String, private var fullTime: Boolean = true)
// getters and setters are generated
// getters and setters has same access level as a field

// if you want to encapsulate private property and have a getter => implement it by your own
class WorkerGetSet(val name: String, fullTime: Boolean = true) {
    var fullTime = fullTime
    get() {
        println("Running custom get")
        return field // you reference to the field here. This block must go after field declaration
        // but you still call it worker.fullTime
    }
    set(value) {
        println("Running custom set")
        field = value
    }
}

