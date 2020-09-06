package me.jerrywang.kotlin.study.algorithms.leetcode.binarytree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BinaryTreeInorderTraversalTest {

    @Test
    fun testExample1() {
        val root = TreeNode(1)

        root.right = TreeNode(2)
        root.right?.left = TreeNode(3)

        assertIterableEquals(listOf(1, 3, 2), inorderTraversal(root))
    }
}
