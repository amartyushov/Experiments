package io.mart

fun main(args: Array<String>) {

    val str: String? = "this can be null"
    str?.toUpperCase() // this is a short form of (see below). ? just tells, it can be null
    // if str is null => all expression is null

    /*if (str != null) {
    *   str.toUpperCase()
    * }
    */

    str!!.toUpperCase() // if you are 100% sure that str is not null, you can tell Kotlin about it by !!. Equivalent is
/*    if (str == null) {
        throw exception
    } else {
        str.toUpperCase()
    }*/

    val str20 = str ?: "This is a default value"
    // elvis operator, it means, you want to assign str value to str2, but if str = nul => use default value


    val str1: String? = null
    val str2 = str!!                // in this case exceprion will be thrown from this line
    val str3 = str2.toUpperCase()

    // ---------------------------------------------------------------------------------------------

    str1?.let { printMe(it)} // this is an equivalent to
    /*if (str1 != null) {
        printMe(str1)
    }*/

    // ---------------------------------------------------------------------------------------------

    val nullableIntArray = arrayOfNulls<Int?>(5) //i may not to ini this array right now => you have nulls in each cell
    nullableIntArray[3].toString()
}

fun printMe(text: String){
    print(text)
}