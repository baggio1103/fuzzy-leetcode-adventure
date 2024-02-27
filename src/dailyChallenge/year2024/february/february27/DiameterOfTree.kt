package dailyChallenge.year2024.february.february27

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String {
        return "Node{val: $`val`}"
    }

}

fun diameterOfBinaryTree(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    val diameter = intArrayOf(0)
    height(root, diameter)
    return diameter[0]
}

fun height(root: TreeNode?, diameter: IntArray): Int {
    if (root == null) {
        return 0
    }
    val leftSubtree = height(root.left, diameter)
    val rightSubtree = height(root.right, diameter)
    diameter[0] = maxOf(diameter[0], leftSubtree + rightSubtree)
    return 1 + maxOf(leftSubtree, rightSubtree)
}


fun main() {
    println(
        diameterOfBinaryTree(
            TreeNode(1).apply {
                left = TreeNode(2)
                    .apply {
                        left = TreeNode(4)
                        right = TreeNode(5)
                    }
                right = TreeNode(3)
            }
        )
    )
}