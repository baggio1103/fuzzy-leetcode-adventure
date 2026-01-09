package dailyChallenge.year2026.january.january9

fun main() {
    println(subtreeWithAllDeepest(
        TreeNode(3).apply {
            left = TreeNode(5).apply {
                left = TreeNode(6)
                right = TreeNode(2).apply {
                    left = TreeNode(7)
                    right = TreeNode(4)
                }
            }
            right = TreeNode(1).apply {
                left = TreeNode(0)
                left = TreeNode(8)
            }
        }
    ))
    println(subtreeWithAllDeepest(TreeNode(3)))
    println(subtreeWithAllDeepest(TreeNode(0).apply {
        left = TreeNode(1).apply {
            right = TreeNode(2)
        }
        right = TreeNode(3)
    }))
    println(subtreeWithAllDeepest(TreeNode(0).apply {
        left = TreeNode(2)
        right = TreeNode(1).apply {
            left = TreeNode(3)
        }
    }))
}

fun subtreeWithAllDeepest(root: TreeNode?): TreeNode? {
    fun traverse(node: TreeNode?): Pair<Int, TreeNode?> {
        if (node == null) return 0 to null
        val (ld, ln) = traverse(node.left)
        val (rd, rn) = traverse(node.right)
        return when {
            ld > rd -> ld + 1 to ln
            rd > ld -> rd + 1 to rn
            else -> ld + 1 to node
        }
    }
    val (_, node) = traverse(root)
    return node
}

//fun subtreeWithAllDeepest(root: TreeNode?): TreeNode? {
//    fun deepestLevel(node: TreeNode?, level: Int = 1): Int {
//        if (node == null) return level - 1
//        return maxOf(
//            deepestLevel(node.left, level + 1),
//            deepestLevel(node.right, level + 1)
//        )
//    }
//    val deepestLevel = deepestLevel(root)
//    val deepestNodes = mutableSetOf<TreeNode>()
//    val nodeMap = mutableMapOf<TreeNode?, TreeNode>()
//    fun traverse(node: TreeNode?, level: Int = 1) {
//        if (node == null) return
//        nodeMap[node.left] = node
//        nodeMap[node.right] = node
//        if (level == deepestLevel)
//            deepestNodes.add(node)
//        traverse(node.left, level + 1)
//        traverse(node.right, level + 1)
//    }
//    traverse(root)
//    println(deepestNodes)
//    while (deepestNodes.size != 1) {
//        val newNodes = deepestNodes.mapNotNullTo(mutableSetOf()) { deepNode -> nodeMap[deepNode] }
//        deepestNodes.clear()
//        deepestNodes.addAll(newNodes)
//    }
//    return deepestNodes.firstOrNull()
//}
//


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    override fun toString(): String {
        return "TreeNode[$`val``, left: ${left?.`val`}, right: ${right?.`val`}`]"
    }
}
