package bytebytego.tree

import java.util.ArrayDeque

fun main() {
    println(
        widthOfBinaryTree(
            TreeNode(1).apply {
                left = TreeNode(2).apply {
                    left = TreeNode(4).apply {
                        left = TreeNode(8)
                        right = TreeNode(9)
                    }
                    right = TreeNode(5)
                        .apply { right = TreeNode(11) }
                }
                right = TreeNode(3)
                    .apply {
                        right = TreeNode(7).apply { left = TreeNode(14) }
                    }
            }
        )
    )
}

fun widthOfBinaryTree(root: TreeNode?): Int {
    if (root == null) return 0
    val queue = ArrayDeque<Pair<TreeNode?, Int>>()
    queue.add(root to 0)
    var maxWidth = 0
    while (queue.isNotEmpty()) {
        val size = queue.size
        val (_, leftIndex) = queue.peek()
        var rightIndex = leftIndex
        repeat(size) {
            val (node, index) = queue.poll()
            if (node?.left != null)
                queue.offer(node.left to 2 * index + 1)
            if (node?.right != null)
                queue.offer(node.right to 2 * index + 2)
            rightIndex = index
        }
        maxWidth = maxOf(maxWidth, rightIndex - leftIndex + 1)
    }
    return maxWidth
}

