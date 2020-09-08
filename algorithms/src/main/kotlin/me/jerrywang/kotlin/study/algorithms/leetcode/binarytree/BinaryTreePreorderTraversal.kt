package me.jerrywang.kotlin.study.algorithms.leetcode.binarytree

import java.util.Stack

// LC 144
fun preorderTraversal(root: TreeNode?): List<Int> {
    val output = mutableListOf<Int>()
    val stack = Stack<TreeNode>()

    if (root == null) {
        return output
    }

    stack.add(root)

    while (!stack.isEmpty()) {
        val node = stack.pop()

        output.add(node.`val`)

        if (node.right != null) stack.add(node.right)
        if (node.left != null) stack.add(node.left)
    }

    return output
}
