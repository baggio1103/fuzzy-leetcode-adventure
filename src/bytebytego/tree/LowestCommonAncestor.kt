package bytebytego.tree

fun main() {
    run {
        val pNode = TreeNode(8)
        val qNode = TreeNode(7)
//    println(
//        lowestCommonAncestor(
//            TreeNode(1).apply {
////                left = TreeNode(2).apply {
////                    left = TreeNode(4)
////                    right = TreeNode(5)
////                }
//                right = TreeNode(3).apply {
//                    left = TreeNode(6).apply {
//                        left = pNode
//                        right = TreeNode(9)
//                    }
//                    right = qNode
//                }
//            },
//            pNode,
//            qNode
//        )
//    )
//        println(
//            lowestCommonAncestor(
//                TreeNode(3).apply {
//                    left = TreeNode(6).apply {
//                        left = pNode
//                        right = TreeNode(9)
//                    }
//                    right = qNode
//                },
//                pNode,
//                qNode
//            )
//        )
    }
//    run {
//        val pNode = TreeNode(3)
//        val qNode = TreeNode(2)
//        println(
//            lowestCommonAncestor(
//                TreeNode(1).apply {
//                    left = qNode
//                    right = pNode
//                },
//                pNode,
//                qNode
//            )
//        )
//    }
//    run {
//        val pNode = TreeNode(8)
//        val qNode = TreeNode(4)
//        println(
//            lowestCommonAncestor(
//                TreeNode(-1).apply {
//                    left = TreeNode(0).apply {
//                        left = TreeNode(0).apply {
//                            left = TreeNode(-2).apply {
//                                left = pNode
//                            }
//                        }
//                        right = qNode
//                    }
//                },
//                pNode,
//                qNode
//            )
//        )
//    }

    run {
        val pNode = TreeNode(1)
        val qNode = TreeNode(2)
        println(
            lowestCommonAncestor(
                qNode.apply {
                    right = qNode
                }, pNode, qNode
            )
        )
    }
}

fun lowestCommonAncestor(
    root: TreeNode?,
    p: TreeNode?,
    q: TreeNode?
): TreeNode? {
    if (root == null || root == p || root == q) return root
    val left = lowestCommonAncestor(root.left, p, q)
    val right = lowestCommonAncestor(root.right, p, q)
    return when {
        left != null && right != null -> root
        left != null -> left
        else -> right
    }
}
