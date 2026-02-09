package dailyChallenge.year2026.february.february9

fun main() {
    val root = TreeNode(1).apply {
        right = TreeNode(2).apply {
            right = TreeNode(3).apply {
                right = TreeNode(4)
            }
        }
    }
    with(balanceBST(root)) {
        require(this != null)
        require(this.`val` == 2)
    }
}

fun balanceBST(root: TreeNode?): TreeNode? {

    val values = mutableListOf<Int>()
    fun dfs(node: TreeNode?) {
        if (node == null) return
        values += node.`val`
        dfs(node.right)
        dfs(node.left)
    }

    dfs(root)
    values.sort()

    fun constructTree(left: Int, right: Int): TreeNode? {
        if (left > right) return null
        val middle = left + (right - left) / 2
        val node = TreeNode(values[middle])
        node.left = constructTree(left, middle - 1)
        node.right = constructTree(middle + 1, right)
        return node
    }

    return constructTree(0, values.size - 1)
}

class TreeNode(val `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String {
        return "TreeNode{value:${`val`}}"
    }
}