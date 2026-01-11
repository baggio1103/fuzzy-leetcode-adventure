package dailyChallenge.year2026.january.january9

fun main() {
    println(
        treeDepth(TreeNode(1).apply {
            left = TreeNode(2).apply {
                left = TreeNode(4)
                right = TreeNode(5).apply {
                    right = TreeNode(6).apply {
                        left = TreeNode(7).apply {
                            right = TreeNode(9)
                        }
                        right = TreeNode(8)
                    }
                }
            }
            right = TreeNode(3)
        })
    )
}

fun treeDepth(root: TreeNode?): Int {
    if (root == null) return 0
    val ld = treeDepth(root.left)
    val rd = treeDepth(root.right)
    return 1 + maxOf(ld, rd)
}
