package dailyChallenge.year2026.january.january7

fun main() {
    println(
        maxProduct(TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(4)
                right = TreeNode(5)
            }
            right = TreeNode(3).apply {
                left = TreeNode(6)
            }
        })
    )
}

fun maxProduct(root: TreeNode?): Int {
    fun sum(root: TreeNode?): Int {
        if (root == null) return 0
        return root.`val` + sum(root.left) + sum(root.right)
    }
    val mod = 1_000_000_007L
    var maxProduct = 0L
    val treeSum = sum(root)
    fun traverse(node: TreeNode?): Long {
        if (node == null) return 0
        val leftSubtree = traverse(node.left)
        val rightSubtree = traverse(node.right)
        val sum = node.`val` + leftSubtree + rightSubtree
        maxProduct = maxOf(maxProduct, sum * (treeSum - sum))
        return sum
    }
    traverse(root)
    return (maxProduct % mod).toInt()
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
