package bytebytego.tree

import kotlin.math.abs

fun main() {
    val treeNode = TreeNode(5).apply {
        left = TreeNode(2).apply {
            left = TreeNode(1)
            right = TreeNode(4)
                .apply { left = TreeNode(3) }
        }
        right = TreeNode(7).apply {
            left = TreeNode(111)
            right = TreeNode(9)
                .apply { left = TreeNode(6) }
        }
    }
    println("Balanced: ${isBalanced(treeNode)}")
    println("Balanced: ${isBalancedTree(treeNode)}")
}

fun isBalanced(root: TreeNode?): Boolean {
    fun balanced(node: TreeNode?): Pair<Boolean, Int> {
        if (node == null) return true to 0
        val (isLeftBalanced, leftHeight) = balanced(node.left)
        val (isRightBalanced, rightHeight) = balanced(node.right)
        return if (
            (!isLeftBalanced || !isRightBalanced)
            ||
            abs(leftHeight - rightHeight) > 1
        )
            false to maxOf(leftHeight, rightHeight) + 1
        else true to maxOf(leftHeight, rightHeight) + 1
    }
    val (balanced, _) = balanced(root)
    return balanced
}

fun isBalancedTree(root: TreeNode?): Boolean {
    fun balanced(node: TreeNode?): Int {
        if (node == null) return 0
        val leftHeight = balanced(node.left)
        val rightHeight = balanced(node.right)
        return if (
            leftHeight == -1 || rightHeight == -1
            ||
            abs(leftHeight - rightHeight) > 1
        ) -1
        else maxOf(leftHeight, rightHeight) + 1
    }
    return balanced(root) != -1
}

