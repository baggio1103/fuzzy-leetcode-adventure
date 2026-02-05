package bytebytego.tree

import java.util.ArrayDeque

fun main() {
//    println(
//        verticalTraversal(
//            TreeNode(3).apply {
//                left = TreeNode(9)
//                right = TreeNode(20).apply {
//                    left = TreeNode(15)
//                    right = TreeNode(7)
//                }
//            }
//        )
//    )
//    println(
//        verticalTraversal(
//            TreeNode(3).apply {
//                left = TreeNode(1).apply {
//                    left = TreeNode(0)
//                    right = TreeNode(2)
//                }
//                right = TreeNode(4).apply {
//                    left = TreeNode(2)
//                }
//            }
//        )
//    )
//    println(
//        verticalTraversal(
//            TreeNode(1).apply {
//                left = TreeNode(2).apply {
//                    left = TreeNode(4)
//                    right = TreeNode(5)
//                }
//                right = TreeNode(3).apply {
//                    left = TreeNode(6)
//                    right = TreeNode(7)
//                }
//            }
//        )
//    )
//    println(
//        verticalTraversal(
//            TreeNode(1).apply {
//                left = TreeNode(2).apply {
//                    left = TreeNode(4)
//                    right = TreeNode(6)
//                }
//                right = TreeNode(3).apply {
//                    left = TreeNode(5)
//                    right = TreeNode(7)
//                }
//            }
//        )
//    )
    val treeNode = TreeNode(0).apply {
        left = TreeNode(8)
        right = TreeNode(1).apply {
            left = TreeNode(3).apply {
                right = TreeNode(4).apply {
                    right = TreeNode(7)
                }
            }
            right = TreeNode(2).apply {
                left = TreeNode(5).apply {
                    left = TreeNode(6)
                }
            }
        }
    }
    println(
        verticalTraversal(treeNode)
    )
    println(
        verticalQueueTraversal(treeNode)
    )
}

fun verticalTraversal(root: TreeNode?): List<List<Int>> {
    val columns = mutableMapOf<Int, MutableMap<Int, MutableList<Int>>>()
    fun traverse(node: TreeNode?, row: Int, column: Int) {
        if (node == null) return
        columns.getOrPut(column) { mutableMapOf() }
            .getOrPut(row) { mutableListOf() }
            .add(node.`val`)
        traverse(node.left, row + 1, column - 1)
        traverse(node.right, row + 1, column + 1)
    }
    traverse(root, 0, 0)
    return columns.keys.sorted().map { column ->
        val rowsAndColumns = columns.getValue(column)
        rowsAndColumns.keys.sorted().flatMap { row -> rowsAndColumns.getValue(row).sorted() }
    }
}

fun verticalQueueTraversal(root: TreeNode?): List<List<Int>> {
    val columns = mutableMapOf<Int, MutableList<Int>>()
    if (root == null) return emptyList()
    val queue = ArrayDeque<Pair<TreeNode?, Int>>()
    queue.offer(root to 0)
    var minColumn = Int.MAX_VALUE
    var maxColumn = Int.MIN_VALUE
    while (queue.isNotEmpty()) {
        val (node, column) = queue.poll()
        if (node == null) continue
        columns.getOrPut(column) { mutableListOf() }.add(node.`val`)
        minColumn = minOf(minColumn, column)
        maxColumn = maxOf(maxColumn, column)
        queue.offer(node.left to column - 1)
        queue.offer(node.right to column + 1)
    }
    return (minColumn..maxColumn).map { column -> columns.getValue(column) }
}
