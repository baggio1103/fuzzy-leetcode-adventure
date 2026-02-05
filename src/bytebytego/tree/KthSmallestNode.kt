package bytebytego.tree

fun main() {
    val treeNode=  TreeNode(5).apply {
        left = TreeNode(3).apply {
            left = TreeNode(2).apply {
                left = TreeNode(1)
            }
            right = TreeNode(4)
        }
        right = TreeNode(3)
    }
    println(
        kthSmallest(
            treeNode,
            3
        )
    )
}

fun kthSmallest(root: TreeNode?, k: Int): Int {
    var curr = 1
    var element = 0
    fun traverse(root: TreeNode?): Int {
        if (root == null) return 0
        traverse(root.left)
        if (curr == k) element = root.`val`
        curr++
        traverse(root.right)
        return 0
    }
    traverse(root)
    return element
}
