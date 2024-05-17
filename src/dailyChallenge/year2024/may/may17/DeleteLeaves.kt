package dailyChallenge.year2024.may.may17


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String {
        return "Node{val: $`val`}"
    }
}

fun removeLeafNodes(root: TreeNode?, target: Int): TreeNode? {
    fun traverseAndRemove(root: TreeNode?, target: Int): Boolean {
        if (root == null) return false
        if (root.left == null && root.right == null && root.`val` == target) {
            return true
        }
        val leftSubtree = traverseAndRemove(root.left, target)
        if (leftSubtree) {
            root.left = null
        }
        val rightSubtree = traverseAndRemove(root.right, target)
        if (rightSubtree) {
            root.right = null
        }
        return root.left == null && root.right == null && root.`val` == target
    }
    return if (traverseAndRemove(root, target)) null else root
}

fun traverse(root: TreeNode?) {
    if (root == null) return
    println(root)
    traverse(root.left)
    traverse(root.right)
}

fun main() {
    val root = TreeNode(1).apply {
        left = TreeNode(2).apply { left = TreeNode(2) }
        right = TreeNode(3).apply {
            left = TreeNode(2)
            right = TreeNode(4)
        }
    }
    val removeLeafNodes = removeLeafNodes(root, 2)
    traverse(removeLeafNodes)
}