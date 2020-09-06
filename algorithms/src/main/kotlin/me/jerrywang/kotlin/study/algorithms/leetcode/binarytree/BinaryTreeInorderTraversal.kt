package me.jerrywang.kotlin.study.algorithms.leetcode.binarytree

import java.util.Stack

// LC 94
fun inorderTraversal(root: TreeNode?): List<Int> {
    val output = mutableListOf<Int>()
    val stack = Stack<TreeNode>()
    var current = root

    while (current != null || !stack.isEmpty()) {
        while (current != null) {
            stack.push(current)
            current = current.left
        }

        current = stack.pop()
        output.add(current.`val`)
        current = current.right
    }

    return output
}
