package me.jerrywang.kotlin.study.algorithms.sorting

object BubbleSort {

    fun sort(array: IntArray) {
        val n = array.size

        for (i in 0 until n) {
            var swapped = false

            for (j in 0 until n - i - 1) {
                if (array[j] > array[j + 1]) {
                    val temp = array[j + 1]
                    array[j + 1] = array[j]
                    array[j] = temp
                    swapped = true
                }
            }

            if (!swapped) return
        }
    }
}

fun main() {
    val array = intArrayOf(64, 34, 25, 12, 22, 11, 90, 42)

    println("Original array:")
    println(array.contentToString())

    BubbleSort.sort(array)

    println("Sorted array:")
    println(array.contentToString())
}
