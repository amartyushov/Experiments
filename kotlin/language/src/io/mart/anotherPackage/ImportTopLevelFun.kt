package io.mart.anotherPackage

import io.mart.Department as dep    // alias for import
import io.mart.Singletons
import io.mart.labelMultiply  // you import functions
import io.mart.upperFirstLast as exprFun   // alias for extention fun
import io.mart.labelMultiplyDefValue as def  // alias for fun import


fun main(args: Array<String>) {
    println(labelMultiply(1, 2, "bla"))

    println(Singletons.getCopyrightLine())

    println(dep.IT.getDepartInfo())

    println(def(1, 2))

    println("some".exprFun())
}