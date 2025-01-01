package dailyChallenge.june.june4

import java.util.Stack

class NumberOfProvinces {

    fun findCircleNum(vertices: Array<IntArray>): Int {
        val nodeSet = HashSet<Int>()
        val provinces = HashSet<Int>()
        val stack = Stack<Int>()
        vertices.forEachIndexed { vertexIndex, nodes ->
            if (!nodeSet.contains(vertexIndex)) {
                provinces.add(vertexIndex)
            }
            nodes.forEachIndexed { index, value ->
                if (index != vertexIndex && value != 0) {
                    stack.push(index)
                    nodeSet.add(index)
                }
            }
            while (stack.isNotEmpty()) {
                val topIndex = stack.pop()
                vertices[topIndex].forEachIndexed { index, value ->
                    if (topIndex != index && value != 0) {
                        if (!nodeSet.contains(index)) {
                            stack.push(index)
                            nodeSet.add(index)
                        }
                    }
                }
            }
        }
        return provinces.size
    }

}