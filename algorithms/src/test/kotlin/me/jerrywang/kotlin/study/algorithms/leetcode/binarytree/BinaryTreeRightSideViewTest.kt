package me.jerrywang.kotlin.study.algorithms.leetcode.binarytree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BinaryTreeRightSideViewTest {

    @Test
    fun testExample1() {
        val root = TreeNode(1)

        root.left = TreeNode(2)
        root.right = TreeNode(3)
        root.left?.right = TreeNode(5)
        root.right?.right = TreeNode(4)

        assertIterableEquals(listOf(1, 3, 4), rightSideView(root))
    }
}
