package dailyChallenge.year2024.january.january9.alt

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun leafSimilar(rootOne: TreeNode?, rootTwo: TreeNode?): Boolean {

    fun traverse(root: TreeNode?): List<Int> {
        if (root == null) {
            return emptyList()
        }
        return buildList {
            if (root.left == null && root.right == null) {
                add(root.`val`)
            }
            addAll(traverse(root.left))
            addAll(traverse(root.right))
        }
    }
    return traverse(rootOne) == traverse(rootTwo)
}

fun main() {
    val rootOne = TreeNode(3).also {
        it.left = TreeNode(5).also {
            it.left = TreeNode(6)
            it.right = TreeNode(2).also {
                it.left = TreeNode(7)
                it.right = TreeNode(4)
            }
        }
        it.right = TreeNode(1).also {
            it.left = TreeNode(9)
            it.right = TreeNode(8)
        }
    }
    val rootTwo = TreeNode(3).also {
        it.left = TreeNode(5).also {
            it.left = TreeNode(6)
            it.right = TreeNode(7)
        }
        it.right = TreeNode(1).also {
            it.left = TreeNode(4)
            it.right = TreeNode(2).also {
                it.left = TreeNode(9)
                it.right = TreeNode(8)
            }
        }
    }
    leafSimilar(rootOne, rootTwo)
}

