package dailyChallenge.year2025.february.february22

import java.util.*


fun main() {
    val route = "1-2--3--4-5--6--7"
    val node = recoverFromPreorder(route)
    println(node)
    val nodeTwo = recoverFromPreorder("1-2--3--4---5---6")
    println(nodeTwo)
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    override fun toString(): String {
        return "$`val`: [left: ${left?.`val`}, right: ${right?.`val`}]"
    }
}

fun recoverFromPreorder(traversal: String): TreeNode? {
    val nodes = route(traversal)
    val root = nodes.first()
    val stack = Stack<Pair<Int, TreeNode>>().also { it.add(root) }
    for (index in 1..nodes.lastIndex) {
        val (newNodeDepth, newNode) = nodes[index]
        val (depth, peek) = stack.peek()
        if (newNodeDepth > depth) {
            peek.left = newNode
        } else if (newNodeDepth == depth) {
            stack.pop()
            stack.peek().second.right = newNode
        } else {
            while (stack.isNotEmpty() && stack.peek().first != newNodeDepth) {
                stack.pop()
            }
            stack.pop()
            stack.peek().second.right = newNode
        }
        stack.push(Pair(newNodeDepth, newNode))

    }
    return root.second
}

fun route(route: String): List<Pair<Int, TreeNode>> {
    var index = 0
    var rootValue = 0
    while (index < route.length && route[index].isDigit()) {
        val digitValue = route[index] - '0'
        rootValue = rootValue * 10 + digitValue
        index++
    }
    val nodes = mutableListOf(Pair(0, TreeNode(rootValue)))
    while (index < route.length) {
        var depth = 0
        while (!route[index].isDigit()) {
            depth++
            index++
        }
        var value = 0
        while (index < route.length && route[index].isDigit()) {
            val digit = route[index] - '0'
            value = value * 10 + digit
            index++
        }
        nodes.add(Pair(depth, TreeNode(value)))
    }
    return nodes
}

