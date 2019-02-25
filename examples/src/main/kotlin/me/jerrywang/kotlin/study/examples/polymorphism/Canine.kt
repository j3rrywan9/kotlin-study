package me.jerrywang.kotlin.study.examples.polymorphism

abstract class Canine : Animal() {
    override fun roam() {
        println("The Canine is roaming")
    }
}
