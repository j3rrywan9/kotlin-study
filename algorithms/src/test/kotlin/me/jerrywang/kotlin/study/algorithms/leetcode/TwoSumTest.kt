package me.jerrywang.kotlin.study.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class TwoSumTest {

    @Test
    fun testExample1() {
        assertArrayEquals(intArrayOf(0, 1), twoSum(intArrayOf(2, 7, 11, 15), 9))
    }
}
