package me.jerrywang.kotlin.study.algorithms.leetcode.binarytree

import java.util.*

// LC 102
fun levelOrder(root: TreeNode?): List<List<Int>> {
    val output = mutableListOf<MutableList<Int>>()

    if (root == null) {
        return output
    }

    val queue = LinkedList<TreeNode>()

    queue.add(root)

    var level = 0

    while (!queue.isEmpty()) {
        output.add(mutableListOf())

        val levelLength = queue.size

        for (i in 0 until levelLength) {
            val node = queue.remove()

            output[level].add(node.`val`)

            if (node.left != null) node.left?.let { queue.add(it) }
            if (node.right != null) node.right?.let { queue.add(it) }
        }

        level++
    }

    return output
}
