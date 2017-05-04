package io.mart
/**
 * @author Aleksandr Martiushov
 * brew install groovy
 * export GROOVY_HOME=/usr/local/opt/groovy/libexec
 *
 *
 * groovysh - groovy shell
 *
 *
 * By default, Groovy includes the following libraries in your code, so you don’t need to explicitly import them.

 import java.lang.*
 import java.util.*
 import java.io.*
 import java.net.*

 import groovy.lang.*
 import groovy.util.*

 import java.math.BigInteger
 import java.math.BigDecimal
 */
class Loops {

    static void main(String[] args) {
        // if, nested if, switch are exactly as in java
        differentVariables()
    }

    static void differentVariables(){
        def x = 5
        String X = "Hello world"  // x and X are actually different variables

        println(X)
        println X[0]
        println X[1..4]
        println X[-1]
        println X[-2]
        println x

        // groovy supports concept of range
        def range = 0..5  // inclusive range
        def rangeExclusive = 0..<5  // exclusive range
        def rangeChars = 'a'..'d'
        def rangeDesc = 10..1
        println(range)
        println(range.get(0))
    } // default visibility modifier is public

    static void whileLoop(){
        int count = 5
        while (count > 0){
            println(count)
            count--
        }
    }

    static def forLoop(){
        for (int i = 0; i<5; i++){
            println(i)
        }
    }

    static void forInLoop(){
        int[] array = [0,1,2,3]
        for (int i in array){
            println(i)
        }

        for (int i in 0..5){
            println(i)
        }

        def employee = ["Ken" : 21, "John" : 25, "Sally" : 22]
        for (emp in employee){
            println(emp)
        }
    }

    static void breakStatement(){
        for (int i in 0..5){
            println(i)
            if (i == 2) break
        }
    }

    static void continueStatement(){
        for (int i in 0..5){
            if (i == 2) continue
            println(i)
        }
    }

    //default value of parameters. someMethod(5) = 9
    def someMethod(int a, int b=4){
        int c = a + b
        println(c)
    }
}
