package dailyChallenge.december.december9

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}


fun inorderTraversal(root: TreeNode?): List<Int> {
    if (root == null) {
        return emptyList()
    }
    return buildList {
        addAll(inorderTraversal(root.left))
        add(root.`val`)
        addAll(inorderTraversal(root.right))
    }
}

fun main() {
    val tree = TreeNode(1).also {
            it.right = TreeNode(2).also {
                it.left = TreeNode(3)
            }
        }
    println(
        inorderTraversal(tree)
    )
}