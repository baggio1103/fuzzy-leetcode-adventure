package bytebytego.tree

fun main() {
    val treeNode = TreeNode(3).apply {
        right = TreeNode(8).apply {
            left = TreeNode(9)
            right = TreeNode(11)
        }
    }
    val serializedString = serialize(treeNode)
    val deserializedTreeNode = deserialize(serializedString)
    requireNotNull(deserializedTreeNode)
    require(deserializedTreeNode.`val` == 3)
    require(deserializedTreeNode.left == null)
    require(deserializedTreeNode.right?.`val` == 8)
    require(deserializedTreeNode.right?.left?.`val` == 9)
    require(deserializedTreeNode.right?.right?.`val` == 11)
}


// Encodes a URL to a shortened URL.
fun serialize(root: TreeNode?): String {
    val stringBuilder = StringBuilder()
    fun serialize(node: TreeNode?) {
        if (node == null) {
            stringBuilder.append("#,")
            return
        }
        stringBuilder.append("${node.`val`},")
        serialize(node.left)
        serialize(node.right)
    }
    serialize(root)
    return stringBuilder.toString()
}

// Decodes your encoded data to tree.
fun deserialize(data: String): TreeNode? {
    var index = 0
    val splitData = data.split(",")
    fun deserialize(): TreeNode? {
        if (index == splitData.size || splitData[index] == "#") return null
        val node = TreeNode(splitData[index].toInt())
        index++
        node.left = deserialize()
        index++
        node.right = deserialize()
        return node
    }

    return deserialize()
}