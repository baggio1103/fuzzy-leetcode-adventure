package dailyChallenge.june.june4

import java.util.Stack

class NumberOfProvinces {

//    fun findCircleNum(vertices: Array<IntArray>): Int {
//
//        val adjacentNodes = Stack<Int>()
//
//        val nodeSet = HashSet<Int>()
//
//        vertices.forEachIndexed { verticesIndex, nodes ->
//            for (i in verticesIndex + 1..nodes.lastIndex) {
//                if (nodes[i] != 0) {
//                    adjacentNodes.push(i + 1)
//                    nodeSet.add(i + 1)
//                    nodeSet.add(i)
//                }
//            }
//            if (!nodeSet.contains(verticesIndex + 1)) {
//                nodeSet.add(verticesIndex + 1)
//            }
//        }
//        println(adjacentNodes)
//        println(nodeSet)
//        return 1
//    }

    fun findCircleNum(vertices: Array<IntArray>): Int {

        val adjacentNodes = Stack<Int>()

        val nodeSet = HashSet<Int>()

        vertices.forEachIndexed { vertexIndex, nodes ->
            for (i in vertexIndex + 1 .. nodes.lastIndex) {
                if (nodes[i] != 0) {
                    println(i)
                    adjacentNodes.push(i)
                    nodeSet.add(i)
                }
            }
            if (!nodeSet.contains(vertexIndex + 1)) {
                nodeSet.add(vertexIndex)
            }
        }
        println(nodeSet)
        return 1
    }

}

fun main() {

    val numberOfProvinces = NumberOfProvinces()
    numberOfProvinces.findCircleNum(
        arrayOf(
            intArrayOf(1, 1, 0),
            intArrayOf(1, 1, 0),
            intArrayOf(0, 0, 1),
        )
    )
    numberOfProvinces.findCircleNum(
        arrayOf(
            intArrayOf(1, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 1),
        )
    )

}