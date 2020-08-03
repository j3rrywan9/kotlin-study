package me.jerrywang.kotlin.study.algorithms.leetcode

// LC 31
fun nextPermutation(nums: IntArray) {
    var i = nums.size - 2

    // find first decreasing element
    while (i >= 0 && nums[i + 1] <= nums[i]) {
        i--
    }

    if (i >= 0) {
        var j = nums.size - 1

        while (j >= 0 && nums[j] <= nums[i]) {
            j--
        }

        swap(nums, i, j)
    }

    reverse(nums, i + 1)
}

private fun reverse(nums: IntArray, start: Int) {
    var i = start
    var j = nums.size - 1

    while (i < j) {
        swap(nums, i, j)
        i++
        j--
    }
}

private fun swap(nums: IntArray, i: Int, j: Int) {
    val temp = nums[i]

    nums[i] = nums[j]
    nums[j] = temp
}
