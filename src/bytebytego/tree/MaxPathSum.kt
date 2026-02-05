package bytebytego.tree

fun main() {
//    println(maxPathSum(TreeNode(5).apply {
//        left = TreeNode(-10).apply {
//            left = TreeNode(1).apply {
//                left = TreeNode(11)
//            }
//            right = TreeNode(-7).apply {
//                right = TreeNode(-1)
//            }
//        }
//        right = TreeNode(8).apply {
//            left = TreeNode(9)
//            right = TreeNode(7).apply {
//                left = TreeNode(6)
//                right = TreeNode(-3)
//            }
//        }
//    }))
    println(
        maxPathSum(TreeNode(2).apply {
            left = TreeNode(-1)
        })
    )
    println(
        maxPathSum(TreeNode(1).apply {
            left = TreeNode(-2)
            right = TreeNode(3)
        })
    )
}

fun maxPathSum(root: TreeNode?): Int {
    var maxPath = Int.MIN_VALUE
    fun traverse(node: TreeNode?): Int {
        if (node == null) return 0
        val left = maxOf(traverse(node.left), 0)
        val right = maxOf(traverse(node.right), 0)
        maxPath = maxOf(maxPath, node.`val`)
        return node.`val` + maxOf(left, right)
    }
    traverse(root)
    return maxPath
}
