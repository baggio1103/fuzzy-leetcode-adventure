package dailyChallenge.year2024.february.february29

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    override fun toString(): String {
        return "TreeNode{val:${`val`}}"
    }
}


fun isEvenOddTree(root: TreeNode?): Boolean {
    // level -> nodes
    val nodeMap = mutableMapOf<Int, MutableList<Int>>()
    traverse(root, 0, nodeMap)
    println(nodeMap)
    for ((level, nodes) in nodeMap) {
        // Even, strictly increasing
        if (level % 2 == 0) {
            // check for odd integer
            if (nodes[0] % 2 == 0) return false
            for (i in 1 until nodes.size) {
                if (nodes[i] <= nodes[i - 1] || nodes[i] % 2 == 0) {
                    return false
                }
            }
            continue
        }
        // Odd
        if (nodes[0] % 2 != 0) return false
        for (i in 1 until nodes.size) {
            if (nodes[i] >= nodes[i - 1] || nodes[i] % 2 != 0) {
                return false
            }
        }
    }
    return true
}

fun traverse(root: TreeNode?, level: Int, nodeMap: MutableMap<Int, MutableList<Int>>) {
    if (root == null) {
        return
    }
    val nodes = nodeMap[level]
    if (nodes == null) {
        nodeMap[level] = mutableListOf(root.`val`)
    } else nodes.add(root.`val`)
    traverse(root.left, level + 1, nodeMap)
    traverse(root.right, level + 1, nodeMap)
}

fun main() {
    println(
        isEvenOddTree(
            TreeNode(1).apply {
                left = TreeNode(10).apply {
                    left = TreeNode(3)
                }
                right = TreeNode(4).apply {
                    left = TreeNode(7)
                    right = TreeNode(1)
                }
            }
        )
    )
    println(
        isEvenOddTree(
            TreeNode(5).apply {
                left = TreeNode(4).apply {
                    left = TreeNode(3)
                    right = TreeNode(3)
                }

                right = TreeNode(2).apply {
                    left = TreeNode(7)
                }

            }
        )
    )
    println(
        isEvenOddTree(
            TreeNode(17).apply {
                left = TreeNode(46)
                right = TreeNode(44).apply {
                    right = TreeNode(13).apply {
                        right = TreeNode(21)
                    }
                }
            }
        )
    )
}