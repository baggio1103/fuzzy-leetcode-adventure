package dailyChallenge.year2026.january.january9

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    override fun toString(): String {
        return "TreeNode[$`val``, left: ${left?.`val`}, right: ${right?.`val`}`]"
    }
}
