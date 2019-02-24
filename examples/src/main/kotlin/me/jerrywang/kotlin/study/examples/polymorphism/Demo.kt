package me.jerrywang.kotlin.study.examples.polymorphism

fun main() {
    val animals = arrayOf(Hippo(), Wolf())

    for (animal in animals) {
        animal.roam()
        animal.eat()
    }

    val vet = Vet()
    val wolf = Wolf()
    val hippo = Hippo()

    vet.giveShot(wolf)
    vet.giveShot(hippo)
}
