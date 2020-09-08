package me.jerrywang.kotlin.study.algorithms.leetcode

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MaxStackTest {

    @Test
    fun testExample1() {
        val stack = MaxStack()

        stack.push(5)
        stack.push(1)
        stack.push(5)

        assertEquals(5, stack.top())
        assertEquals(5, stack.popMax())
        assertEquals(1, stack.top())
        assertEquals(5, stack.peekMax())
        assertEquals(1, stack.pop())
        assertEquals(5, stack.top())
    }
}
