package me.jerrywang.kotlin.study.algorithms.leetcode.binarytree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BinaryTreePostorderTraversalTest {

    @Test
    fun testExample1() {
        val root = TreeNode(1)

        root.right = TreeNode(2)
        root.right?.left = TreeNode(3)

        assertIterableEquals(listOf(3, 2, 1), postorderTraversal(root))
    }

    @Test
    fun testExample2() {
        val root = null

        assertIterableEquals(listOf<Int>(), postorderTraversal(root))
    }

    @Test
    fun testExample3() {
        val root = TreeNode(1)

        assertIterableEquals(listOf(1), postorderTraversal(root))
    }

    @Test
    fun testExample4() {
        val root = TreeNode(1)

        root.left = TreeNode(2)

        assertIterableEquals(listOf(2, 1), postorderTraversal(root))
    }

    @Test
    fun testExample5() {
        val root = TreeNode(1)

        root.right = TreeNode(2)

        assertIterableEquals(listOf(2, 1), postorderTraversal(root))
    }
}
