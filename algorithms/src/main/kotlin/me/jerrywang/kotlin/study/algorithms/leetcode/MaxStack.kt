package me.jerrywang.kotlin.study.algorithms.leetcode

import java.util.*
import kotlin.math.max

// LC 716
class MaxStack {

    private val stack = Stack<Int>()
    private val maxStack = Stack<Int>()

    fun push(x: Int) {
        val max = if (maxStack.isEmpty()) x else maxStack.peek()

        maxStack.push(max(max, x))
        stack.push(x)
    }

    fun pop(): Int {
        maxStack.pop()

        return stack.pop()
    }

    fun top(): Int = stack.peek()

    fun peekMax(): Int = maxStack.peek()

    fun popMax(): Int {
        val max = peekMax()
        val buffer = Stack<Int>()

        while (top() != max) {
            buffer.push(pop())
        }

        pop()

        while (!buffer.isEmpty()) {
            push(buffer.pop())
        }

        return max
    }
}
