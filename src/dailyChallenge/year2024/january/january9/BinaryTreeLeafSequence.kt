package dailyChallenge.year2024.january.january9


var ti = TreeNode(5)
var v = ti.`val`

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun leafSimilar(rootOne: TreeNode?, rootTwo: TreeNode?): Boolean {

    fun traverse(root: TreeNode?, leafValues: MutableList<Int> = mutableListOf()): List<Int> {
        if (root == null) {
            return leafValues
        }
        if (root.left == null && root.right == null) {
            leafValues.add(root.`val`)
            return leafValues
        }
        traverse(root.left, leafValues)
        traverse(root.right, leafValues)
        return leafValues
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
    println(
        "Are the same: ${leafSimilar(rootOne, rootTwo)}"
    )
}

