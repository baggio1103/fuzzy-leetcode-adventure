package dailyChallenge.year2025.february.february22.alternative

import java.util.Stack

fun main() {
    val route = "1-2--3--4-5--6--7"
    val node = recoverFromPreorder(route)
    println(node)
    val nodeTwo = recoverFromPreorder("1-2--3--4---5---6")
    println(nodeTwo)
}

class TreeNode(var `val`: Int, val depth: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
    override fun toString(): String {
        return "val: $`val`, depth: $depth, [left: ${left?.`val`}, right: ${right?.`val`}]"
    }
}

fun recoverFromPreorder(traversal: String): TreeNode {
    val nodes = route(traversal)
    val root = nodes.first()
    val stack = Stack<TreeNode>().also { it.add(root) }
    for (index in 1..nodes.lastIndex) {
        val newNode = nodes[index]
        val peek = stack.peek()
        if (newNode.depth > peek.depth) {
            peek.left = newNode
        } else if (newNode.depth == peek.depth) {
            stack.pop()
            stack.peek().right = newNode
        } else {
            while (stack.isNotEmpty() && stack.peek().depth != newNode.depth) {
                stack.pop()
            }
            stack.pop()
            stack.peek().right = newNode
        }
        stack.push( newNode)
    }
    return root
}

fun route(route: String): List<TreeNode> {
    var index = 0
    var rootValue = 0
    while (index < route.length && route[index].isDigit()) {
        val digitValue = route[index] - '0'
        rootValue = rootValue * 10 + digitValue
        index++
    }
    val nodes = mutableListOf(TreeNode(rootValue, 0))
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
        nodes.add(TreeNode(value, depth))
    }
    return nodes
}

