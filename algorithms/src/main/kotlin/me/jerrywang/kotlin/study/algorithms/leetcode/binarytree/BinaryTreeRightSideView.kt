package me.jerrywang.kotlin.study.algorithms.leetcode.binarytree

import java.util.*

// LC 199
fun rightSideView(root: TreeNode?): List<Int> {
    val output = mutableListOf<Int>()

    if (root == null) {
        return output
    }

    val queue = LinkedList<TreeNode>()

    queue.add(root)

    while (!queue.isEmpty()) {
        val levelLength = queue.size

        for (i in 0 until levelLength) {
            val node = queue.remove()

           if (i == levelLength - 1) {
               output.add(node.`val`)
           }

            if (node.left != null) node.left?.let { queue.add(it) }
            if (node.right != null) node.right?.let { queue.add(it) }
        }
    }

    return output
}
