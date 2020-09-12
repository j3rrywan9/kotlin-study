package me.jerrywang.kotlin.study.algorithms.leetcode.binarytree

import java.util.*

// LC 145
fun postorderTraversal(root: TreeNode?): List<Int> {
    val output = mutableListOf<Int>()
    val stack = Stack<TreeNode>()

    if (root == null) {
        return output
    }

    stack.push(root)

    while (!stack.isEmpty()) {
        val node = stack.pop()

        output.add(0, node.`val`)

        if (node.left != null) stack.add(node.left)
        if (node.right != null) stack.add(node.right)
    }

    return output
}
