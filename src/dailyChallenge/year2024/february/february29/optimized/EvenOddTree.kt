package dailyChallenge.year2024.february.february29.optimized

import dailyChallenge.year2024.february.february29.TreeNode
import java.util.ArrayDeque

fun isEvenOddTree(root: TreeNode?): Boolean {
    if (root == null) return false
    val queue = ArrayDeque<TreeNode>()
    queue.offer(root)
    var level = 0
    while (queue.isNotEmpty()) {
        val nodes = List(queue.size) {
            queue.poll()
        }
        if (level % 2 == 0) {
            // check for odd integer
            if (nodes[0].`val` % 2 == 0) return false
            for (i in 1 until nodes.size) {
                if (nodes[i].`val` <= nodes[i - 1].`val` || nodes[i].`val` % 2 == 0) {
                    return false
                }
            }
        } else {
            // Odd
            if (nodes[0].`val` % 2 != 0) return false
            for (i in 1 until nodes.size) {
                if (nodes[i].`val` >= nodes[i - 1].`val` || nodes[i].`val` % 2 != 0) {
                    return false
                }
            }
        }
        for (node in nodes) {
            node.left?.let { queue.offer(it) }
            node.right?.let { queue.offer(it) }
        }
        level++
    }
    return true
}

fun main() {
    println(
        isEvenOddTree(
            TreeNode(5).apply {
                left = TreeNode(4).apply {
                    left = TreeNode(3)
                    right = TreeNode(3)
                }
                right = TreeNode(2).apply {
                    left = TreeNode(7)
                }
            }
        )
    )
}