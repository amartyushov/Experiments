package io.mart

fun main(args: Array<String>) {

    val myInt = 10              // integer
    var myLong = 22L            // long
    var myyLong: Long = 22      // long

    //myLong = myInt              // you can not do it in Kotlin, there is no automatic type widening
    myLong = myInt.toLong()       // this is correct

    val myByte: Byte = 111
    val myShort: Short

    var myDouble = 65.34
    var myFloat = 65.34f

    val char = 'd'
    val myChar = 65         // myChar.toChar() => A

    val myBool = true



}