package dailyChallenge.year2024.january.january11

import kotlin.math.absoluteValue

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun maxAncestorDiff(root: TreeNode?, maxValue: Int = root?.`val` ?: 0, minValue: Int = root?.`val` ?: 0): Int {
    if (root == null) {
        return (maxValue - minValue).absoluteValue
    }
    val leftTree = maxAncestorDiff(root.left, maxOf(root.`val`, maxValue), minOf(root.`val`, minValue))
    val rightTree = maxAncestorDiff(root.right, maxOf(root.`val`, maxValue), minOf(root.`val`, minValue))
    return maxOf(leftTree, rightTree)
}

fun main() {

    val root = TreeNode(8).also {
        it.left = TreeNode(3).also {
            it.left = TreeNode(1)
            it.right = TreeNode(6).also {
                it.left = TreeNode(4)
                it.left = TreeNode(7)
            }
        }
        it.right = TreeNode(10).also {
            it.left = TreeNode(14).also {
                it.left = TreeNode(13)
            }
        }
    }

    println(
        maxAncestorDiff(root, root.`val`, root.`val`)
    )

    val rootTwo = TreeNode(1).also {
        it.right = TreeNode(2).also {
            it.right = TreeNode(0).also {
                it.right = TreeNode(3)
            }
        }
    }
    println(
        maxAncestorDiff(rootTwo)
    )

}