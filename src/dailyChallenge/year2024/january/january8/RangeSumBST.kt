package dailyChallenge.year2024.january.january8

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun rangeSumBST(root: TreeNode?, low: Int, high: Int): Int {
    if (root == null) {
        return 0
    }
    val value = if (root.`val` in low..high) root.`val` else 0
    return value + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high)
}

fun main() {
    val rootOne = TreeNode(10).also {
        it.left = TreeNode(5).also {
            it.left = TreeNode(3)
            it.right = TreeNode(7)
        }
        it.right = TreeNode(15).also {
            it.right = TreeNode(18)
        }
    }
    println(
        rangeSumBST(rootOne, 7, 15)
    )

    val rootTwo = TreeNode(10).also {
        it.left = TreeNode(5).also {
            it.left = TreeNode(3).also {
                it.left = TreeNode(1)
            }
            it.right = TreeNode(7).also {
                it.left = TreeNode(6)
            }
        }
        it.right = TreeNode(15).also {
            it.left = TreeNode(13)
            it.right = TreeNode(18)
        }
    }
    println(
        rangeSumBST(rootTwo, 6, 10)
    )
}