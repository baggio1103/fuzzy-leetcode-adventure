package dailyChallenge.june.june14

import kotlin.math.absoluteValue

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String {
        return "TreeNode{val: $`val`}"
    }
}

class Solution {

    fun getMinimumDifference(root: TreeNode?): Int {
        val values = mutableListOf<Int>()
        traverse(root, values)
        println(
            values
        )
        var min = Int.MAX_VALUE
        for (i in 0 .. values.lastIndex) {
            for (j in i + 1..values.lastIndex) {
                val diff = (values[j] - values[i]).absoluteValue
                if (diff < min) {
                    min = diff
                }
            }
        }
        return min
    }

    private fun traverse(node: TreeNode?, nodes: MutableList<Int>) {
        if (node == null) {
            return
        }
        nodes.add(node.`val`)
        traverse(node.left, nodes)
        traverse(node.right, nodes)
    }

}

fun main() {
    val solution = Solution()
    println(
        solution.getMinimumDifference(
            TreeNode(20).also {
                it.left = TreeNode(10).also {
                    it.left = TreeNode(15)
                    it.right = TreeNode(17)
                }
                it.right = TreeNode(212)
            }
        )
    )
}