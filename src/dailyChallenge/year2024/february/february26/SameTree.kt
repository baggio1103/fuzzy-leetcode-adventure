package dailyChallenge.year2024.february.february26

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String {
        return "Node{val: $`val`}"
    }

}

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean =
    when {
        p == null && q == null -> true
        p?.`val` != q?.`val` -> false
        else -> isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
    }

fun main() {
    println(
        isSameTree(TreeNode(1).apply {
            left = TreeNode(2)
        }, TreeNode(1).apply {
            right = TreeNode(3)
        })
    )
    println(
        isSameTree(TreeNode(1).apply {
            left = TreeNode(2)
            right = TreeNode(3)
        }, TreeNode(1).apply {
            left = TreeNode(2)
            right = TreeNode(3)
        })
    )
}