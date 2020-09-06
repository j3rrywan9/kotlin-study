package me.jerrywang.kotlin.study.algorithms.leetcode.dfs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class KillProcessTest {

    @Test
    fun testExample1() {
        val actual = killProcess(listOf(1, 3, 10, 5), listOf(3, 0, 5, 3), 5)
        val expected = listOf(5, 10)

        assertIterableEquals(expected, actual)
    }
}
