package bytebytego.tree

import java.util.Stack

fun main() {
    val node = invertTree(TreeNode(5)
        .apply {
            left = TreeNode(1).apply {
                left = TreeNode(7)
                right = TreeNode(6)
            }
            right = TreeNode(8).apply { right = TreeNode(4) }
        })
    println(node)

    val nodeOne = invert(node)
    println(nodeOne)
}

fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return null
    val left = invertTree(root.left)
    val right = invertTree(root.right)
    root.left = right
    root.right = left
    return root
}

fun invert(root: TreeNode?): TreeNode? {
    if (root == null) return null
    val stack = Stack<TreeNode>()
    stack.push(root)
    while (stack.isNotEmpty()) {
        val node = stack.pop()
        val left = node.left
        val right = node.right
        node.left = left
        node.right = right
        if (left != null)
            stack.push(left)
        if (right != null)
            stack.push(right)
    }
    return root
}
