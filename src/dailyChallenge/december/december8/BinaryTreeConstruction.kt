package dailyChallenge.december.december8


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    
}

fun tree2str(root: TreeNode?, stringBuilder: StringBuilder = StringBuilder()): String {
    if (root == null) {
        return stringBuilder.toString()
    }
    stringBuilder.append(root.`val`)

    if (root.left == null && root.right != null) {
        stringBuilder.append("()")
    }

    root.left?.let {
        stringBuilder.append("(")
    }

    tree2str(root.left, stringBuilder)

    root.left?.let {
        stringBuilder.append(")")
    }

    root.right?.let {
        stringBuilder.append("(")
    }

    tree2str(root.right, stringBuilder)

    root.right?.let {
        stringBuilder.append(")")
    }
    return stringBuilder.toString()
}


fun main() {
    val tree = TreeNode(1).also {
        it.left = TreeNode(2).also {
            it.left = TreeNode(4)
        }
        it.right = TreeNode(3)
    }
    println(tree2str(tree))

    println(
        tree2str(
            TreeNode(1).also {
                it.left = TreeNode(2).also {
                    it.right = TreeNode(4)
                }
                it.right = TreeNode(3)
            }
        )
    )
}