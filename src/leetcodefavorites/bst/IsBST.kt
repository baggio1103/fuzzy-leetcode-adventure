package leetcodefavorites.bst


class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String {
        return "TreeNode{val: $value}"
    }
}

fun isBst(root: TreeNode?): Boolean {
    if (root == null) {
        return true
    }
    val value = root.value - (root.left?.value ?: 0)  > 0 && root.value - (root.right?.value ?: root.value)  <= 0
    println("IsBst: $value. Node value: ${root.value}, nodeLeft: ${root.left?.value}, nodeRight: ${root.right?.value}")
    if (!value) {
        return false
    }
    val left = isBst(root.left)
    val right = isBst(root.right)
    return left && right
}

fun main() {
    println("-=--=-=-=-=-=-=-=")
    val rootOne = TreeNode(5).also {
        it.left = TreeNode(10)
        it.right = TreeNode(12)
    }
    println(
        isBst(rootOne)
    )

    println("-=--=-=-=-=-=-=-=")
    val rootTwo = TreeNode(5).also {
        it.left = TreeNode(1)
        it.right = TreeNode(12)
    }
    println(
        isBst(rootTwo)
    )

    println("-=--=-=-=-=-=-=-=")
    val rootThree = TreeNode(5).also {
        it.left = TreeNode(1)
    }
    println(
        isBst(rootThree)
    )

    println("-=--=-=-=-=-=-=-=")
    val rootFour = TreeNode(5).also {
        it.left = TreeNode(1)
        it.right = TreeNode(4).also {
            it.left = TreeNode(3)
            it.right = TreeNode(6)
        }
    }
    println(
        isBst(rootFour)
    )

    println("-=--=-=-=-=-=-=-=")
    val rootFive = TreeNode(5).also {
        it.left = TreeNode(1)
        it.right = TreeNode(7).also {
            it.left = TreeNode(2)
            it.right = TreeNode(10)
        }
    }
    println(
        isBst(rootFive)
    )
}