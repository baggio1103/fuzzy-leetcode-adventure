package bytebytego.tree

fun main() {
    println(
        isValidBST(TreeNode(2).apply {
            left = TreeNode(1)
            right = TreeNode(3)
        })
    )
    println(
        isValidBST(TreeNode(7).apply {
            left = TreeNode(8)
            right = TreeNode(9)
        })
    )

    // false
    println(
        isValidBST(TreeNode(5).apply {
            left = TreeNode(1)
            right = TreeNode(4).apply {
                left = TreeNode(3)
                right = TreeNode(6)
            }
        })
    )
    println(
        isValidBST(TreeNode(5).apply {
            left = TreeNode(2).apply {
                left = TreeNode(1)
                right = TreeNode(4)
            }
            right = TreeNode(7).apply {
                left = TreeNode(6)
                right = TreeNode(9)
            }
        })
    )
    println(
        isValidBST(
            TreeNode(1).apply {
                left = TreeNode(0)
                right = TreeNode(2)
            })
    )
    println(
        isValidBST(
            TreeNode(5).apply {
                left = TreeNode(4)
                right = TreeNode(6)
            }
        )
    )

    println(
        isValidBST(
            TreeNode(3).apply {
                left = TreeNode(1).apply {
                    left = TreeNode(0)
                    right = TreeNode(2)
                }
                right = TreeNode(5).apply {
                    left = TreeNode(4)
                    right = TreeNode(6)
                }
            }
        )
    )

    println(
        isValidBST(TreeNode(1).apply { right = TreeNode(2) })
    )
    println(
        isValidBST(TreeNode(1).apply { right = TreeNode(1) })
    )

}

fun isValidBST(
    root: TreeNode?,
    lowerBound: Long = Long.MIN_VALUE,
    upperBound: Long = Long.MAX_VALUE,
): Boolean {
    if (root == null) return true
    if (root.`val` !in (lowerBound + 1) until upperBound) return false
    return isValidBST(root.left, lowerBound, root.`val`.toLong()) &&
            isValidBST(root.right, root.`val`.toLong(), upperBound)
}
