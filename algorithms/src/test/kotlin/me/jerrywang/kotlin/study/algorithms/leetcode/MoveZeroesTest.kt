package me.jerrywang.kotlin.study.algorithms.leetcode

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MoveZeroesTest {

    @Test
    fun testExample1() {
        val input = intArrayOf(0, 1, 0, 3, 12)

        moveZeroes(input)

        assertArrayEquals(intArrayOf(1, 3, 12, 0, 0), input)
    }
}
