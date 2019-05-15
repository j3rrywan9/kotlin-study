package me.jerrywang.kotlin.study.examples.polymorphism

class Vehicle : Roamable {
    override fun roam() {
        println("The Vehicle is roaming")
    }
}
