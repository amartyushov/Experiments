package io.mart

fun <T> List<T>.printCollection() {         // extension fun with generics
    for (i in this) {
        println(i)
    }
}


fun <T: Number> convertToInt(collection: List<T>) {  // only childs of Number are accepted
    for (num in collection) {
        println("${num.toInt()}")
    }
}
// here by default T is nullable (with ?)



fun <T: Any> a(collection: List<T>) {
    // but here already you can use only nonNullable type
    // if you want to make nullable as well => T: Any?
}


fun <T> append(item: T, item2: T)
    where T: CharSequence, T: Appendable {
    println("Result is ${item.append(item2)}")
}


inline fun <reified T> getElementsOfType(list: List<Any>): List<T> {
    var newList: MutableList<T> = mutableListOf()
    for (i in list) {
        if (i is T) {
            newList.add(i)
        }
    }
    return newList
}