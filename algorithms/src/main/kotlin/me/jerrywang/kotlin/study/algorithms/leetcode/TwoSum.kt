package me.jerrywang.kotlin.study.algorithms.leetcode

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map: MutableMap<Int, Int> = mutableMapOf()

    for (i in 0 until nums.size) {
        val complement = target - nums[i]

        if (map.containsKey(complement)) {
            map[complement]?.let {
                return intArrayOf(it, i)
            }
        } else {
            map[nums[i]] = i
        }
    }

    throw IllegalArgumentException("No two sum solution")
}

fun main() {
    val result = twoSum(intArrayOf(2, 7, 11, 15), 9)
    println("[${result[0]}, ${result[1]}]")
}
