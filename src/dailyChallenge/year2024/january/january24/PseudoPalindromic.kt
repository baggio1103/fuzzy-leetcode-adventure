package dailyChallenge.year2024.january.january24

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String {
        return "TreeNode{val: $`val`}"
    }
}

fun pseudoPalindromicPaths(root: TreeNode?): Int {
    var count = 0
    val nodeMap = mutableMapOf<Int, Int>()

    fun checkIfPalindrome() {
        val oddValueCount = nodeMap.values.count { it % 2 != 0 }
        if (oddValueCount <= 1 ) {
            count++
        }
    }
    fun traverse(root: TreeNode?) {
        if (root == null) {
            return
        }
        val valueCount = nodeMap[root.`val`] ?: 0
        nodeMap[root.`val`] = valueCount + 1
        if (root.left == null && root.right == null) {
            // This is a leaf, check if palindrome
            checkIfPalindrome()
        }
        traverse(root.left)
        traverse(root.right)
        nodeMap[root.`val`] = valueCount
    }
    traverse(root)
    return count
}

fun main() {
    val root = TreeNode(2).apply {
        left = TreeNode(3).apply {
            left = TreeNode(3)
            right = TreeNode(1)
        }
        right = TreeNode(1).apply {
            right = TreeNode(1)
        }
    }
    println(
        pseudoPalindromicPaths(root)
    )
    println(
        pseudoPalindromicPaths(TreeNode(9))
    )
    val rootTwo = TreeNode(3).apply {
        left = TreeNode(1).apply {
            left = TreeNode(3)
        }
        right = TreeNode(2).apply {
            left = TreeNode(3).apply {
                left = TreeNode(2).apply {
                    left = TreeNode(5).apply {
                        left = TreeNode(7)
                        right = TreeNode(5)
                    }
                    right = TreeNode(1)
                }
            }
        }
    }
    println(
        pseudoPalindromicPaths(rootTwo)
    )
}