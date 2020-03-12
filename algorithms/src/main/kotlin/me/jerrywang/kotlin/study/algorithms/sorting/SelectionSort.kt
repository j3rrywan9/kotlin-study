package me.jerrywang.kotlin.study.algorithms.sorting

object SelectionSort {

    fun sort(array: IntArray) {
        val n = array.size

        // We only need to run this loop (array.size - 1) times
        for (i in 0 until n - 1) {
            var indexOfMinElement = i
            for (j in i + 1 until n) {
                if (array[j] < array[indexOfMinElement]) {
                    // Update the index of minimum element
                    indexOfMinElement = j
                }
            }
            // Swap array[i] and minimum element
            var temp = array[i]
            array[i] = array[indexOfMinElement]
            array[indexOfMinElement] = temp
        }
    }
}

fun main() {
    val array = intArrayOf(64, 34, 25, 12, 22, 11, 90)

    println("Original array:")
    ArrayHelpers.printArray(array)

    SelectionSort.sort(array)

    println("Sorted array:")
    ArrayHelpers.printArray(array)
}
