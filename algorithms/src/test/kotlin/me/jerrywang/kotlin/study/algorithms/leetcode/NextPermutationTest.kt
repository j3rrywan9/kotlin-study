package me.jerrywang.kotlin.study.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class NextPermutationTest {

    @Test
    fun testExample1() {
        val nums = intArrayOf(1, 2, 3)

        nextPermutation(nums)

        assertArrayEquals(intArrayOf(1, 3, 2), nums)
    }

    @Test
    fun testExample2() {
        val nums = intArrayOf(3, 2, 1)

        nextPermutation(nums)

        assertArrayEquals(intArrayOf(1, 2, 3), nums)
    }

    @Test
    fun testExample3() {
        val nums = intArrayOf(1, 1, 5)

        nextPermutation(nums)

        assertArrayEquals(intArrayOf(1, 5, 1), nums)
    }
}
