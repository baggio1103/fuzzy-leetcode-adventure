package leetcodefavorites.bst


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String {
        return "TreeNode{val: $`val`}"
    }
}

fun isBst(root: TreeNode?, border: Pair<Int?, Int?>? = null): Boolean {
    if (root == null) {
        return true
    }
    println("Val: ${root.`val`} Border: $border")
    if (!inRange(root.`val`, border)) {
        return false
    }
    val leftBorder = border?.let {
        Pair(it.first, root.`val`)
    } ?: run {
        Pair(null, root.`val`)
    }
    val rightBorder = border?.let {
        Pair(root.`val`, it.second)
    } ?: run {
        Pair(root.`val`, null)
    }
    val left = isBst(root.left, leftBorder)
    val right = isBst(root.right, rightBorder)
    return left && right
}

fun inRange(value: Int, border: Pair<Int?, Int?>?): Boolean {
    if (border == null) {
        return true
    }
    val (leftBorder, rightBorder) = border
    if (leftBorder == null && rightBorder == null) {
        return true
    }
    if (leftBorder == null) {
        return value < rightBorder!!
    }
    if (rightBorder == null) {
        return value > leftBorder
    }
    return value > leftBorder && value < rightBorder
}

fun main() {
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
    println("-=--=-=-=-=-=-=-=")
    val rootSix = TreeNode(0)
    println(
        isBst(rootSix)
    )
    println("-=--=-=-=-=-=-=-=")
    val rootSeven = TreeNode(1).also {
        it.right = TreeNode(1)
    }
    println(isBst(rootSeven))
}