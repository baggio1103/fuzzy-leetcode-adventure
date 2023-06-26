package leetcodefavorites.bst

fun main() {
    val  rootEight = TreeNode(120).also {
        it.left = TreeNode(70).also {
            it.left = TreeNode(50).also {
                it.left = TreeNode(20)
                it.right = TreeNode(55)
            }
            it.right = TreeNode(100).also {
                it.left = TreeNode(75)
                it.right = TreeNode(110)
            }
        }
        it.right = TreeNode(140).also {
            it.left = TreeNode(130).also {
                it.left = TreeNode(119)
                it.right = TreeNode(135)
            }
            it.right = TreeNode(160).also {
                it.left = TreeNode(150)
                it.right = TreeNode(200)
            }
        }
    }
    println(isBst(rootEight))
}