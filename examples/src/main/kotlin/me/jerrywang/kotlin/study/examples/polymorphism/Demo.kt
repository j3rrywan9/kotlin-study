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

    val roamables = arrayOf(Hippo(), Wolf(), Vehicle())

    for (item in roamables) {
        item.roam()

        // Call the eat() function for each Animal in the array
        if (item is Animal) {
            item.eat()
        }
    }
}
