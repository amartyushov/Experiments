package io.mart.challenge

fun main(args: Array<String>) {
    val bicycle = Bicycle(1,10).printDescription()
    val mBicycle = MountainBike(2,1,10).printDescription()
    println(MountainBike.list)
    val rBicycle = RoadBike(20,1,10).printDescription()
}

open class Bicycle(var cadence: Int, var speed: Int, var gear: Int = 10) {

    fun applyBrake(decrement: Int) {
        speed -= decrement
    }

    fun speedUp(increment: Int) {
        speed += increment
    }

    open fun printDescription() {
        println("Gear $gear with cadence $cadence and speed $speed")
    }
}

class MountainBike(var seatHeight: Int,
                   cadence: Int,
                   speed: Int,
                   gear: Int = 11) : Bicycle(cadence, speed, gear) {

    constructor(color: String, seatHeight: Int, cadence: Int, speed: Int, gear: Int = 10) : this(seatHeight, cadence, speed, gear){
        println("Color $color")
    }

    companion object {
        val list = listOf("blue", "red")
    }

    override fun printDescription(){
        super.printDescription()
        println("seatHeight is $seatHeight")
    }
}

class RoadBike(val tireWidth: Int,
               cadence: Int,
               speed: Int,
               gear: Int = 12) : Bicycle(cadence, speed, gear){

    override fun printDescription(){
        super.printDescription()
        println("tireWidth is $tireWidth")
    }
}
