package dailyChallenge.year2024.may.may18

import kotlin.math.absoluteValue

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String {
        return "Node{val: $`val`}"
    }
}

var moves = 0

fun distributeCoins(root: TreeNode?): Int {
    traverse(root)
    return moves
}

fun traverse(root: TreeNode?): Int {
    if (root == null) return 0
    val leftSubtree = traverse(root.left)
    val rightSubtree = traverse(root.right)
    moves += leftSubtree.absoluteValue + rightSubtree.absoluteValue
    return root.`val` - 1 + leftSubtree + rightSubtree
}


fun main() {
    val root = TreeNode(4).apply {
        left = TreeNode(0).apply {
            left = TreeNode(0)
            right = TreeNode(0)
        }
    }
    val distributeCoins = distributeCoins(root)
    println(distributeCoins)
}