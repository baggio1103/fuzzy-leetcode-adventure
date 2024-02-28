package dailyChallenge.year2024.february.february28


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String {
        return "Node{val: $`val`}"
    }

}

// Pair(depth, value)
fun findBottomLeftValue(root: TreeNode?): Int {
    val array = arrayOf(Pair(root?.`val` ?: 0, 0))
    traverse(root, array, 0)
    return array[0].first
}

fun traverse(root: TreeNode?, array: Array<Pair<Int, Int>>, depth: Int) {
    if (root == null) {
        return
    }
    val (_, maxDepth) = array[0]
    if (depth > maxDepth) {
        array[0] = Pair(root.`val`, depth)
    }
    traverse(root.left, array, depth + 1)
    traverse(root.right, array, depth + 1)
}

fun main() {
    println(
        findBottomLeftValue(
            TreeNode(12)
        )
    )
    println(
        findBottomLeftValue(
            TreeNode(2).apply {
                left = TreeNode(1)
                right = TreeNode(3)
            }
        )
    )
    println(
        findBottomLeftValue(
            TreeNode(1).apply {
                left = TreeNode(2).apply {
                    left = TreeNode(4)
                }
                right = TreeNode(3).apply {
                    left = TreeNode(5).apply {
                        left = TreeNode(7)
                    }
                    right = TreeNode(6).apply {
                        left = TreeNode(99)
                    }
                }
            }
        )
    )
    println(
        findBottomLeftValue(
            TreeNode(3).apply {
                left = TreeNode(1)
                right = TreeNode(5)
            }
        )
    )
}