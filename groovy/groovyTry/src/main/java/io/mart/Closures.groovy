package io.mart

/**
 * @author Aleksandr Martiushov
 */
class Closures {

    public static void main(String[] args) {
        simpleClosure()
    }

    static void simpleClosure(){
        def list = [1,2,3,4]
        list.each {println it}

        list.stream().forEach {println it} // Java + groovy

    }
}
