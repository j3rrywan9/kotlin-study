package me.jerrywang.kotlin.study.examples.generics

class Vet<T: Pet> {
    fun treat(t: T) {
        println("Treat Pet ${t.name}")
    }
}
