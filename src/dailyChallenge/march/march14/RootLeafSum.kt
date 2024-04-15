package dailyChallenge.march.march14

class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String {
        return "TreeNode{val: $value}"
    }
}

class RootLeafSum {

    fun sumNumbers(node: TreeNode?): Int {
        if (node == null) return 0
        val left = sumNumbers(node.left?.apply {
            value += 10 * node.value
        })
        val right = sumNumbers(node.right?.apply {
            value += 10 * node.value
        })
        return if (left == 0 && right == 0) node.value else left + right
    }

}

fun main() {
    val root = TreeNode(4).apply {
        left = TreeNode(9).apply {
            left = TreeNode(5)
            right = TreeNode(1)
        }
        right = TreeNode(0)
    }
    val rooLeafSum = RootLeafSum()
    println("Sum: ${rooLeafSum.sumNumbers(root)}")
}