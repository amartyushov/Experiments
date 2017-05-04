package io.mart

/**
 * @author Aleksandr Martiushov
 */
class Structures {

    public static void main(String[] args) {
        def o = new Structures()
        o.strings()
    }

    void addToList(){
        def list = [1,2,3,4,5]
        println(list)

        list.add(10)
        println(list)

        list.add(2,20)
        println(list)
    }

    void contain() {
        def list = [1, 2, 3, 4, 5]
        println(list.contains(2))
        println(list.contains(20))
    }

    void minusList() {
        def list = [1, 2, 3, 4, 5]
        def result = []

        result = list.minus([1,4])
        println(result)
    }

    void plusList() {
        def list = [1, 2, 3, 4, 5]
        def result = []

        result = list.plus([1,20])
        println(result)
    }

    void reverseList() {
        def list = [1, 2, 3, 4, 5]
        def result = list.reverse()
        println(result)
    }

    void sortList() {
        def list = [1, 10, 32, 4, 5]
        def result = list.sort()
        println(result)
    }

    void simpleMap(){
        def mapEmpty = [:]
        println(mapEmpty)
        println("is empty? ${mapEmpty.isEmpty()}")

        def map = [1:"test", 2:"test2"]
        println(map)
    }

    void simpleDate(){
        def date = new Date()
        println(date)

        def date1 = new Date(100)
        println(date1)
    }

    void regularExpr(){
        println('Groovy' ==~ 'Groovy')
        println('Groovy' ==~ 'Gro{2}vy')
    }

    void strings(){
        def nick = 'Regina'
        def book = 'title'
        assert "$nick has $book" == 'Regina has title'
    }
}
