package io.mart

fun main(args: Array<String>) {
    //println(labelMultiplyDefValue(3,4))
    //println(labelMultiplyDefValue(label = "Bla", operand1 = 3, operand2 = 4))  // you can mix order of params, but specify them
    // this is called named arguments

    val rab = Rab("Alex")
    //println(rab.uppCase())

    val moto1 = Moto("blue", 1908)
    val moto2 = Moto("red", 1988)
    val moto3 = Moto("yellow", 1998)

    //printYearsWithStr(moto1, moto2, moto3, str = "My string") // usage of varagrs + normal param

    val manyMoto = arrayOf(moto1, moto2, moto3)
    //printYears(manyMoto) it does not work
    //printYears(*manyMoto) //it works, it is unpacking

    // unpacking arrays
    val moreMotos = arrayOf(moto1, moto3)
    val moto4 = moto3.copy()
    val collector = arrayOf(manyMoto, moreMotos, moto1) // now collector will have three elements: array, array, moto1
    val collectorUnpacked = arrayOf(*manyMoto, *moreMotos, moto1) // now collector will have 6 motos inside
    for (c in collectorUnpacked) {
        println(c)
    }
}

fun labelMultiply(operand1: Int, operand2: Int, label: String) : String {  // this is block body
    return ("$label ${operand1 * operand2}")
}

fun labelMultiplyDefValue(operand1: Int, operand2: Int,
                          label: String = "The answer is: ") : String {  // default value for label
    return ("$label ${operand1 * operand2}")
}

fun labelMultiplySimplified(operand1: Int, operand2: Int, label: String) = // you dont need return type
    "$label ${operand1 * operand2}"
// this is called expression body





class Rab(val name: String) {
    fun uppCase() = name.toUpperCase()
}




data class Moto(val color: String, val year: Int)

fun printYears(vararg motos: Moto){
    for (moto in motos){
        println(moto.year)
    }
}

fun printYearsWithStr(vararg motos: Moto, str: String){
    for (moto in motos){
        println(moto.year)
    }
}
