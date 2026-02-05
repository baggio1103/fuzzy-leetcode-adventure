package bytebytego.tree

fun main() {
    println(
        isSymmetric(TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(3)
                right = TreeNode(4)
            }
            right = TreeNode(2).apply {
                left = TreeNode(4)
                right = TreeNode(3)
            }
        })
    )
}

fun isSymmetric(root: TreeNode?): Boolean {
    if (root == null) return true
    fun isSymmetric(nodeOne: TreeNode?, nodeTwo: TreeNode?): Boolean = when {
        nodeOne == null && nodeTwo == null -> true
        nodeOne == null || nodeTwo == null -> false
        nodeOne.`val` != nodeTwo.`val` -> false
        else -> isSymmetric(nodeOne.left, nodeTwo.right)
                && isSymmetric(nodeOne.right, nodeTwo.left)
    }
    return isSymmetric(root.left, root.right)
}
