package me.jerrywang.kotlin.study.algorithms.leetcode.dfs

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class NumberOfIslandsTest {

    @Test
    fun testExample1() {
        val grid = arrayOf(
                charArrayOf('1', '1', '1', '1', '0'),
                charArrayOf('1', '1', '0', '1', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '0', '0', '0'),
        )

        assertEquals(1, numIslands(grid))
    }

    @Test
    fun testExample2() {
        val grid = arrayOf(
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '1', '0', '0'),
                charArrayOf('0', '0', '0', '1', '1'),
        )

        assertEquals(3, numIslands(grid))
    }
}