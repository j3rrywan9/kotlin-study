package me.jerrywang.kotlin.study.algorithms.leetcode

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ThreeSumTest {

    @Test
    fun testExample1() {
        val expectedOutput = listOf(listOf(-1, 0, 1), listOf(-1, 2, -1))

        assertEquals(expectedOutput, threeSum(intArrayOf(-1, 0, 1, 2, -1, -4), 0))
    }
}
