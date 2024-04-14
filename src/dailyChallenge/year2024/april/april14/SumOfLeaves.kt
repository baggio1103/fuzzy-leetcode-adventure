package dailyChallenge.year2024.april.april14

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    override fun toString(): String {
        return "TreeNode{val:${`val`}}"
    }
}

fun sumOfLeftLeaves(root: TreeNode?, isLeft: Boolean = false): Int {
    if (root == null) return 0
    val value = if (root.left == null && root.right == null && isLeft) root.`val` else 0
    return value + sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false)
}

fun main() {
    println(
        sumOfLeftLeaves(
            TreeNode(3).apply {
                left = TreeNode(9)
                right = TreeNode(20).apply {
                    left = TreeNode(15)
                    right = TreeNode(7)
                }
            }
        )
    )
    println(
        sumOfLeftLeaves(
            TreeNode(1).apply {
                left = TreeNode(2).apply {
                    left = TreeNode(4)
                    right = TreeNode(5)
                }
                right = TreeNode(3)
            }
        )
    )
}