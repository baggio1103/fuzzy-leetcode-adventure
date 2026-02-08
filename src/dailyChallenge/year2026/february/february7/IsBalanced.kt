package dailyChallenge.year2026.february.february7

import kotlin.math.abs

fun main() {
    require(
        isBalanced(
            TreeNode(3).apply {
                left = TreeNode(9)
                right = TreeNode(20).apply {
                    left = TreeNode(15)
                    right = TreeNode(7)
                }
            }
        )
    )
    require(
        !isBalanced(
            TreeNode(1).apply {
                left = TreeNode(2).apply {
                    left = TreeNode(2).apply {
                        left = TreeNode(3).apply {
                            left = TreeNode(4)
                            right = TreeNode(4)
                        }
                        right = TreeNode(3)
                    }
                    right = TreeNode(3)
                }
                right = TreeNode(2)
            }
        )
    )
}

fun isBalanced(root: TreeNode?): Boolean {

    fun traverse(node: TreeNode?): Int {
        if (node == null) return 0
        val left = traverse(node.left)
        val right = traverse(node.right)
        return when {
            left == -1 || right == -1 -> -1
            abs(left - right) > 1 -> -1
            else -> 1 + maxOf(left, right)
        }
    }
    return traverse(root) != -1

}

class TreeNode(val `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String {
        return "TreeNode{value:${`val`}}"
    }
}