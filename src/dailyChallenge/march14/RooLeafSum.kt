package dailyChallenge.march14

class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String {
        return "TreeNode{val: $value}"
    }
}

class RooLeafSum {

    fun sumNumbers(node: TreeNode?): Int {
        if (node == null) {
            return -0
        }
        val left = sumNumbers(node.left.apply {
            if (this != null) {
                this.value += 10 * node.value
            }
        })
        val right = sumNumbers(node.right.apply {
            if (this != null) {
                this.value += 10 * node.value
            }
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
    val rooLeafSum = RooLeafSum()
    println("Sum: ${rooLeafSum.sumNumbers(root)}")
}