package dailyChallenge.year2024.april.april16

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    override fun toString(): String {
        return "TreeNode{val:${`val`}}"
    }
}

fun addOneRow(root: TreeNode?, `val`: Int, depth: Int): TreeNode? {
    if (depth == 1) {
        return TreeNode(`val`).apply { left = root }
    }
    fun traverse(root: TreeNode?, `val`: Int, depth: Int, currentDepth: Int) {
        if (root == null) return
        if (currentDepth == depth - 1) {
            root.left = TreeNode(`val`).apply { left = root.left }
            root.right = TreeNode(`val`).apply { right = root.right }
            return
        }
        traverse(root.left, `val`, depth, currentDepth + 1)
        traverse(root.right, `val`, depth, currentDepth + 1)
    }
    traverse(root, `val`, depth, 1)
    return root
}

fun traverse(root: TreeNode?) {
    if (root == null) return
    println(root.`val`)
    traverse(root.left)
    traverse(root.right)
}

fun main() {
    val root = TreeNode(4).apply {
        left = TreeNode(2).apply {
            left = TreeNode(3)
            right = TreeNode(1)
        }
    }
    println(
        addOneRow(root, 1, 3)
    )
    traverse(root)
}