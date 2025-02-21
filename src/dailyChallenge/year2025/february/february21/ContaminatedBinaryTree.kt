package dailyChallenge.year2025.february.february21


fun main() {
    val node = TreeNode(-1).apply {
        left = TreeNode(-1).apply {
            left = TreeNode(-1)
            right = TreeNode(-1)
        }
        right = TreeNode(-1)
    }
    val findElements = FindElements(node)
    check(!findElements.find(15))
    check(findElements.find(1))
    check(findElements.find(2))
    check(findElements.find(3))
    check(findElements.find(4))
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class FindElements(private val root: TreeNode?) {

    init {
        root?.`val` = 0
        fun recover(node: TreeNode?) {
            if (node == null) return
            node.left?.`val` = 2 * node.`val` + 1
            recover(node.left)
            node.right?.`val` = 2 * node.`val` + 2
            recover(node.right)
        }
        recover(root)
    }

    fun find(target: Int): Boolean {
        fun search(node: TreeNode?): Boolean {
            if (node == null) return false
            if (node.`val` == target) return true
            return search(node.left) || search(node.right)
        }
        return search(root)
    }

}
