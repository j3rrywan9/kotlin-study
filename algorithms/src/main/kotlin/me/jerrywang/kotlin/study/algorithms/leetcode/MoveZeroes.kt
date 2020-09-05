package me.jerrywang.kotlin.study.algorithms.leetcode

// LC 283
fun moveZeroes(nums: IntArray) {
    var anchor = 0

    for (explorer in nums.indices) {
        if (nums[explorer] != 0) {
            val temp = nums[anchor]

            nums[anchor] = nums[explorer]
            nums[explorer] = temp
            anchor++
        }
    }
}
