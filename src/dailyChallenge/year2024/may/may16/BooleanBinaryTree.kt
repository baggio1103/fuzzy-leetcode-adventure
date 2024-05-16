package dailyChallenge.year2024.may.may16

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String {
        return "Node{val: $`val`}"
    }
}

fun evaluateTree(root: TreeNode?): Boolean {
    if (root == null) return false
    if (root.left == null && root.right == null) {
        return root.`val` == 1
    }
    val leftSubtree = evaluateTree(root.left)
    val rightSubtree = evaluateTree(root.right)
    return if (root.`val` == 2) leftSubtree or rightSubtree else leftSubtree and rightSubtree
}

fun main() {
    val root = TreeNode(2).apply {
        left = TreeNode(1)
        right = TreeNode(3).apply {
            left = TreeNode(0)
            right = TreeNode(1)
        }
    }
    println(
        evaluateTree(root)
    )
}