package bytebytego.tree

fun main() {
    val tree = buildTree(intArrayOf(5, 9, 2, 3, 4, 7), intArrayOf(2, 9, 5, 4, 3, 7))
    require(tree?.`val` == 5)
    require(tree?.left?.`val` == 9)
    require(tree?.right?.`val` == 3)
}

fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
    var curIndex = 0
    val valueIndexes = inorder.mapIndexed { index, value -> value to index }.toMap()
    fun buildTree(
        left: Int,
        right: Int,
    ): TreeNode? {
        if (left > right) return null
        val nodeValue = preorder[curIndex]
        curIndex++
        val root = TreeNode(nodeValue)
        val valueIndex = valueIndexes.getValue(nodeValue)
        root.left = buildTree(left, valueIndex - 1)
        root.right = buildTree(valueIndex + 1, right)
        return root
    }
    return buildTree(0, inorder.size - 1)
}
