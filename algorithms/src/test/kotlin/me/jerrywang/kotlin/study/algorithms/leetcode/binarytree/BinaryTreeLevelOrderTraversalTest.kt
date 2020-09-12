package me.jerrywang.kotlin.study.algorithms.leetcode.binarytree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BinaryTreeLevelOrderTraversalTest {

    @Test
    fun testExample1() {
        val root = TreeNode(3)

        root.left = TreeNode(9)
        root.right = TreeNode(20)
        root.right?.left = TreeNode(15)
        root.right?.right = TreeNode(7)

        assertIterableEquals(listOf(listOf(3), listOf(9, 20), listOf(15, 7)), levelOrder(root))
    }
}
