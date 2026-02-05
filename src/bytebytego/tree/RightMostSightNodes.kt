package bytebytego.tree

import java.util.ArrayDeque

fun main() {
    println(
        rightSideView(TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(4).apply {
                    left = TreeNode(8)
                    right = TreeNode(9)
                }
                right = TreeNode(5).apply {
                    right = TreeNode(11)
                }
            }
            right = TreeNode(3).apply { left = TreeNode(6) }
        })
    )
}

fun rightSideView(root: TreeNode?): List<Int> {
    if (root == null) return emptyList()
    val queue = ArrayDeque<TreeNode>()
    queue.offer(root)
    val result = mutableListOf<Int>()
    while (queue.isNotEmpty()) {
        val size = queue.size
        repeat(size) {
            val node = queue.poll()
            if (node.left != null) queue.offer(node.left)
            if (node.right != null) queue.offer(node.right)
            if (it == size - 1)
                result.add(node.`val`)
        }
    }
    return result
}
