package me.jerrywang.kotlin.study.algorithms.leetcode

// LC 15
fun threeSum(nums: IntArray, target: Int): List<List<Int>> {
    val res = mutableListOf<List<Int>>()
    val found = mutableSetOf<Pair<Int, Int>>()

    for (i in nums.indices) {
        val seen = mutableSetOf<Int>()

        for (j in i + 1 until nums.size) {
            val complement = target - nums[i] - nums[j]

            if (seen.contains(complement)) {
                val v1 = minOf(nums[i], complement, nums[j])
                val v2 = maxOf(nums[i], complement, nums[j])

                if (found.add(Pair(v1, v2)))
                    res.add(listOf(nums[i], complement, nums[j]))
            }

            seen.add(nums[j])
        }
    }

    return res.toList()
}
