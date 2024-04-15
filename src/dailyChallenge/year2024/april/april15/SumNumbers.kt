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
    val accumulator = 10 * acc + root.`val`
    return when {
        root.left != null && root.right != null ->
            sumNumbers(root.left, accumulator) + sumNumbers(root.right, accumulator)
        root.left == null && root.right == null -> accumulator
        root.left == null -> sumNumbers(root.right, accumulator)
        else -> sumNumbers(root.left, accumulator)
    }
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