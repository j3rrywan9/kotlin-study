package me.jerrywang.kotlin.study.algorithms.leetcode

// LC 1
fun twoSum(nums: IntArray, target: Int): IntArray {
    val map: MutableMap<Int, Int> = mutableMapOf()

    for (i in nums.indices) {
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
