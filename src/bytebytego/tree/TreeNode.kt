package bytebytego.tree

class TreeNode(val `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    override fun toString(): String {
        return "TreeNode[val: ${`val`}]"
    }
}