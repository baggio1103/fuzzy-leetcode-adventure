package dailyChallenge.year2024.april.april17.tailrec

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    override fun toString(): String {
        return "TreeNode{val:${`val`}}"
    }
}

val map = ('a'..'z').mapIndexed { index, char -> Pair(index, char) }.toMap()

fun smallestFromLeaf(root: TreeNode?): String {
    if (root == null) return ""
    val leftSubtree = smallestFromLeaf(root.left)
    val rightSubtree = smallestFromLeaf(root.right)
    val currentChar = map[root.`val`] ?: throw IllegalArgumentException()
    return when {
        leftSubtree.isEmpty() -> rightSubtree + currentChar
        rightSubtree.isEmpty() -> leftSubtree + currentChar
        else -> minOf(leftSubtree + currentChar, rightSubtree + currentChar)
    }
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
                left = TreeNode(0).apply { left = TreeNode(1) }
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