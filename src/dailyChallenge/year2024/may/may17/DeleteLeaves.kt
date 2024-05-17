package dailyChallenge.year2024.may.may17


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String {
        return "Node{val: $`val`}"
    }
}

fun removeLeafNodes(root: TreeNode?, target: Int): TreeNode? {
    if (root == null) return null
    root.left = removeLeafNodes(root.left, target)
    root.right = removeLeafNodes(root.right, target)
    return if (root.left == null && root.right == null && root.`val` == target) {
         null
    } else root
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