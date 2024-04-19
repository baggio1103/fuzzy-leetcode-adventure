package dailyChallenge.year2024.april.april17

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    override fun toString(): String {
        return "TreeNode{val:${`val`}}"
    }
}

val map = ('a'..'z').mapIndexed { index, char -> Pair(index, char) }.toMap()

fun smallestFromLeaf(root: TreeNode?): String {
    var smallestString: String? = null
    fun traverse(root: TreeNode?, string: String) {
        val currentSmallest = smallestString
        if (root == null) {
            smallestString = if (currentSmallest == null) string else minOf(currentSmallest, string)
            return
        }
        val char = map[root.`val`] ?: throw IllegalArgumentException()
        when {
            root.left != null && root.right != null -> {
                traverse(root.left, char + string)
                traverse(root.right, char + string)
            }

            root.left == null && root.right == null -> {
                smallestString = if (currentSmallest == null) char + string else minOf(currentSmallest, char + string)
            }

            root.left != null && root.right == null -> {
                traverse(root.left, char + string)
            }

            else -> {
                traverse(root.right, char + string)
            }
        }
    }
    traverse(root, "")
    return smallestString ?: ""
}

fun main() {
    println(
        smallestFromLeaf(
            TreeNode(0).apply {
                left = TreeNode(2)
            }
        )
    )
    println(
        smallestFromLeaf(
            TreeNode(4).apply {
                left = TreeNode(0)
                    .apply { left = TreeNode(1) }
                right = TreeNode(1)
            }
        )
    )
    println(
        smallestFromLeaf(
            TreeNode(0).apply {
                left = TreeNode(1).apply {
                    left = TreeNode(3)
                    right = TreeNode(4)
                }
                right = TreeNode(2).apply {
                    left = TreeNode(3)
                    right = TreeNode(4)
                }
            }
        )
    )
    println(
        smallestFromLeaf(
            TreeNode(25).apply {
                left = TreeNode(1).apply {
                    left = TreeNode(1)
                    right = TreeNode(3)
                }
                right = TreeNode(3).apply {
                    left = TreeNode(0)
                    right = TreeNode(2)
                }
            }
        )
    )
    println(
        smallestFromLeaf(
            TreeNode(2).apply {

                left = TreeNode(2).apply {
                    right = TreeNode(1).apply {
                        left = TreeNode(0)
                    }
                }

                right = TreeNode(1).apply {
                    left = TreeNode(0)
                }
            }
        )
    )
}
