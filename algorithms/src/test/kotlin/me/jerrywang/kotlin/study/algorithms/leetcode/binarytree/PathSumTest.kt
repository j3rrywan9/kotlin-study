package me.jerrywang.kotlin.study.algorithms.leetcode.binarytree

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PathSumTest {

    @Test
    fun testExample1() {
        val root = TreeNode(5)

        root.left = TreeNode(4)
        root.right = TreeNode(8)
        root.left?.left = TreeNode(11)
        root.right?.left = TreeNode(13)
        root.right?.right = TreeNode(4)
        root.left?.left?.left = TreeNode(7)
        root.left?.left?.right = TreeNode(2)
        root.right?.right?.right = TreeNode(1)

        assertTrue(hasPathSum(root, 22))
    }
}
