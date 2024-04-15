package dailyChallenge.year2024.april.april15

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    override fun toString(): String {
        return "TreeNode{val:${`val`}}"
    }
}

fun sumNumbers(root: TreeNode?, acc: Int = 0): Int {
    if (root == null) return acc
    val value = when {
        root.left != null && root.right != null ->
            sumNumbers(root.left, 10 * acc + root.`val`) + sumNumbers(root.right, 10 * acc + root.`val`)
        root.left == null && root.right == null -> 10 * acc + root.`val`
        root.left == null -> sumNumbers(root.right, 10 * acc + root.`val`)
        else -> sumNumbers(root.left, 10 * acc + root.`val`)
    }
    return value
}

fun main() {
    println(
        sumNumbers(
            TreeNode(1).apply {
                left = TreeNode(1)
            }
        )
    )
    println(
        sumNumbers(
            TreeNode(1).apply {
                left = TreeNode(0)
                right = TreeNode(0)
            }
        )
    )

    println(
        sumNumbers(TreeNode(1).apply {
            left = TreeNode(2)
            right = TreeNode(3)
        })
    )
    println(
        sumNumbers(TreeNode(9).apply {
            left = TreeNode(5)
            right = TreeNode(1)
        })
    )
    println(
        sumNumbers(TreeNode(4).apply {
            left = TreeNode(9).apply {
                left = TreeNode(5)
                right = TreeNode(1)
            }
            right = TreeNode(0)
        })
    )
}