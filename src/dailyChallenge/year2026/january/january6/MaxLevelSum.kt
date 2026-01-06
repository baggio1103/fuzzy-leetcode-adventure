package dailyChallenge.year2026.january.january6

fun main() {
    // 989,null,10250,98693,-89388,null,null,null,-32127

    val mapOne = mapOf(1 to 200)
    val mapTwo = mapOf(1 to 300)
    val map = mapOne + mapTwo
    map.maxBy { (_, sum) -> sum }.key
    println(map)
    println(
        maxLevelSum(
            TreeNode(989).apply {
                right = TreeNode(10250).apply {
                    left = TreeNode(98693)
                    right = TreeNode(-89388).apply {
                        right = TreeNode(-32127).apply {}
                    }
                }
            }
        )
    )
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun maxLevelSum(root: TreeNode?): Int {
    val levelMap = mutableMapOf<Int, Int>()
    fun traverse(node: TreeNode?, level: Int) {
        if (node == null) return
        levelMap[level] = levelMap.getOrDefault(level, 0) + node.`val`
        traverse(node.left, level + 1)
        traverse(node.right, level + 1)
    }
    traverse(root, 1)
    return levelMap.maxBy { (_, sum) -> sum }.key
}

// Functional
//fun maxLevelSum(root: TreeNode?): Int {
//    fun traverse(node: TreeNode?, level: Int): Map<Int, Int> {
//        if (node == null) return emptyMap()
//
//        val left = traverse(node.left, level + 1)
//        val right = traverse(node.right, level + 1)
//
//        return listOf(
//            mapOf(level to node.`val`),
//            left,
//            right
//        ).flatMap { it.entries }
//            .groupBy({ it.key }, { it.value })
//            .mapValues { (_, v) -> v.sum() }
//    }
//    return traverse(root, 1).maxBy { (_, sum) -> sum }.key
//}

