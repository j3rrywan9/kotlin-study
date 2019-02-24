package me.jerrywang.kotlin.study.examples.polymorphism

class Vet {
    fun giveShot(animal: Animal) {
        // Code to do something medical
        animal.makeNoise()
    }
}
