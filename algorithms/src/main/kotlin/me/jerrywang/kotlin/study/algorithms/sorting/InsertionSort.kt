package me.jerrywang.kotlin.study.algorithms.sorting

object InsertionSort {

    fun sort(array: IntArray) {
        val n = array.size

        for (i in 1 until n) {
            var value = array[i]
            var hole = i

            while (hole > 0 && array[hole-1] > value) {
                array[hole] = array[hole-1]
                hole -= 1
            }

            array[hole] = value
        }
    }
}

fun main() {
    val array = intArrayOf(64, 34, 25, 12, 22, 11, 90, 42)

    println("Original array:")
    ArrayHelpers.printArray(array)

    InsertionSort.sort(array)

    println("Sorted array:")
    ArrayHelpers.printArray(array)
}
