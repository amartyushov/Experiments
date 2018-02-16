package io.mart

interface MyInterface {
    val num: Int        // interface can also have abstract property, which needs to be implemented
    //val num2: Int = 30  // you can not do it directly, but you can do it with getter
    val num2: Int
        get() = 30      // you can not you backing field

    fun MyFunction (str : String) : String
}

interface MyChildInterface : MyInterface {   // you do not need open keyword
    fun MyChildFunction (num : Int) : String

}

class MyClass : MyChildInterface {
    override val num: Int = 25

    override fun MyFunction(str: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun MyChildFunction(num: Int): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}